package com.changhong.sei.dms.general.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.dms.general.entity.ExchangeRate;
import org.springframework.stereotype.Repository;

/**
 * 汇率(ExchangeRate)数据库访问类
 *
 * @author sei
 * @since 2021-05-06 17:04:03
 */
@Repository
public interface ExchangeRateDao extends BaseEntityDao<ExchangeRate> {

}