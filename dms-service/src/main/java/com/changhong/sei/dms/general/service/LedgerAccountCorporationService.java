package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.LedgerAccountCorporationDao;
import com.changhong.sei.dms.general.entity.LedgerAccountCorporation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 总帐科目的公司视图(LedgerAccountCorporation)业务逻辑实现类
 *
 * @author sei
 * @since 2021-04-16 16:41:08
 */
@Service("ledgerAccountCorporationService")
public class LedgerAccountCorporationService extends BaseEntityService<LedgerAccountCorporation> {
    @Autowired
    private LedgerAccountCorporationDao dao;

    @Override
    protected BaseEntityDao<LedgerAccountCorporation> getDao() {
        return dao;
    }

}