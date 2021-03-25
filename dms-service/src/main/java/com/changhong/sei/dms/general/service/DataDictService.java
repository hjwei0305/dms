package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.context.SessionUser;
import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.log.LogUtil;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResult;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.dms.commom.Constants;
import com.changhong.sei.dms.general.dao.DataDictDao;
import com.changhong.sei.dms.general.dao.DataDictItemDao;
import com.changhong.sei.dms.general.entity.DataDict;
import com.changhong.sei.dms.general.entity.DataDictItem;
import com.changhong.sei.enums.UserAuthorityPolicy;
import com.changhong.sei.exception.ServiceException;
import org.apache.commons.collections.CollectionUtils;
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
@CacheConfig(cacheNames = "dms:dataDict")
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
    @Transactional(rollbackFor = Exception.class)
    public OperateResultWithData<DataDict> save(DataDict entity) {
        if (UserAuthorityPolicy.GlobalAdmin.equals(ContextUtil.getSessionUser().getAuthorityPolicy())) {
            // 如果是修改，检查代码禁止修改以及是否为私有
            if (!entity.isNew()) {
                DataDict dataDict = dao.findOne(entity.getId());
                if (!StringUtils.equals(dataDict.getCode(), entity.getCode())) {
                    // 数据字典的代码禁止修改！
                    return OperateResultWithData.operationFailure("00001");
                }
            }
            return super.save(entity);
        } else {
            // 数据字典类型只有全局管理员用户才能维护！
            return OperateResultWithData.operationFailure("00002");
        }
    }

    /**
     * 删除数据保存数据之前额外操作回调方法 子类根据需要覆写添加逻辑即可
     *
     * @param id 待删除数据对象主键
     */
    @Override
    protected OperateResult preDelete(String id) {
        if (UserAuthorityPolicy.GlobalAdmin.equals(ContextUtil.getSessionUser().getAuthorityPolicy())) {
            if (dictItemDao.existsDataDictItemByDataDictId(id)) {
                // 数据字典存在字典项，禁止修改！
                return OperateResult.operationFailure("00003");
            }
            return super.preDelete(id);
        } else {
            // 数据字典类型只有全局管理员用户才能维护！
            return OperateResult.operationFailure("00002");
        }
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

        if (StringUtils.isNotBlank(dictItem.getId())) {
            DataDictItem item = dictItemDao.findOne(dictItem.getId());
            // 非当前租户数据字典项，禁止维护
            if (Objects.nonNull(item) && !StringUtils.equals(ContextUtil.getTenantCode(), item.getTenantCode())) {
                // 非租户数据字典项，禁止维护！
                throw new ServiceException(ContextUtil.getMessage("00014"));
            }
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
        // 非当前租户数据字典项，禁止维护
        if (!StringUtils.equals(ContextUtil.getTenantCode(), dataDictItem.getTenantCode())) {
            // 非租户数据字典项，禁止维护！
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
     * @param includeFrozen 包含已冻结
     * @return 数据字典项清单
     */
    @Cacheable
    public List<DataDictItem> getDataDictItems(String dataDictId, Boolean includeFrozen) {
        List<DataDictItem> items;
        // 获取当前租户的字典项
        items = this.getDataDictItems(dataDictId, ContextUtil.getTenantCode(), includeFrozen);
        if (CollectionUtils.isEmpty(items)) {
            // 如果租户私有的不存在，获取全局租户的字典项
            items = this.getDataDictItems(dataDictId, Constants.DEFAULT_TENANT, includeFrozen);
        }
        return items;
    }

    /**
     * 通过字典Id获取字典项
     *
     * @param dataDictId    字典Id
     * @param tenantCode    租户代码
     * @param includeFrozen 包含已冻结
     * @return 数据字典项清单
     */
    private List<DataDictItem> getDataDictItems(String dataDictId, String tenantCode, Boolean includeFrozen) {
//        // 检查语种是否和当前上下文一致
//        if (!StringUtils.equals(lang, ContextUtil.getLocaleLang())) {
//            String errorMsg = "输入的语言代码【" + lang + "】和当前会话【" + ContextUtil.getLocaleLang() + "】不一致！";
//            throw new ServiceException(errorMsg);
//        }
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

    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(allEntries = true)
    public ResultData<Boolean> batchSaveDataDict(DataDict dataDict, List<DataDictItem> dataDictItemList) {
        try {
            DataDict dict = this.findByProperty(DataDict.CODE_FIELD, dataDict.getCode());
            boolean checkFlag = true;
            if (Objects.isNull(dict)) {
                checkFlag = false;
                OperateResultWithData<DataDict> result = this.save(dataDict);
                if (Boolean.TRUE.equals(result.getSuccess())) {
                    dataDict = result.getData();
                } else {
                    return ResultData.fail("生成字典出错");
                }
            } else {
                dataDict = dict;
            }
            // 字典id
            String dctId = dataDict.getId();
            // 租户代码
            String tenantCode = ContextUtil.getTenantCode();
            List<DataDictItem> saveList = new ArrayList<>();
            for (DataDictItem item : dataDictItemList) {
                item.setDataDictId(dctId);
                item.setTenantCode(tenantCode);
                if (checkFlag) {
                    DataDictItem existItem = dictItemDao.findByDataDictIdAndDataNameAndTenantCode(dctId, item.getDataName(), tenantCode);
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
     * @param includeFrozen 包含已冻结
     * @return 数据字典项清单
     */
    public DataDictItem getDataDictItem(String dataDictId, String dataName, Boolean includeFrozen) {
        // 获取当前租户的字典项
        DataDictItem dictItem = getDataDictItem(dataDictId, dataName, ContextUtil.getTenantCode(), includeFrozen);
        if (Objects.isNull(dictItem)) {
            // 如果租户私有不存在，获取全局租户的字典项
            dictItem = getDataDictItem(dataDictId, dataName, Constants.DEFAULT_TENANT, includeFrozen);
        }
        return dictItem;
    }

    /**
     * 获取指定字典项
     *
     * @param dataDictId    字典Id
     * @param dataName      展示值
     * @param tenantCode    租户代码
     * @param includeFrozen 包含已冻结
     * @return 数据字典项清单
     */
    private DataDictItem getDataDictItem(String dataDictId, String dataName, String tenantCode, Boolean includeFrozen) {
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

    /**
     * 字典项转为(取消)租户私有
     *
     * @param dictId 字典id
     * @param action 操作(true or false)
     * @return 操作结果
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData<Void> tenantPrivate(String dictId, boolean action) {
        SessionUser sessionUser = ContextUtil.getSessionUser();
        if (UserAuthorityPolicy.TenantAdmin.equals(sessionUser.getAuthorityPolicy())) {
            DataDict dataDict = dao.findOne(dictId);
            if (Objects.isNull(dataDict)) {
                // 数据字典【{0}】不存在！
                return ResultData.fail(ContextUtil.getMessage("00004"));
            }
            // 租户代码
            String tenantCode = sessionUser.getTenantCode();
            if (StringUtils.equals(Constants.DEFAULT_TENANT, tenantCode)) {
                // 只允许租户管理员维护
                return ResultData.fail(ContextUtil.getMessage("00021"));
            }
            // 获取租户下的字典项
            List<DataDictItem> itemList = this.getDataDictItems(dictId, tenantCode, true);
            if (action) {
                // 转为租户私有
                if (CollectionUtils.isNotEmpty(itemList)) {
                    return ResultData.fail("租户下存在私有字典项,禁止重复操作!");
                }
                itemList = this.getDataDictItems(dictId, Constants.DEFAULT_TENANT, true);
                if (CollectionUtils.isNotEmpty(itemList)) {
                    DataDictItem dictItem;
                    List<DataDictItem> dictItemList = new ArrayList<>();
                    for (DataDictItem item : itemList) {
                        dictItem = new DataDictItem();
                        dictItem.setDataDictId(dictId);
                        dictItem.setDataName(item.getDataName());
                        dictItem.setDataValue(item.getDataValue());
                        dictItem.setFrozen(item.getFrozen());
                        dictItem.setRank(item.getRank());
                        dictItem.setRemark(item.getRemark());
                        dictItemList.add(dictItem);
                    }
                    dictItemDao.save(dictItemList);
                }
            } else {
                // 取消租户私有
                if (CollectionUtils.isNotEmpty(itemList)) {
                    // 提交删除
                    dictItemDao.deleteAll(itemList);
                }
            }
            return ResultData.success();
        } else {
            // 只允许租户管理员维护
            return ResultData.fail(ContextUtil.getMessage("00021"));
        }
    }
}
