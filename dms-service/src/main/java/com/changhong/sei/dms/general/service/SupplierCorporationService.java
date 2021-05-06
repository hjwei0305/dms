package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.SupplierCorporationDao;
import com.changhong.sei.dms.general.entity.SupplierCorporation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 供应商的公司信息(SupplierCorporation)业务逻辑实现类
 *
 * @author sei
 * @since 2021-05-06 14:08:15
 */
@Service("supplierCorporationService")
public class SupplierCorporationService extends BaseEntityService<SupplierCorporation> {
    @Autowired
    private SupplierCorporationDao dao;

    @Override
    protected BaseEntityDao<SupplierCorporation> getDao() {
        return dao;
    }

}