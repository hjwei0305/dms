package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.CustomerCorporationDao;
import com.changhong.sei.dms.general.entity.CustomerCorporation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 客户的公司视图(CustomerCorporation)业务逻辑实现类
 *
 * @author sei
 * @since 2021-05-06 13:38:05
 */
@Service("customerCorporationService")
public class CustomerCorporationService extends BaseEntityService<CustomerCorporation> {
    @Autowired
    private CustomerCorporationDao dao;

    @Override
    protected BaseEntityDao<CustomerCorporation> getDao() {
        return dao;
    }

}