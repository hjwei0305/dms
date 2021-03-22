package com.changhong.sei.dms.management.service;

import com.changhong.sei.core.cache.CacheBuilder;
import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.dms.common.Constants;
import com.changhong.sei.dms.management.dao.DataDefinitionDao;
import com.changhong.sei.dms.management.dto.EntityDto;
import com.changhong.sei.dms.management.entity.DataConfig;
import com.changhong.sei.dms.management.entity.DataDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


/**
 * 主数据定义(DataDefinition)业务逻辑实现类
 *
 * @author sei
 * @since 2020-08-13 22:47:16
 */
@Service("dataDefinitionService")
public class DataDefinitionService extends BaseEntityService<DataDefinition> {
    @Autowired
    private CacheBuilder cacheBuilder;
    @Autowired
    private DataDefinitionDao dao;
    @Autowired
    private DataConfigService configService;

    @Override
    protected BaseEntityDao<DataDefinition> getDao() {
        return dao;
    }

    @Transactional
    public ResultData<String> doFrozen(String id, boolean frozen) {
        DataDefinition definition = dao.findOne(id);
        if (Objects.isNull(definition)) {
            // 未找到对应注册的主数据
            return ResultData.fail(ContextUtil.getMessage("00020"));
        }
        definition.setFrozen(frozen);
        OperateResultWithData<DataDefinition> result = this.save(definition);
        if (result.successful()) {
            return ResultData.success(result.getMessage());
        } else {
            return ResultData.fail(result.getMessage());
        }
    }

    public ResultData<List<EntityDto>> getAllMasterDataEntities() {
        List<EntityDto> entityDtos = cacheBuilder.get(Constants.ENTITY_CACHE_KEY);
        return ResultData.success(entityDtos);
    }

    /**
     * 获取指定表字段信息
     *
     * @param code 主数据代码
     * @return 返回指定表字段清单
     */
    public ResultData<List<EntityDto.Property>> getPropertiesByCode(String code) {
        List<EntityDto.Property> dtos = cacheBuilder.get(Constants.PROPERTY_CACHE_KEY + code);
        return ResultData.success(dtos);
    }

    /**
     * 获取指定主数据的UI配置
     *
     * @param id id
     * @return UI配置
     */
    public List<DataConfig> getConfigById(String id) {
        return configService.findListByProperty(DataConfig.DATA_DEFINITION_ID, id);
    }

    /**
     * 保存主数据的UI配置
     *
     * @param config ui配置
     * @return 返回保存结果
     */
    public ResultData<DataConfig> saveConfig(DataConfig config) {
        if (Objects.isNull(config)) {
            return ResultData.fail("配置不能为空.");
        }
        OperateResultWithData<DataConfig> result = configService.save(config);
        if (result.successful()) {
            return ResultData.success(result.getData());
        } else {
            return ResultData.fail(result.getMessage());
        }
    }
}