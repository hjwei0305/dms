package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.BankAreaDao;
import com.changhong.sei.dms.general.entity.BankArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 银行地区(BankArea)业务逻辑实现类
 *
 * @author sei
 * @since 2021-05-07 15:55:10
 */
@Service("bankAreaService")
public class BankAreaService extends BaseEntityService<BankArea> {
    @Autowired
    private BankAreaDao dao;

    @Override
    protected BaseEntityDao<BankArea> getDao() {
        return dao;
    }

}