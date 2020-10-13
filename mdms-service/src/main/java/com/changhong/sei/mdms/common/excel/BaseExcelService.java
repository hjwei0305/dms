package com.changhong.sei.mdms.common.excel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.changhong.sei.core.cache.CacheBuilder;
import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageInfo;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.entity.BaseEntity;
import com.changhong.sei.edm.dto.UploadResponse;
import com.changhong.sei.edm.sdk.DocumentManager;
import com.changhong.sei.mdms.commom.dto.ProcessResult;
import com.changhong.sei.mdms.common.excel.validate.NotDuplicate;
import com.changhong.sei.notify.dto.NotifyMessage;
import com.changhong.sei.notify.sdk.manager.NotifyManager;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 实现功能：excel导入导出基类
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-10-11 23:18
 */
public abstract class BaseExcelService<E extends BaseEntity, V extends BaseExcelRow> implements IBaseExcelService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseExcelService.class);

    @Autowired
    protected DocumentManager documentManager;
    @Autowired
    protected CacheBuilder cacheBuilder;
    @Autowired
    protected NotifyManager notifyManager;

    protected static final ModelMapper MODEL_MAPPER;

    protected static final int BATCH_COUNT = 500;
    /**
     * 缓存过期时间（2天）
     */
    protected static final long EXPIRE_TIME = 172800000;
    protected static final String PROCESS_CACHE_KEY_PREFIX = "mdms:excel:";

    private final Class<E> entityClass;
    private final Class<V> voClass;
    /**
     * 每隔500条操作一次数据库，然后清理list，方便内存回收
     */
    private final int batchCount;
    private final Set<String> includeColumnFiledNames = new HashSet<>();

    static {
        MODEL_MAPPER = new ModelMapper();
        MODEL_MAPPER.getConfiguration().setFullTypeMatchingRequired(true);
        MODEL_MAPPER.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public BaseExcelService() {
        this(BATCH_COUNT);
    }

    @SuppressWarnings("unchecked")
    public BaseExcelService(int batchCount) {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        Type[] genericTypes = parameterizedType.getActualTypeArguments();
        this.entityClass = (Class<E>) genericTypes[0];
        this.voClass = (Class<V>) genericTypes[1];

        this.batchCount = batchCount;

        Field[] fields = voClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ExcelProperty.class)) {
                includeColumnFiledNames.add(field.getName());
            }
        }
    }

    public enum TypeEnum {
        // 导入
        import_,
        // 导出
        export_
    }

    /**
     * 批导入进度缓存键
     *
     * @param userId 用户Id
     * @return cache key (示例："mdms:excel:import_country:xxxxxxxx")
     */
    public String getProcessCacheKey(TypeEnum type, String userId) {
        return PROCESS_CACHE_KEY_PREFIX.concat(type.name()).concat(entityClass.getSimpleName()).concat(":").concat(userId);
    }

    /**
     * 获取导入导出状态
     *
     * @return 获取导入导出状态
     */
    @Override
    @SuppressWarnings("rawtypes")
    public ResultData<List<ProcessResult>> imExStatus() {
        List<ProcessResult> results = new ArrayList<>();
        String userId = ContextUtil.getUserId();
        ProcessResult<V> importResult = cacheBuilder.get(getProcessCacheKey(TypeEnum.import_, userId));
        if (Objects.nonNull(importResult)) {
            results.add(importResult);
        }
        ProcessResult<V> exportResult = cacheBuilder.get(getProcessCacheKey(TypeEnum.export_, userId));
        if (Objects.nonNull(exportResult)) {
            results.add(exportResult);
        }
        return ResultData.success(results);
    }

    /**
     * excel导入模版数据
     *
     * @return 导入模版数据
     */
    @Override
    public ResultData<Map<String, List<String>>> importTemplateData() {
        // 名称
        List<String> names = new ArrayList<>();
        // 标题
        List<String> examples = new ArrayList<>();

        ExcelProperty property;
        Field[] fields = voClass.getDeclaredFields();
        for (Field field : fields) {
            property = field.getAnnotation(ExcelProperty.class);
            if (Objects.nonNull(property)) {
                String name = property.value()[0];
                names.add(name);

                String data = "文本";
                if (field.isAnnotationPresent(DateTimeFormat.class)) {
                    data = "日期";
                }
                if (field.isAnnotationPresent(NumberFormat.class)) {
                    data = "数字";
                }
                if (field.isAnnotationPresent(NotBlank.class)
                        || field.isAnnotationPresent(NotNull.class)) {
                    data = data.concat("-必填");
                }
                if (field.isAnnotationPresent(NotDuplicate.class)) {
                    data = data.concat("-唯一");
                }
                examples.add(data);
            }
        }
        Map<String, List<String>> map = new HashMap<>();
        map.put("title", names);
        map.put("example", examples);
        return ResultData.success(map);
    }

    /**
     * excel文件数据导入
     *
     * @param file excel文件
     */
    @Override
    @Async
    public void importDataExcel(final MultipartFile file) {
        final String batchId = getProcessCacheKey(TypeEnum.import_, ContextUtil.getUserId());
        ProcessResult<V> processResult = new ProcessResult<>();
        // 批量导入成功【{0}】条，失败【{1}】条！
        processResult.setProgressNote(ContextUtil.getMessage("batch_import_001", 0, 0));
        //
        cacheBuilder.set(batchId, processResult, EXPIRE_TIME);

        try {
            BaseExcelListener<V> excelListener = new BaseExcelListener<V>(voClass, importBatchCount()) {
                @Override
                public void doHandle(List<V> dataList) {
                    doImportHandle(batchId, dataList);
                }

                @Override
                public void doAfterHandle(int totalCount, int successCount, List<V> errorList) {
                    processResult.setFinished(Boolean.TRUE);
                    // 添加错误数据
                    processResult.addFailedItems(errorList);
                    processResult.setTotal((long) totalCount);
                    processResult.setCurrent((long) successCount);
                    // 批量导入成功【{0}】条，失败【{1}】条！
                    processResult.setProgressNote(ContextUtil.getMessage("batch_import_001", successCount, errorList.size()));
                    // 更新缓存
                    cacheBuilder.set(batchId, processResult, EXPIRE_TIME);
                    doImportAfterHandle(processResult);
                }

                @Override
                public boolean customValidate(V data) {
                    return importCustomValidate(data);
                }
            };
            EasyExcelFactory.read(file.getInputStream(), voClass, excelListener)
                    // 指定sheet,默认从0开始
                    .sheet(sheetNo())
                    // 数据读取起始行
                    .headRowNumber(headRowNumber())
                    .doRead();
        } catch (IOException e) {
            LOGGER.error(entityClass.getSimpleName() + "导入失败", e);
        }
    }

    /**
     * @return 读取指定sheet工作表序号, 默认从0开始
     */
    public int sheetNo() {
        return 0;
    }

    /**
     * 读取指定sheet工作表
     * 0 - 该工作表没有头，第一行是数据
     * 1 - 该工作表具有一行标题，这是默认设置
     * 2 - 该工作表有两行标题，第三行是数据
     */
    public int headRowNumber() {
        return 1;
    }

    /**
     * 每隔1000条存储数据库，然后清理list，方便内存回收
     */
    public int importBatchCount() {
        return batchCount;
    }

    /**
     * 处理数据方法
     *
     * @param batchId  当前导入批次id(一次上传导入记为一个batchId)
     * @param dataList 校验通过的解析数据
     */
    @Transactional
    public abstract void doImportHandle(final String batchId, List<V> dataList);

    /**
     * 处理完成方法
     *
     * @param processResult 处理结果
     */
    public void doImportAfterHandle(ProcessResult<V> processResult) {
        // 系统消息提醒
        NotifyMessage message = new NotifyMessage();
        message.setSubject(entityClass.getSimpleName() + "-数据导入处理结果");
        message.setReceiverIds(Lists.newArrayList(ContextUtil.getUserId()));
        message.setContent(processResult.getProgressNote());
        notifyManager.send(message);
    }

    /**
     * 自定义校验逻辑
     *
     * @param data 数据
     * @return 返回验证结果
     */
    public boolean importCustomValidate(V data) {
        return true;
    }

    /**
     * 分页查询导出数据
     *
     * @param search 查询参数
     */
    @Override
    @Async
    public void exportData(Search search) {
        final String batchId = getProcessCacheKey(TypeEnum.export_, ContextUtil.getUserId());
        ProcessResult<V> processResult = new ProcessResult<>();
        // 批量导入成功【{0}】条，失败【{1}】条！
        processResult.setProgressNote(ContextUtil.getMessage("batch_import_001", 0, 0));
        //
        cacheBuilder.set(batchId, processResult, EXPIRE_TIME);

        if (Objects.isNull(search)) {
            search = Search.createSearch();
        }
        PageInfo pageInfo = search.getPageInfo();
        if (Objects.isNull(pageInfo)) {
            pageInfo = new PageInfo();
        }
        // 重置每页大小
        pageInfo.setRows(batchCount);
        search.setPageInfo(pageInfo);

        ExcelWriterSheetBuilder writerSheetBuilder;
        PageResult<V> pageResult = exportDataByPage(search);
        // 设置总数
        processResult.setTotal(pageResult.getRecords());
        // 设置一样的总数,更新完成状态
        processResult.setCurrent(pageResult.getRecords());
        if (pageResult.getRecords() > 0) {
            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                // 这里 需要指定写用哪个class去写
                writerSheetBuilder = EasyExcelFactory.write(outputStream, voClass).sheet(entityClass.getSimpleName());
                if (includeColumnFiledNames.size() > 0) {
                    writerSheetBuilder.includeColumnFiledNames(includeColumnFiledNames);
                }

                // 当前页码
                int page = pageResult.getPage();
                // 总页数
                int totalPage = pageResult.getTotal();

                List<V> dataList;
                do {
                    dataList = pageResult.getRows();
                    writerSheetBuilder.doWrite(dataList);
                    dataList.clear();

                    pageInfo.setPage(page++);
                    search.setPageInfo(pageInfo);
                    pageResult = exportDataByPage(search);
                } while (page < totalPage);

                try (InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray())) {
                    UploadResponse uploadResponse = documentManager.uploadDocument(entityClass.getSimpleName() + ".xlsx", inputStream);
                    if (Objects.nonNull(uploadResponse)) {
                        processResult.setDocId(uploadResponse.getDocId());
                    }
                    // 更新状态为完成
                    processResult.setFinished(Boolean.TRUE);
                    // 导出【{0}】数据【{1}】条！
                    processResult.setProgressNote(ContextUtil.getMessage("batch_export_001", entityClass.getSimpleName(), pageResult.getRecords()));
                } catch (Exception e) {
                    LOGGER.error(entityClass.getSimpleName() + "数据导出异常", e);
                    // 导出【{0}】数据异常: {1}
                    processResult.setProgressNote(ContextUtil.getMessage("batch_export_001", entityClass.getSimpleName(), e.getMessage()));
                }
            } catch (Exception e) {
                LOGGER.error(entityClass.getSimpleName() + "数据导出异常", e);
                processResult.setProgressNote(ContextUtil.getMessage("batch_export_001", entityClass.getSimpleName(), e.getMessage()));
            }
        }

        // 加入缓存
        cacheBuilder.set(batchId, processResult, EXPIRE_TIME);

        doExportAfterHandle(processResult);
    }

    /**
     * 分页导出数据
     *
     * @param search 分页查询对象
     * @return 返回分页查询结果
     */
    private PageResult<V> exportDataByPage(Search search) {
        PageResult<E> pageResult = findByPage(search);

        return convertToVoPageResult(pageResult);
    }

    /**
     * 分页导出数据
     *
     * @param search 分页查询对象
     * @return 返回分页查询结果
     */
    public abstract PageResult<E> findByPage(Search search);

    public PageResult<V> convertToVoPageResult(PageResult<E> pageResult) {
        PageResult<V> result = new PageResult<>(pageResult);
        List<E> eList = pageResult.getRows();
        if (CollectionUtils.isNotEmpty(eList)) {
            List<V> voList = eList.stream()
                    .map(e -> MODEL_MAPPER.map(e, voClass)).collect(Collectors.toList());
            result.setRows(voList);

            eList.clear();
        }
        return result;
    }

    /**
     * 处理完成方法
     *
     * @param processResult 处理结果
     */
    public void doExportAfterHandle(ProcessResult<V> processResult) {
        // 系统消息提醒
        NotifyMessage message = new NotifyMessage();
        message.setSubject(entityClass.getSimpleName() + "-数据导出处理结果");
        message.setReceiverIds(Lists.newArrayList(ContextUtil.getUserId()));
        message.setContent(processResult.getProgressNote());
        notifyManager.send(message);
    }
}
