package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.CustomerDao;
import com.changhong.sei.dms.general.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 客户(Customer)业务逻辑实现类
 *
 * @author sei
 * @since 2021-05-06 13:05:15
 */
@Service("customerService")
public class CustomerService extends BaseEntityService<Customer> {
    @Autowired
    private CustomerDao dao;

    @Override
    protected BaseEntityDao<Customer> getDao() {
        return dao;
    }

}