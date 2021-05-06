package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 供应商的公司信息(SupplierCorporation)DTO类
 *
 * @author sei
 * @since 2021-05-06 14:08:31
 */
@ApiModel(description = "供应商的公司信息DTO")
public class SupplierCorporationDto extends BaseEntityDto {
    private static final long serialVersionUID = -49302856532753197L;
    /**
     * 供应商Id
     */
    @ApiModelProperty(value = "供应商Id")
    private String supplierId;
    /**
     * 供应商
     */
    @ApiModelProperty(value = "供应商")
    private SupplierDto supplier;

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
     * 支付冻结
     */
    @ApiModelProperty(value = "支付冻结")
    private Boolean payFrozen = Boolean.FALSE;
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


    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public SupplierDto getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDto supplier) {
        this.supplier = supplier;
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

    public Boolean getPayFrozen() {
        return payFrozen;
    }

    public void setPayFrozen(Boolean payFrozen) {
        this.payFrozen = payFrozen;
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