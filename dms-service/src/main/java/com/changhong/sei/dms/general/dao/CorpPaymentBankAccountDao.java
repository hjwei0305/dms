package com.changhong.sei.dms.general.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.dms.general.entity.CorpPaymentBankAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 公司的付款银行账号信息(CorpPaymentBankAccount)数据库访问类
 *
 * @author sei
 * @since 2021-07-01 16:10:12
 */
@Repository
public interface CorpPaymentBankAccountDao extends BaseEntityDao<CorpPaymentBankAccount> {
    /**
     * 根据银行账号获取付款银行账号信息
     * @param bankAccountNumber 银行账号
     * @param tenantCode 租户代码
     * @return 付款银行账号
     */
    @Query("select a from CorpPaymentBankAccount a where a.bankAccountNumber=?1 and a.tenantCode=?2")
    CorpPaymentBankAccount findByBankAccountNumber(String bankAccountNumber, String tenantCode);
}