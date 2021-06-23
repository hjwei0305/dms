package com.changhong.sei.dms.general.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.dms.general.entity.Supplier;
import org.springframework.stereotype.Repository;

/**
 * 供应商(Supplier)数据库访问类
 *
 * @author sei
 * @since 2021-05-06 14:07:30
 */
@Repository
public interface SupplierDao extends BaseEntityDao<Supplier>, SupplierExtDao {

}