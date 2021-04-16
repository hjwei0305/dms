package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 总帐科目的公司视图(LedgerAccountCorporation)DTO类
 *
 * @author sei
 * @since 2021-04-16 16:29:07
 */
@ApiModel(description = "总帐科目的公司视图DTO")
public class LedgerAccountCorporationDto extends BaseEntityDto {
    private static final long serialVersionUID = -46336525194039959L;
    /**
     * 总账科目Id
     */
    @NotBlank
    @ApiModelProperty(value = "总账科目Id")
    private String ledgerAccountId;
    /**
     * ERP公司代码
     */
    @NotBlank
    @Size(max = 4)
    @ApiModelProperty(value = "ERP公司代码")
    private String erpCorporationCode;
    /**
     * 统驭科目标识
     */
    @ApiModelProperty(value = "统驭科目标识")
    private String categoryCode;
    /**
     * 税务类型
     */
    @ApiModelProperty(value = "税务类型")
    private String taxCategoryCode;
    /**
     * 允许无税码过账
     */
    @ApiModelProperty(value = "允许无税码过账")
    private Boolean allowNoTax = Boolean.FALSE;
    /**
     * 字段状态组
     */
    @ApiModelProperty(value = "字段状态组")
    private String fieldGroup;
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


    public String getLedgerAccountId() {
        return ledgerAccountId;
    }

    public void setLedgerAccountId(String ledgerAccountId) {
        this.ledgerAccountId = ledgerAccountId;
    }

    public String getErpCorporationCode() {
        return erpCorporationCode;
    }

    public void setErpCorporationCode(String erpCorporationCode) {
        this.erpCorporationCode = erpCorporationCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getTaxCategoryCode() {
        return taxCategoryCode;
    }

    public void setTaxCategoryCode(String taxCategoryCode) {
        this.taxCategoryCode = taxCategoryCode;
    }

    public Boolean getAllowNoTax() {
        return allowNoTax;
    }

    public void setAllowNoTax(Boolean allowNoTax) {
        this.allowNoTax = allowNoTax;
    }

    public String getFieldGroup() {
        return fieldGroup;
    }

    public void setFieldGroup(String fieldGroup) {
        this.fieldGroup = fieldGroup;
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