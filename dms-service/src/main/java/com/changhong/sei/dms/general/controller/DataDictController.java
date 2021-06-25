package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResult;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.core.utils.ResultDataUtil;
import com.changhong.sei.dms.general.api.DataDictApi;
import com.changhong.sei.dms.general.dto.DataDictBatchSaveDto;
import com.changhong.sei.dms.general.dto.DataDictDto;
import com.changhong.sei.dms.general.dto.DataDictItemDto;
import com.changhong.sei.dms.general.dto.DataDictValue;
import com.changhong.sei.dms.general.entity.DataDict;
import com.changhong.sei.dms.general.entity.DataDictItem;
import com.changhong.sei.dms.general.service.DataDictService;
import com.changhong.sei.dms.multilingual.sdk.annotation.MultilingualEnable;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 实现功能: 数据字典API服务实现
 *
 * @author 王锦光 wangjg
 * @version 2020-01-27 8:39
 */
@RestController
@Api(value = "DataDictApi", tags = "数据字典API服务实现")
@RequestMapping(path = "dataDict", produces = MediaType.APPLICATION_JSON_VALUE)
public class DataDictController extends BaseEntityController<DataDict, DataDictDto>
        implements DataDictApi {
    @Autowired
    private DataDictService service;

    /**
     * 字典项DTO转换为Entity的转换器
     */
    private static final ModelMapper itemEntityModelMapper;
    /**
     * 字典项Entity转换为DTO的转换器
     */
    private static final ModelMapper itemDtoModelMapper;

    // 初始化静态属性
    static {
        // 初始化DTO转换为Entity的转换器
        itemEntityModelMapper = new ModelMapper();
        // 设置为严格匹配
        entityModelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        // 初始化Entity转换为DTO的转换器
        itemDtoModelMapper = new ModelMapper();
        // 创建自定义映射规则
        PropertyMap<DataDictItem, DataDictItemDto> propertyMap = new PropertyMap<DataDictItem, DataDictItemDto>() {
            @Override
            protected void configure() {
                // 使用自定义转换规则
                map().setDataDictId(source.getDataDictId());
            }
        };
        // 添加映射器
        itemDtoModelMapper.addMappings(propertyMap);
    }

    @Override
    public BaseEntityService<DataDict> getService() {
        return service;
    }

    /**
     * 将字典项数据实体转换为DTO
     *
     * @param entity 数据实体
     * @return 数据字典项DTO
     */
    private DataDictItemDto convertItemToDto(DataDictItem entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        // 转换
        return itemDtoModelMapper.map(entity, DataDictItemDto.class);
    }

    /**
     * 将字典项DTO转换为数据实体
     *
     * @param dto 数据字典项DTO
     * @return 数据实体
     */
    private DataDictItem convertItemToEntity(DataDictItemDto dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        return itemEntityModelMapper.map(dto, DataDictItem.class);
    }

    /**
     * 保存字典项目
     *
     * @param dictItemDto 字典项目
     * @return 返回保存字典项目的结果
     */
    @Override
    public ResultData<DataDictItemDto> saveDictItem(DataDictItemDto dictItemDto) {
        // 转换行项目DTO为entity
        DataDictItem item = convertItemToEntity(dictItemDto);
        if (Objects.nonNull(item)) {
            OperateResultWithData<DataDictItem> saveResult = service.saveDictItem(item);
            return ResultDataUtil.convertFromOperateResult(saveResult, convertItemToDto(saveResult.getData()));
        } else {
            return ResultData.fail(ContextUtil.getMessage("00008", dictItemDto));
        }
    }

    /**
     * 删除字典项目
     *
     * @param id 字典项目id
     * @return 返回保存字典项目的结果
     */
    @Override
    public ResultData<Void> deleteDictItem(String id) {
        OperateResult result = service.deleteDictItem(id);
        return ResultDataUtil.convertFromOperateResult(result);
    }

    /**
     * 通过字典Id获取字典项
     *
     * @param dataDictId 字典Id
     * @return 数据字典项清单
     */
    @Override
    public ResultData<List<DataDictItemDto>> getDataDictItems(String dataDictId) {
        // 获取数据字典
        DataDict dataDict = service.findOne(dataDictId);
        if (Objects.isNull(dataDict)) {
            return ResultData.success(new ArrayList<>());
        }
        return ResultData.success(getDataDictItemDtos(dataDict, true));
    }

    /**
     * 通过字典代码，获取可以使用的数据字典值
     *
     * @param dictCode 字典代码
     * @return 可使用的数据字典值
     */
    @Override
//    @MultilingualEnable(className = "com.changhong.sei.dms.general.dto.DataDictValue", propertyNames = {"dataName"})
    public ResultData<List<DataDictValue>> getCanUseDataDictValues(String dictCode) {
        // 获取数据字典
        DataDict dataDict = service.findByCode(dictCode);
        if (Objects.isNull(dataDict)) {
            return ResultData.success(new ArrayList<>());
        }
        List<DataDictItemDto> itemDtos = getDataDictItemDtos(dataDict, false);
        return ResultData.success(convertToDataDictValue(itemDtos));
    }

    /**
     * 通过字典代码和字典项展示值，获取指定可以使用的数据字典值
     *
     * @param dictCode 字典代码
     * @param dataName 展示值
     * @return 可使用的指定数据字典值
     */
    @Override
    public ResultData<DataDictValue> getCanUseDataDictValue(String dictCode, String dataName) {
        // 获取数据字典
        DataDict dataDict = service.findByCode(dictCode);
        if (Objects.isNull(dataDict)) {
            return ResultData.success(null);
        }
        DataDictItemDto itemDto = getDataDictItemDto(dataDict, dataName, false);
        return ResultData.success(convertToDataDictValue(itemDto));
    }

    @Override
    public ResultData<Boolean> batchSaveDataDict(DataDictBatchSaveDto batchDataDictSaveDto) {
        DataDict dataDict = convertToEntity(batchDataDictSaveDto.getDataDictDto());
        List<DataDictItem> list = batchDataDictSaveDto.getDataDictItemDtoList().stream().map(this::convertItemToEntity).collect(Collectors.toList());
        return service.batchSaveDataDict(dataDict, list);
    }

    /**
     * 获取数据字典项DTO清单
     *
     * @param dataDict      数据字典
     * @param includeFrozen 包含已冻结
     * @return 数据字典项DTO清单
     */
    private List<DataDictItemDto> getDataDictItemDtos(DataDict dataDict, boolean includeFrozen) {
        List<DataDictItem> items = service.getDataDictItems(dataDict.getId(), includeFrozen);
        return items.stream().map(this::convertItemToDto).collect(Collectors.toList());
    }

    /**
     * 获取指定数据字典项DTO
     *
     * @param dataDict      数据字典
     * @param dataName      展示值
     * @param includeFrozen 包含已冻结
     * @return 指定数据字典项DTO
     */
    private DataDictItemDto getDataDictItemDto(DataDict dataDict, String dataName, boolean includeFrozen) {
        DataDictItem item = service.getDataDictItem(dataDict.getId(), dataName, includeFrozen);
        return convertItemToDto(item);
    }

    /**
     * 将数据字典项DTO转换为数据字典值
     *
     * @param itemDtos 数据字典项DTO
     * @return 数据字典值
     */
    private List<DataDictValue> convertToDataDictValue(List<DataDictItemDto> itemDtos) {
        List<DataDictValue> dictValues = new LinkedList<>();
        itemDtos.forEach(itemDto -> {
            DataDictValue dictValue = entityModelMapper.map(itemDto, DataDictValue.class);
            dictValues.add(dictValue);
        });
        return dictValues;
    }

    /**
     * 将数据字典项DTO转换为数据字典值
     *
     * @param itemDto 数据字典项DTO
     * @return 数据字典值
     */
    private DataDictValue convertToDataDictValue(DataDictItemDto itemDto) {
        if (Objects.isNull(itemDto)) {
            return null;
        }
        return entityModelMapper.map(itemDto, DataDictValue.class);
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<DataDictDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }

    /**
     * 字典项转为(取消)租户私有
     *
     * @param dictId 字典id
     * @param action 操作(true or false)
     * @return 操作结果
     */
    @Override
    public ResultData<Void> tenantPrivate(String dictId, boolean action) {
        return service.tenantPrivate(dictId, action);
    }
}
