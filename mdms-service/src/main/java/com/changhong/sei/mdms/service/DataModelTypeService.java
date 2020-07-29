package com.changhong.sei.mdms.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dao.BaseTreeDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.BaseTreeService;
import com.changhong.sei.mdms.dao.DataModelTypeDao;
import com.changhong.sei.mdms.entity.DataModelType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 数据模型分类(DataModelType)业务逻辑实现类
 *
 * @author sei
 * @since 2020-07-28 17:31:44
 */
@Service("dataModelTypeService")
public class DataModelTypeService extends BaseTreeService<DataModelType> {
    @Autowired
    private DataModelTypeDao dao;

    @Override
    protected BaseTreeDao<DataModelType> getDao() {
        return dao;
    }

}