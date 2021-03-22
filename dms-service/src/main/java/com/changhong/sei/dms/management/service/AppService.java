package com.changhong.sei.dms.management.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.management.dao.AppDao;
import com.changhong.sei.dms.management.entity.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 应用服务(App)业务逻辑实现类
 *
 * @author sei
 * @since 2020-08-13 22:47:16
 */
@Service("appService")
public class AppService extends BaseEntityService<App> {
    @Autowired
    private AppDao dao;

    @Override
    protected BaseEntityDao<App> getDao() {
        return dao;
    }

}