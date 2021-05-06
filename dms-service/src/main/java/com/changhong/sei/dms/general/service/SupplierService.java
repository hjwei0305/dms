package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.SupplierDao;
import com.changhong.sei.dms.general.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 供应商(Supplier)业务逻辑实现类
 *
 * @author sei
 * @since 2021-05-06 14:07:30
 */
@Service("supplierService")
public class SupplierService extends BaseEntityService<Supplier> {
    @Autowired
    private SupplierDao dao;

    @Override
    protected BaseEntityDao<Supplier> getDao() {
        return dao;
    }

}