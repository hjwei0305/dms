package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.UnitDao;
import com.changhong.sei.dms.general.entity.Unit;
import org.springframework.stereotype.Service;

/**
 * @Author: 刘松林
 * @Contact: songlin.liu@changhong.com
 * @Date: 2020/3/12 15:31
 * @Description:
 */
@Service
public class UnitService extends BaseEntityService<Unit> {

    private final UnitDao unitDao;

    public UnitService(UnitDao unitDao){
        this.unitDao = unitDao;
    }

    @Override
    protected BaseEntityDao<Unit> getDao() {
        return unitDao;
    }
}
