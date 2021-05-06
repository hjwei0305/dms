package com.changhong.sei.dms.general.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.dms.general.entity.Customer;
import org.springframework.stereotype.Repository;

/**
 * 客户(Customer)数据库访问类
 *
 * @author sei
 * @since 2021-05-06 13:05:15
 */
@Repository
public interface CustomerDao extends BaseEntityDao<Customer> {

}