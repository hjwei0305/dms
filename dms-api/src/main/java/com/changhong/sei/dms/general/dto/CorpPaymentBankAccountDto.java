package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.dms.annotation.MasterData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 公司的付款银行账号信息(CorpPaymentBankAccount)DTO类
 *
 * @author sei
 * @since 2021-07-01 16:09:46
 */
@MasterData(code = "CorpPaymentBankAccount", name = "公司的付款银行账号信息")
@ApiModel(description = "公司的付款银行账号信息DTO")
public class CorpPaymentBankAccountDto extends BaseEntityDto {
    private static final long serialVersionUID = -30154914881239521L;
    /**
     * 公司代码
     */
    @ApiModelProperty(value = "公司代码", required = true)
    @NotBlank
    @Size(max = 20)
    private String corporationCode;
    /**
     * 货币Id
     */
    @ApiModelProperty(value = "货币Id", required = true)
    @NotNull
    private String currencyId;
    /**
     * 货币代码
     */
    @ApiModelProperty(value = "货币代码")
    private String currencyCode;
    /**
     * 货币名称
     */
    @ApiModelProperty(value = "货币名称")
    private String currencyName;
    /**
     * 付款方银行Id
     */
    @ApiModelProperty(value = "付款方银行Id", required = true)
    @NotNull
    private String bankId;
    /**
     * 关联银行行号
     */
    @ApiModelProperty(value = "关联银行行号")
    private String bankCode;
    /**
     * 关联银行行名
     */
    @ApiModelProperty(value = "关联银行行名")
    private String bankName;
    /**
     * 关联银行行别代码
     */
    @ApiModelProperty(value = "关联银行行别代码")
    private String bankCategoryCode;
    /**
     * 关联银行行别名称
     */
    @ApiModelProperty(value = "关联银行行别名称")
    private String bankCategoryName;
    /**
     * 银行户名
     */
    @ApiModelProperty(value = "银行户名", required = true)
    @NotBlank
    @Size(max = 100)
    private String bankAccountName;
    /**
     * 银行账号
     */
    @ApiModelProperty(value = "银行账号", required = true)
    @NotBlank
    @Size(max = 50)
    private String bankAccountNumber;
    /**
     * 科目代码
     */
    @ApiModelProperty(value = "科目代码", required = true)
    @NotBlank
    @Size(max = 10)
    private String ledgerAccountCode;
    /**
     * 科目名称
     */
    @ApiModelProperty(value = "科目名称", required = true)
    @NotBlank
    @Size(max = 200)
    private String ledgerAccountName;
    /**
     * 默认标记
     */
    @ApiModelProperty(value = "默认标记")
    private Boolean defaultTag = Boolean.FALSE;
    /**
     * 租户代码
     */
    @ApiModelProperty(value = "租户代码")
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

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCategoryCode() {
        return bankCategoryCode;
    }

    public void setBankCategoryCode(String bankCategoryCode) {
        this.bankCategoryCode = bankCategoryCode;
    }

    public String getBankCategoryName() {
        return bankCategoryName;
    }

    public void setBankCategoryName(String bankCategoryName) {
        this.bankCategoryName = bankCategoryName;
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

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

}