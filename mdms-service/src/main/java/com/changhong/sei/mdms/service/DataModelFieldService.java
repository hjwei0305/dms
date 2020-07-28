package com.changhong.sei.mdms.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.mdms.dao.DataModelFieldDao;
import com.changhong.sei.mdms.entity.DataModelField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 模型字段(DataModelField)业务逻辑实现类
 *
 * @author sei
 * @since 2020-07-28 17:31:42
 */
@Service("dataModelFieldService")
public class DataModelFieldService extends BaseEntityService<DataModelField> {
    @Autowired
    private DataModelFieldDao dao;

    @Override
    protected BaseEntityDao<DataModelField> getDao() {
        return dao;
    }

}