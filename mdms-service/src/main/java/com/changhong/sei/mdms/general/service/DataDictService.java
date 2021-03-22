package com.changhong.sei.mdms.general.service;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.log.LogUtil;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResult;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.exception.ServiceException;
import com.changhong.sei.mdms.common.Constants;
import com.changhong.sei.mdms.general.dao.DataDictDao;
import com.changhong.sei.mdms.general.dao.DataDictItemDao;
import com.changhong.sei.mdms.general.entity.DataDict;
import com.changhong.sei.mdms.general.entity.DataDictItem;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@CacheConfig(cacheNames = "dataDict-cache")
public class DataDictService extends BaseEntityService<DataDict> {

    private static final Logger log = LoggerFactory.getLogger(DataDictService.class);

    @Autowired
    private DataDictDao dao;
    @Autowired
    private DataDictItemDao dictItemDao;

    @Override
    protected BaseEntityDao<DataDict> getDao() {
        return dao;
    }

    /**
     * 通过代码获取数据字典
     *
     * @param code 字典代码
     * @return 数据字典
     */
    public DataDict findByCode(String code) {
        return dao.findByCode(code);
    }

    /**
     * 保存数据字典
     *
     * @param entity 数据字典
     */
    @Override
    public OperateResultWithData<DataDict> save(DataDict entity) {
        // 如果是修改，检查代码禁止修改以及是否为私有
        if (!entity.isNew()) {
            DataDict dataDict = dao.findOne(entity.getId());
            if (!StringUtils.equals(dataDict.getCode(), entity.getCode())) {
                // 数据字典的代码禁止修改！
                return OperateResultWithData.operationFailure("00001");
            }
            if (!dataDict.getTenantPrivate() == entity.getTenantPrivate()) {
                // 数据字典的租户私有属性禁止修改！
                return OperateResultWithData.operationFailure("00002");
            }
        }
        return super.save(entity);
    }

    /**
     * 删除数据保存数据之前额外操作回调方法 子类根据需要覆写添加逻辑即可
     *
     * @param id 待删除数据对象主键
     */
    @Override
    protected OperateResult preDelete(String id) {
        if (dictItemDao.existsDataDictItemByDataDictId(id)) {
            // 数据字典存在字典项，禁止修改！
            return OperateResult.operationFailure("00003");
        }
        return super.preDelete(id);
    }

    /**
     * 删除数据字典
     *
     * @param id 数据字典Id
     * @return 返回操作结果对象
     */
    @Override
    public OperateResult delete(final String id) {
        return super.delete(id);
    }

    /**
     * 保存字典项目
     *
     * @param dictItem 字典项目
     * @return 返回保存字典项目的结果
     */
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(allEntries = true)
    public OperateResultWithData<DataDictItem> saveDictItem(DataDictItem dictItem) {
        // 获取数据字典
        DataDict dataDict = dao.findOne(dictItem.getDataDictId());
        if (Objects.isNull(dataDict)) {
            // 数据字典【{0}】不存在！
            return OperateResultWithData.operationFailure("00004", dictItem.getDataDictId());
        }
        // 字典Id
        String dataDictId = dataDict.getId();
        // 展示值
        String dataName = dictItem.getDataName();
        // 使用值
        String dataValue = dictItem.getDataValue();
        // 租户代码
        String tenantCode = ContextUtil.getTenantCode();
        if (StringUtils.isBlank(tenantCode) || ContextUtil.isAnonymous()) {
            //如果没有租户值, 或是匿名用户禁止维护数据字典
            return OperateResultWithData.operationFailure("00005");
        }
        // 如果是全局字典，禁止租户用户维护
        if (!dataDict.getTenantPrivate() && !StringUtils.equals(tenantCode, Constants.DEFAULT_TENANT)) {
            // 全局数据字典，禁止租户用户维护！
            throw new ServiceException(ContextUtil.getMessage("00014"));
        }
        DataDictItem item = dictItemDao.findByDataDictIdAndDataNameAndTenantCode(dataDictId, dataName, tenantCode);
        if (Objects.nonNull(item) && !StringUtils.equals(item.getId(), dictItem.getId())) {
            // 数据字典【{0}】存在相同的展示值【{1}】
            return OperateResultWithData.operationFailure("00006", dataDict.getName(), dataName);
        }
        item = dictItemDao.findByDataDictIdAndDataValueAndTenantCode(dataDictId, dataValue, tenantCode);
        if (Objects.nonNull(item) && !StringUtils.equals(item.getId(), dictItem.getId())) {
            // 数据字典【{0}】存在相同的使用值【{1}】
            return OperateResultWithData.operationFailure("00007", dataDict.getName(), dataValue);
        }
        // 提交保存
        dictItemDao.save(dictItem);
        // 保存成功！
        return OperateResultWithData.operationSuccessWithData(dictItem, "00013");
    }

    /**
     * 删除字典项
     *
     * @param id 字典项目id
     * @return 操作结果
     */
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(allEntries = true)
    public OperateResult deleteDictItem(String id) {
        DataDictItem dataDictItem = dictItemDao.findOne(id);
        if (Objects.isNull(dataDictItem)) {
            // 数据字典项【{0}】不存在！
            return OperateResult.operationFailure("00008", id);
        }
        DataDict dataDict = dataDictItem.getDataDict();
        // 如果是全局字典，禁止租户用户维护
        if (!dataDict.getTenantPrivate() && !StringUtils.equals(ContextUtil.getTenantCode(), Constants.DEFAULT_TENANT)) {
            // 全局数据字典，禁止租户用户维护！
            throw new ServiceException(ContextUtil.getMessage("00014"));
        }
        // 提交删除
        dictItemDao.delete(dataDictItem);
        return OperateResult.operationSuccess();
    }

    /**
     * 通过字典Id获取字典项
     *
     * @param dataDictId    字典Id
     * @param tenantCode    租户代码
     * @param includeFrozen 包含已冻结
     * @return 数据字典项清单
     */
    @Cacheable
    public List<DataDictItem> getDataDictItems(String dataDictId, String tenantCode, Boolean includeFrozen, String lang) {
        // 检查语种是否和当前上下文一致
        if (!StringUtils.equals(lang, ContextUtil.getLocaleLang())) {
            String errorMsg = "输入的语言代码【" + lang + "】和当前会话【" + ContextUtil.getLocaleLang() + "】不一致！";
            throw new ServiceException(errorMsg);
        }
        if (includeFrozen) {
            // 打印日志，显示是否执行数据库查询
            LogUtil.bizLog("通过字典Id【{}】获取租户【{}】所有字典项", dataDictId, tenantCode);
            return dictItemDao.findByDictId(dataDictId, tenantCode);
        } else {
            // 打印日志，显示是否执行数据库查询
            LogUtil.bizLog("通过字典Id【{}】获取租户【{}】可用字典项", dataDictId, tenantCode);
            // 获取未冻结的数据
            return dictItemDao.findByDictIdUnfrozen(dataDictId, tenantCode);
        }
    }

    @Transactional
    @CacheEvict(allEntries = true)
    public ResultData<Boolean> batchSaveDataDict(DataDict dataDict, List<DataDictItem> dataDictItemList) {
        try {
            DataDict d = this.findByProperty("code", dataDict.getCode());
            boolean checkFlag = true;
            if (Objects.isNull(d)) {
                checkFlag = false;
                dataDict.setTenantPrivate(false);
                OperateResultWithData<DataDict> result = this.save(dataDict);
                if (Boolean.TRUE.equals(result.getSuccess())) {
                    dataDict = result.getData();
                } else {
                    return ResultData.fail("生成字典出错");
                }
            } else {
                dataDict = d;
            }
            List<DataDictItem> saveList = new ArrayList<>();
            for (DataDictItem item : dataDictItemList) {
                item.setDataDictId(dataDict.getId());
                item.setDataDict(dataDict);
                item.setTenantCode(ContextUtil.getTenantCode());
                if (Boolean.TRUE.equals(checkFlag)) {
                    DataDictItem existItem = dictItemDao.findByDataDictIdAndDataNameAndTenantCode(dataDict.getId(),
                            item.getDataName(), ContextUtil.getTenantCode());
                    if (Objects.isNull(existItem)) {
                        saveList.add(item);
                    } else if (!existItem.getDataValue().equals(item.getDataValue())) {
                        existItem.setDataValue(item.getDataValue());
                        saveList.add(existItem);
                    }
                }
            }
            dictItemDao.saveAll(saveList);
            return ResultData.success(Boolean.TRUE);
        } catch (Exception ex) {
            log.error("批量新增数据字典出错", ex);
        }
        return ResultData.success(Boolean.FALSE);
    }

    /**
     * 获取指定字典项
     *
     * @param dataDictId    字典Id
     * @param dataName      展示值
     * @param tenantCode    租户代码
     * @param includeFrozen 包含已冻结
     * @param lang          语言
     * @return 数据字典项清单
     */
    public DataDictItem getDataDictItem(String dataDictId, String dataName, String tenantCode, Boolean includeFrozen, String lang) {
        // 检查语种是否和当前上下文一致
        if (!StringUtils.equals(lang, ContextUtil.getLocaleLang())) {
            String errorMsg = "输入的语言代码【" + lang + "】和当前会话【" + ContextUtil.getLocaleLang() + "】不一致！";
            throw new ServiceException(errorMsg);
        }
        if (includeFrozen) {
            // 打印日志，显示是否执行数据库查询
            LogUtil.bizLog("通过字典Id【{}】DataName【{}】获取租户【{}】指定字典项", dataDictId, dataName, tenantCode);
            return dictItemDao.findByDictIdAndDataName(dataDictId, dataName, tenantCode);
        } else {
            // 打印日志，显示是否执行数据库查询
            LogUtil.bizLog("通过字典Id【{}】DataName【{}】获取租户【{}】指定可用字典项", dataDictId, dataName, tenantCode);
            // 获取未冻结的数据
            return dictItemDao.findByDictIdAndDataNameUnfrozen(dataDictId, dataName, tenantCode);
        }
    }
}
