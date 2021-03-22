package com.changhong.sei.dms.management.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.management.dao.SubscriptionDao;
import com.changhong.sei.dms.management.entity.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 应用数据订阅(Subscription)业务逻辑实现类
 *
 * @author sei
 * @since 2020-08-13 22:47:16
 */
@Service("subscriptionService")
public class SubscriptionService extends BaseEntityService<Subscription> {
    @Autowired
    private SubscriptionDao dao;

    @Override
    protected BaseEntityDao<Subscription> getDao() {
        return dao;
    }

}