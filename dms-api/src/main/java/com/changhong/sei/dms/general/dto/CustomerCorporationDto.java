package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 客户的公司视图(CustomerCorporation)DTO类
 *
 * @author sei
 * @since 2021-05-06 13:10:12
 */
@ApiModel(description = "客户的公司视图DTO")
public class CustomerCorporationDto extends BaseEntityDto {
    private static final long serialVersionUID = -65598599730341379L;
    /**
     * 客户Id
     */
    @ApiModelProperty(value = "客户Id")
    private String customerId;
    /**
     * ERP公司代码
     */
    @ApiModelProperty(value = "ERP公司代码")
    private String erpCorporationCode;
    /**
     * 统驭科目代码
     */
    @ApiModelProperty(value = "统驭科目代码")
    private String accountCode;
    /**
     * 支付条款代码
     */
    @ApiModelProperty(value = "支付条款代码")
    private String paymentTermCode;
    /**
     * 已冻结
     */
    @ApiModelProperty(value = "已冻结")
    private Boolean frozen = Boolean.FALSE;
    /**
     * 支付冻结标识
     */
    @ApiModelProperty(value = "支付冻结标识")
    private Boolean payFrozen = Boolean.FALSE;
    /**
     * 租户代码
     */
    @ApiModelProperty(value = "租户代码")
    private String tenantCode;


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getErpCorporationCode() {
        return erpCorporationCode;
    }

    public void setErpCorporationCode(String erpCorporationCode) {
        this.erpCorporationCode = erpCorporationCode;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getPaymentTermCode() {
        return paymentTermCode;
    }

    public void setPaymentTermCode(String paymentTermCode) {
        this.paymentTermCode = paymentTermCode;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    public Boolean getPayFrozen() {
        return payFrozen;
    }

    public void setPayFrozen(Boolean payFrozen) {
        this.payFrozen = payFrozen;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

}