package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 公司的备用金员工(ERP)(ImprestEmployeeCorporation)DTO类
 *
 * @author sei
 * @since 2021-04-20 17:09:15
 */
@ApiModel(description = "公司的备用金员工(ERP)DTO")
public class ImprestEmployeeCorporationDto extends BaseEntityDto {
    private static final long serialVersionUID = -84732560872444586L;
    /**
     * 备用金员工Id
     */
    @ApiModelProperty(value = "备用金员工Id")
    private String imprestEmployeeId;
    /**
     * 备用金员工
     */
    @ApiModelProperty(value = "备用金员工")
    private ImprestEmployeeDto imprestEmployee;
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
    private Boolean frozen;
    /**
     * 租户代码
     */
    @ApiModelProperty(value = "租户代码")
    private String tenantCode;


    public String getImprestEmployeeId() {
        return imprestEmployeeId;
    }

    public void setImprestEmployeeId(String imprestEmployeeId) {
        this.imprestEmployeeId = imprestEmployeeId;
    }

    public ImprestEmployeeDto getImprestEmployee() {
        return imprestEmployee;
    }

    public void setImprestEmployee(ImprestEmployeeDto imprestEmployee) {
        this.imprestEmployee = imprestEmployee;
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

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

}