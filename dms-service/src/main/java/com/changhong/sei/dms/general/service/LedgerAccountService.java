package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.LedgerAccountCorporationDao;
import com.changhong.sei.dms.general.dao.LedgerAccountDao;
import com.changhong.sei.dms.general.entity.LedgerAccount;
import com.changhong.sei.dms.general.entity.LedgerAccountCorporation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 总帐科目(LedgerAccount)业务逻辑实现类
 *
 * @author sei
 * @since 2021-04-16 16:16:20
 */
@Service("ledgerAccountService")
public class LedgerAccountService extends BaseEntityService<LedgerAccount> {
    @Autowired
    private LedgerAccountDao dao;

    @Override
    protected BaseEntityDao<LedgerAccount> getDao() {
        return dao;
    }

}