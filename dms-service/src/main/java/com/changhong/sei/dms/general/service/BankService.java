package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.BankDao;
import com.changhong.sei.dms.general.entity.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 银行(Bank)业务逻辑实现类
 *
 * @author sei
 * @since 2021-06-25 11:10:33
 */
@Service("bankService")
public class BankService extends BaseEntityService<Bank> {
    @Autowired
    private BankDao dao;

    @Override
    protected BaseEntityDao<Bank> getDao() {
        return dao;
    }

    /**
     * 获取一个银行
     * @param code 代码
     * @return 银行
     */
    public Bank findByCode(String code) {
        return dao.findFirstByCode(code);
    }
}