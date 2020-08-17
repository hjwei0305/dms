package com.changhong.sei.mdms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.mdms.general.dao.RegionDao;
import com.changhong.sei.mdms.general.entity.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 行政区域(Region)业务逻辑实现类
 *
 * @author sei
 * @since 2020-08-17 14:02:48
 */
@Service("regionService")
public class RegionService extends BaseEntityService<Region> {
    @Autowired
    private RegionDao dao;

    @Override
    protected BaseEntityDao<Region> getDao() {
        return dao;
    }

}