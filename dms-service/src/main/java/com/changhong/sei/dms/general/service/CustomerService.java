package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.CustomerDao;
import com.changhong.sei.dms.general.dto.CustomerDto;
import com.changhong.sei.dms.general.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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


    /**
     * 根据代码查询客户
     *
     * @param code 客户代码
     * @return 客户
     */
    public Customer findByCode(String code) {
        return findByProperty("code", code);
    }

}