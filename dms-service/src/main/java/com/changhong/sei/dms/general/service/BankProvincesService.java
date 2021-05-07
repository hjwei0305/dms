package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.BankProvincesDao;
import com.changhong.sei.dms.general.entity.BankProvinces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 银行省区(BankProvinces)业务逻辑实现类
 *
 * @author sei
 * @since 2021-05-07 14:34:39
 */
@Service("bankProvincesService")
public class BankProvincesService extends BaseEntityService<BankProvinces> {
    @Autowired
    private BankProvincesDao dao;

    @Override
    protected BaseEntityDao<BankProvinces> getDao() {
        return dao;
    }

}