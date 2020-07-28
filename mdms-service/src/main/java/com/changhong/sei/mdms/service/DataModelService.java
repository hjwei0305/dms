package com.changhong.sei.mdms.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.mdms.dao.DataModelDao;
import com.changhong.sei.mdms.entity.DataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    @Override
    protected BaseEntityDao<DataModel> getDao() {
        return dao;
    }

}