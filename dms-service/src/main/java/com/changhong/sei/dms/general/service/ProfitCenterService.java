package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.ProfitCenterDao;
import com.changhong.sei.dms.general.entity.ProfitCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 利润中心(ProfitCenter)业务逻辑实现类
 *
 * @author sei
 * @since 2021-07-30 14:57:52
 */
@Service
public class ProfitCenterService extends BaseEntityService<ProfitCenter> {
    @Autowired
    private ProfitCenterDao dao;

    @Override
    protected BaseEntityDao<ProfitCenter> getDao() {
        return dao;
    }

}