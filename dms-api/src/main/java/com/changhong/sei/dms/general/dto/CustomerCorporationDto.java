package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
    @NotBlank
    @ApiModelProperty(value = "客户Id",required = true)
    private String customerId;
    /**
     * 客户
     */
    @ApiModelProperty(value = "客户")
    private CustomerDto customer;
    /**
     * ERP公司代码
     */
    @NotBlank
    @Size(max = 10)
    @ApiModelProperty(value = "ERP公司代码",required = true)
    private String erpCorporationCode;
    /**
     * 统驭科目代码
     */
    @Size(max = 10)
    @ApiModelProperty(value = "统驭科目代码")
    private String accountCode;
    /**
     * 支付条款代码
     */
    @Size(max = 4)
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

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
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