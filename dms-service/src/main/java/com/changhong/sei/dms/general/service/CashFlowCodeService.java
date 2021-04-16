package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.CashFlowCodeDao;
import com.changhong.sei.dms.general.entity.CashFlowCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 实现功能: 现金流代码(CashFlowCode)业务逻辑实现类
 *
 * @author 冯华
 * @create 2021-04-16 10:07
 */
@Service("cashFlowCodeService")
public class CashFlowCodeService extends BaseEntityService<CashFlowCode> {
    @Autowired
    private CashFlowCodeDao dao;


    @Override
    protected BaseEntityDao<CashFlowCode> getDao() {
        return dao;
    }
}
