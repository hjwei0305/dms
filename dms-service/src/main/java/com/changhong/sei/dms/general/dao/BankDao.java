package com.changhong.sei.dms.general.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.dms.general.entity.Bank;
import org.springframework.stereotype.Repository;

/**
 * 银行(Bank)数据库访问类
 *
 * @author sei
 * @since 2021-06-25 11:10:32
 */
@Repository
public interface BankDao extends BaseEntityDao<Bank> {
    /**
     * 获取一个银行
     * @param code 代码
     * @return 银行
     */
    Bank findFirstByCode(String code);
}