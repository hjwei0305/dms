package com.changhong.sei.dms.management.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.dms.management.entity.Subscription;
import org.springframework.stereotype.Repository;

/**
 * 应用数据订阅管理(Subscription)数据库访问类
 *
 * @author sei
 * @since 2020-08-13 22:47:16
 */
@Repository
public interface SubscriptionDao extends BaseEntityDao<Subscription> {

}