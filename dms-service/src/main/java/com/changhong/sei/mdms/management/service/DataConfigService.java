package com.changhong.sei.mdms.management.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.mdms.management.dao.DataConfigDao;
import com.changhong.sei.mdms.management.entity.DataConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 主数据配置(DataConfig)业务逻辑实现类
 *
 * @author sei
 * @since 2020-08-13 22:47:16
 */
@Service("dataConfigService")
public class DataConfigService extends BaseEntityService<DataConfig> {
    @Autowired
    private DataConfigDao dao;


    @Override
    protected BaseEntityDao<DataConfig> getDao() {
        return dao;
    }

}