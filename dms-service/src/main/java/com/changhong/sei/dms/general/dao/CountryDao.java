package com.changhong.sei.dms.general.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.dms.general.entity.Country;
import org.springframework.stereotype.Repository;

/**
 * 国家(Country)数据库访问类
 *
 * @author sei
 * @since 2020-08-17 14:02:41
 */
@Repository
public interface CountryDao extends BaseEntityDao<Country> {

}