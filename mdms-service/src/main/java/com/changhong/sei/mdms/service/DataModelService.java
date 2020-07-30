package com.changhong.sei.mdms.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.exception.ServiceException;
import com.changhong.sei.mdms.dao.DataModelDao;
import com.changhong.sei.mdms.dto.DBType;
import com.changhong.sei.mdms.entity.DataModel;
import com.changhong.sei.mdms.entity.DataModelField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


/**
 * 数据模型(DataModel)业务逻辑实现类
 *
 * @author sei
 * @since 2020-07-28 17:31:41
 */
@Service("dataModelService")
public class DataModelService extends BaseEntityService<DataModel> {
    @Autowired
    private DataModelDao dao;
    @Autowired
    private DataModelFieldService fieldService;

    @Override
    protected BaseEntityDao<DataModel> getDao() {
        return dao;
    }

    /**
     * 数据保存操作
     *
     * @param entity 模型
     */
    @Override
    public OperateResultWithData<DataModel> save(DataModel entity) {
        OperateResultWithData<DataModel> result = super.save(entity);
        if (result.successful()) {
            DataModel dataModel = result.getData();
            // 模型创建成功,默认添加id字段;
            DataModelField idField = new DataModelField();
            idField.setDataModelId(dataModel.getId());
            idField.setFieldName("id");
            idField.setRemark("主键id");
            idField.setDataType("IdOrKey");
            idField.setDataLength(36);
            idField.setPrimaryKey(Boolean.TRUE);
            idField.setNotNull(Boolean.TRUE);

            OperateResultWithData<DataModelField> idResult = fieldService.save(idField);
            if (idResult.notSuccessful()) {
                // 回滚数据模型save事务
                throw new ServiceException(idResult.getMessage());
            }
        }
        return result;
    }

    /**
     * 根据数据模型id获取模型字段清单
     *
     * @param modelId 数据模型id
     * @return 返回自定的模型字段清单
     */
    public List<DataModelField> getDataModelFields(String modelId) {
        return null;
    }

    /**
     * 添加默认审计字段
     *
     * @param modelId 数据模型id
     * @return 返回操作结果
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData<Void> addAuditFields(String modelId) {
        return null;
    }

    /**
     * 添加数据模型字段
     *
     * @param fieldDtos 数据模型字段dto
     * @return 返回操作结果
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData<Void> saveModelFields(List<DataModelField> fieldDtos) {
        return null;
    }

    /**
     * 删除数据模型字段
     *
     * @param fieldIds 删除的数据模型字段id清单
     * @return 返回操作结果
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData<Void> deleteModelFields(List<String> fieldIds) {
        return null;
    }
}