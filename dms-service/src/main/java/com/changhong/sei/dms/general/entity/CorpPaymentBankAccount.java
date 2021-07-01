package com.changhong.sei.dms.general.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.ITenant;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 公司的付款银行账号信息(CorpPaymentBankAccount)实体类
 *
 * @author sei
 * @since 2021-07-01 16:10:10
 */
@Entity
@Table(name = "corp_payment_bank_account")
@DynamicInsert
@DynamicUpdate
public class CorpPaymentBankAccount extends BaseAuditableEntity implements Serializable, ITenant {
    private static final long serialVersionUID = -23896932514205497L;
    /**
     * 公司代码
     */
    @Column(name = "corporation_code")
    private String corporationCode;
    /**
     * 货币Id
     */
    @Column(name = "currency_id")
    private String currencyId;
    /**
     * 货币
     */
    @ManyToOne
    @JoinColumn(name = "currency_id", insertable = false, updatable = false)
    private Currency currency;
    /**
     * 付款方银行Id
     */
    @Column(name = "bank_id")
    private String bankId;

    /**
     * 付款方银行
     */
    @ManyToOne
    @JoinColumn(name = "bank_id", insertable = false, updatable = false)
    private Bank bank;
    /**
     * 银行户名
     */
    @Column(name = "bank_account_name")
    private String bankAccountName;
    /**
     * 银行账号
     */
    @Column(name = "bank_account_number")
    private String bankAccountNumber;
    /**
     * 科目代码
     */
    @Column(name = "ledger_account_code")
    private String ledgerAccountCode;
    /**
     * 科目名称
     */
    @Column(name = "ledger_account_name")
    private String ledgerAccountName;
    /**
     * 默认标记
     */
    @Column(name = "default_tag")
    private Boolean defaultTag;
    /**
     * 租户代码
     */
    @Column(name = "tenant_code")
    private String tenantCode;


    public String getCorporationCode() {
        return corporationCode;
    }

    public void setCorporationCode(String corporationCode) {
        this.corporationCode = corporationCode;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getLedgerAccountCode() {
        return ledgerAccountCode;
    }

    public void setLedgerAccountCode(String ledgerAccountCode) {
        this.ledgerAccountCode = ledgerAccountCode;
    }

    public String getLedgerAccountName() {
        return ledgerAccountName;
    }

    public void setLedgerAccountName(String ledgerAccountName) {
        this.ledgerAccountName = ledgerAccountName;
    }

    public Boolean getDefaultTag() {
        return defaultTag;
    }

    public void setDefaultTag(Boolean defaultTag) {
        this.defaultTag = defaultTag;
    }

    @Override
    public String getTenantCode() {
        return tenantCode;
    }

    @Override
    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

}