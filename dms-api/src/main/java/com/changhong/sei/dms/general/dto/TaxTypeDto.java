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
import java.math.BigDecimal;

/**
 * 税类型(TaxType)DTO类
 *
 * @author 杨沄炜
 * @since 2021-06-21 16:32
 */
@MasterData(code = "TaxType", name = "税分类")
@ApiModel(description = "税分类DTO")
public class TaxTypeDto extends BaseEntityDto {
    private static final long serialVersionUID = -6796808683898161332L;
    /**
     * 税码
     */
    @NotBlank
    @Size(max = 10)
    @ApiModelProperty(value = "税码", required = true)
    private String code;

    /**
     * 名称
     */
    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(value = "名称", required = true)
    private String name;

    /**
     * 税分类
     */
    @NotNull
    @JsonSerialize(using = EnumJsonSerializer.class)
    @ApiModelProperty(value = "税分类", required = true)
    private TaxCategory taxCategory = TaxCategory.OUTPUT;

    /**
     * 税率
     */
    @NotNull
    @ApiModelProperty(value = "税率", required = true)
    private BigDecimal taxRate = BigDecimal.ZERO;

    /**
     * 排序
     */
    @NotNull
    @ApiModelProperty(value = "排序", required = true)
    private Integer rank = 0;

    /**
     * 总账科目代码
     */
    @Size(max = 20)
    @ApiModelProperty(value = "总账科目代码")
    private String ledgerAccountCode;

    /**
     * 总账科目名称
     */
    @Size(max = 100)
    @ApiModelProperty(value = "总账科目名称")
    private String ledgerAccountName;

    /**
     * 转出科目代码
     */
    @Size(max = 20)
    @ApiModelProperty(value = "转出科目代码")
    private String transferAccountCode;

    /**
     * 转出科目名称
     */
    @Size(max = 100)
    @ApiModelProperty(value = "转出科目名称")
    private String transferAccountName;

    /**
     * 租户代码
     */
    @Size(max = 10)
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

    public TaxCategory getTaxCategory() {
        return taxCategory;
    }

    public void setTaxCategory(TaxCategory taxCategory) {
        this.taxCategory = taxCategory;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
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

    public String getTransferAccountCode() {
        return transferAccountCode;
    }

    public void setTransferAccountCode(String transferAccountCode) {
        this.transferAccountCode = transferAccountCode;
    }

    public String getTransferAccountName() {
        return transferAccountName;
    }

    public void setTransferAccountName(String transferAccountName) {
        this.transferAccountName = transferAccountName;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }
}