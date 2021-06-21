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
import java.util.Date;

/**
 * 税分类(TaxType)DTO类
 *
 * @author 杨沄炜
 * @since 2021-06-21 16:32
 */
@MasterData(code = "TaxType", name = "税分类")
@ApiModel(description = "税分类DTO")
public class TaxTypeDto extends BaseEntityDto  {
    private static final long serialVersionUID = -6796808683898161332L;
    /**
     * Id
     */
    @NotBlank
    @Size(max = 36)
    @ApiModelProperty(value = "Id(必需，最大长度36)")
    private String id;

    /**
     * 税码
     */
    @NotBlank
    @Size(max = 10)
    @ApiModelProperty(value = "税码(必需，最大长度10)")
    private String code;

    /**
     * 名称
     */
    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(value = "名称(必需，最大长度50)")
    private String name;

    /**
     * 税分类
     */
    @NotNull
    @JsonSerialize(using = EnumJsonSerializer.class)
    @ApiModelProperty(value = "税分类(必需)")
    private TaxCategory taxCategory;

    /**
     * 税率
     */
    @NotNull
    @ApiModelProperty(value = "税率(必需，精确到小数点后四位)")
    private BigDecimal taxRate;

    /**
     * 排序
     */
    @NotNull
    @ApiModelProperty(value = "排序（必需）")
    private Integer rank;

    /**
     * 总账科目代码
     */
    @Size(max = 20)
    @ApiModelProperty(value = "总账科目代码（最大长度20）")
    private String ledgerAccountCode;

    /**
     * 总账科目名称
     */
    @Size(max = 100)
    @ApiModelProperty(value = "总账科目名称（最大长度100）")
    private String ledgerAccountName;

    /**
     * 租户代码
     */
    @NotBlank
    @Size(max = 10)
    @ApiModelProperty(value = "租户代码(必需，最大长度10）")
    private String tenantCode;

    /**
     * 创建人Id
     */
    @Size(max = 36)
    @ApiModelProperty(value = "创建人Id（最大长度36）")
    private String creatorId;

    /**
     * 创建人账号
     */
    @Size(max = 50)
    @ApiModelProperty(value = "创建人账号（最大长度50）")
    private String creatorAccount;

    /**
     * 创建人名称
     */
    @Size(max = 50)
    @ApiModelProperty(value = "创建人名称（最大长度50）")
    private String creatorName;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;

    /**
     * 最后修改人Id
     */
    @Size(max = 36)
    @ApiModelProperty(value = "最后修改人Id（最大长度36）")
    private String lastEditorId;

    /**
     * 最后修改人账号
     */
    @Size(max = 50)
    @ApiModelProperty(value = "最后修改人账号（最大长度50）")
    private String lastEditorAccount;

    /**
     * 最后修改人名称
     */
    @Size(max = 50)
    @ApiModelProperty(value = "最后修改人名称（最大长度50）")
    private String lastEditorName;

    /**
     * 最后修改时间
     */
    @ApiModelProperty(value = "最后修改时间")
    private Date lastEditedDate;

    @Override
    public String getId() { return id; }

    @Override
    public void setId(String id) { this.id = id; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public TaxCategory getTaxCategory() { return taxCategory; }

    public void setTaxCategory(TaxCategory taxCategory) { this.taxCategory = taxCategory; }

    public BigDecimal getTaxRate() { return taxRate; }

    public void setTaxRate(BigDecimal taxRate) { this.taxRate = taxRate; }

    public Integer getRank() { return rank; }

    public void setRank(Integer rank) { this.rank = rank; }

    public String getLedgerAccountCode() { return ledgerAccountCode; }

    public void setLedgerAccountCode(String ledgerAccountCode) { this.ledgerAccountCode = ledgerAccountCode; }

    public String getTenantCode() { return tenantCode; }

    public void setTenantCode(String tenantCode) { this.tenantCode = tenantCode; }

    public String getCreatorId() { return creatorId; }

    public void setCreatorId(String creatorId) { this.creatorId = creatorId; }

    public String getCreatorAccount() { return creatorAccount; }

    public void setCreatorAccount(String creatorAccount) { this.creatorAccount = creatorAccount; }

    public String getCreatorName() { return creatorName; }

    public void setCreatorName(String creatorName) { this.creatorName = creatorName; }

    public Date getCreatedDate() { return createdDate; }

    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

    public String getLastEditorId() { return lastEditorId; }

    public void setLastEditorId(String lastEditorId) { this.lastEditorId = lastEditorId; }

    public String getLastEditorAccount() { return lastEditorAccount; }

    public void setLastEditorAccount(String lastEditorAccount) { this.lastEditorAccount = lastEditorAccount; }

    public String getLastEditorName() { return lastEditorName; }

    public void setLastEditorName(String lastEditorName) { this.lastEditorName = lastEditorName; }

    public Date getLastEditedDate() { return lastEditedDate; }

    public void setLastEditedDate(Date lastEditedDate) { this.lastEditedDate = lastEditedDate; }
}
