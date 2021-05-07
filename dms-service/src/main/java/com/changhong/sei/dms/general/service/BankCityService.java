package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.BankCityDao;
import com.changhong.sei.dms.general.entity.BankCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 银行城市(BankCity)业务逻辑实现类
 *
 * @author sei
 * @since 2021-05-07 15:13:01
 */
@Service("bankCityService")
public class BankCityService extends BaseEntityService<BankCity> {
    @Autowired
    private BankCityDao dao;

    @Override
    protected BaseEntityDao<BankCity> getDao() {
        return dao;
    }

}