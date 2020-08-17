package com.changhong.sei.mdms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.mdms.general.dao.CurrencyDao;
import com.changhong.sei.mdms.general.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 币种(Currency)业务逻辑实现类
 *
 * @author sei
 * @since 2020-08-17 14:02:46
 */
@Service("currencyService")
public class CurrencyService extends BaseEntityService<Currency> {
    @Autowired
    private CurrencyDao dao;

    @Override
    protected BaseEntityDao<Currency> getDao() {
        return dao;
    }

}