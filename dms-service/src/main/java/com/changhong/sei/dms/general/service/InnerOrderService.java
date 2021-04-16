package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.InnerOrderDao;
import com.changhong.sei.dms.general.entity.InnerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 内部订单(InnerOrder)业务逻辑实现类
 *
 * @author sei
 * @since 2021-04-16 14:19:33
 */
@Service("innerOrderService")
public class InnerOrderService extends BaseEntityService<InnerOrder> {
    @Autowired
    private InnerOrderDao dao;

    @Override
    protected BaseEntityDao<InnerOrder> getDao() {
        return dao;
    }

}