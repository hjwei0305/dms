package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.dms.annotation.MasterData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 内部订单(InnerOrder)DTO类
 *
 * @author sei
 * @since 2021-04-16 14:20:22
 */
@MasterData(code = "InnerOrder", name = "内部订单")
@ApiModel(description = "内部订单DTO")
public class InnerOrderDto extends BaseEntityDto {
    private static final long serialVersionUID = 271840151450082294L;
    /**
     * 代码
     */
    @NotBlank
    @Size(max = 20)
    @ApiModelProperty(value = "代码")
    private String code;
    /**
     * 名称
     */
    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 订单类型
     */
    @NotBlank
    @Size(max = 4)
    @ApiModelProperty(value = "订单类型")
    private String orderType;
    /**
     * ERP公司代码
     */
    @NotBlank
    @Size(max = 10)
    @ApiModelProperty(value = "ERP公司代码")
    private String erpCorporationCode;
    /**
     * 货币代码
     */
    @NotBlank
    @Size(max = 5)
    @ApiModelProperty(value = "货币代码")
    private String currencyCode;
    /**
     * 业务范围
     */
    @ApiModelProperty(value = "业务范围")
    private String costRange;
    /**
     * 负责人
     */
    @ApiModelProperty(value = "负责人")
    private String keyPerson;
    /**
     * 成本中心代码
     */
    @ApiModelProperty(value = "成本中心代码")
    private String costCenterCode;
    /**
     * 已冻结
     */
    @NotNull
    @ApiModelProperty(value = "已冻结", required = true)
    private Boolean frozen = Boolean.FALSE;
    /**
     * 租户代码
     */
    @ApiModelProperty(value = "租户代码")
    private String tenantCode;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getErpCorporationCode() {
        return erpCorporationCode;
    }

    public void setErpCorporationCode(String erpCorporationCode) {
        this.erpCorporationCode = erpCorporationCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCostRange() {
        return costRange;
    }

    public void setCostRange(String costRange) {
        this.costRange = costRange;
    }

    public String getKeyPerson() {
        return keyPerson;
    }

    public void setKeyPerson(String keyPerson) {
        this.keyPerson = keyPerson;
    }

    public String getCostCenterCode() {
        return costCenterCode;
    }

    public void setCostCenterCode(String costCenterCode) {
        this.costCenterCode = costCenterCode;
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