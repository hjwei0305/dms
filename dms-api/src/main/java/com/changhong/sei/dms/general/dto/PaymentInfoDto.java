package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.core.dto.serializer.EnumJsonSerializer;
import com.changhong.sei.dms.annotation.MasterData;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 支付信息(PaymentInfo)DTO类
 *
 * @author sei
 * @since 2021-06-29 09:17:47
 */
@ApiModel(description = "支付信息DTO")
@MasterData(code = "PaymentInfo", name = "支付信息")
public class PaymentInfoDto extends BaseEntityDto {
    private static final long serialVersionUID = -98077123096840716L;
    /**
     * 收款对象类型
     */
    @ApiModelProperty(value = "收款对象类型", required = true)
    @JsonSerialize(using = EnumJsonSerializer.class)
    @NotNull
    private ReceiverTypeEnum receiverType;
    /**
     * 收款对象Id
     */
    @ApiModelProperty(value = "收款对象Id", required = true)
    @NotBlank
    private String receiverId;
    /**
     * 收款对象代码
     */
    @ApiModelProperty(value = "收款对象代码", required = true)
    @NotBlank
    @Size(max = 20)
    private String receiverCode;
    /**
     * 收款对象名称
     */
    @ApiModelProperty(value = "收款对象名称", required = true)
    @NotBlank
    @Size(max = 100)
    private String receiverName;
    /**
     * 银行Id
     */
    @ApiModelProperty(value = "银行Id", required = true)
    @NotBlank
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
     * 关联银行国家代码
     */
    @ApiModelProperty(value = "关联银行国家代码")
    private String countryCode;
    /**
     * 关联银行国家名称
     */
    @ApiModelProperty(value = "关联银行国家名称")
    private String countryName;
    /**
     * 关联银行省区代码
     */
    @ApiModelProperty(value = "关联银行省区代码")
    private String bankProvinceCode;
    /**
     * 关联银行省区名称
     */
    @ApiModelProperty(value = "关联银行省区名称")
    private String bankProvinceName;
    /**
     * 关联银行城市代码
     */
    @ApiModelProperty(value = "关联银行城市代码")
    private String bankCityCode;
    /**
     * 关联银行城市名称
     */
    @ApiModelProperty(value = "关联银行城市名称")
    private String bankCityName;
    /**
     * 关联银行地区代码
     */
    @ApiModelProperty(value = "关联银行地区代码")
    private String bankAreaCode;
    /**
     * 关联银行地区名称
     */
    @ApiModelProperty(value = "关联银行地区名称")
    private String bankAreaName;
    /**
     * ERP银行代码
     */
    @ApiModelProperty(value = "ERP银行代码")
    private String erpBankCode;
    /**
     * 银行户名
     */
    @ApiModelProperty(value = "银行户名", required = true)
    @NotBlank
    @Size(max = 100)
    private String bankAccountName;
    /**
     * 银行帐号
     */
    @ApiModelProperty(value = "银行帐号", required = true)
    @NotBlank
    @Size(max = 40)
    private String bankAccountNumber;
    /**
     * 账号用途
     */
    @ApiModelProperty(value = "账号用途")
    private PaymentInfoUseScopeEnum useScope = PaymentInfoUseScopeEnum.ALL;
    /**
     * 个人账户
     */
    @ApiModelProperty(value = "个人账户")
    private Boolean personal = Boolean.FALSE;
    /**
     * 已冻结
     */
    @ApiModelProperty(value = "已冻结")
    private Boolean frozen = Boolean.FALSE;
    /**
     * 租户代码
     */
    @ApiModelProperty(value = "租户代码")
    private String tenantCode;


    public ReceiverTypeEnum getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(ReceiverTypeEnum receiverType) {
        this.receiverType = receiverType;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverCode() {
        return receiverCode;
    }

    public void setReceiverCode(String receiverCode) {
        this.receiverCode = receiverCode;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getBankProvinceCode() {
        return bankProvinceCode;
    }

    public void setBankProvinceCode(String bankProvinceCode) {
        this.bankProvinceCode = bankProvinceCode;
    }

    public String getBankProvinceName() {
        return bankProvinceName;
    }

    public void setBankProvinceName(String bankProvinceName) {
        this.bankProvinceName = bankProvinceName;
    }

    public String getBankCityCode() {
        return bankCityCode;
    }

    public void setBankCityCode(String bankCityCode) {
        this.bankCityCode = bankCityCode;
    }

    public String getBankCityName() {
        return bankCityName;
    }

    public void setBankCityName(String bankCityName) {
        this.bankCityName = bankCityName;
    }

    public String getBankAreaCode() {
        return bankAreaCode;
    }

    public void setBankAreaCode(String bankAreaCode) {
        this.bankAreaCode = bankAreaCode;
    }

    public String getBankAreaName() {
        return bankAreaName;
    }

    public void setBankAreaName(String bankAreaName) {
        this.bankAreaName = bankAreaName;
    }

    public String getErpBankCode() {
        return erpBankCode;
    }

    public void setErpBankCode(String erpBankCode) {
        this.erpBankCode = erpBankCode;
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

    public PaymentInfoUseScopeEnum getUseScope() {
        return useScope;
    }

    public void setUseScope(PaymentInfoUseScopeEnum useScope) {
        this.useScope = useScope;
    }

    public Boolean getPersonal() {
        return personal;
    }

    public void setPersonal(Boolean personal) {
        this.personal = personal;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

}