package com.changhong.sei.dms.general.entity;

import com.changhong.sei.core.dto.IRank;
import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.ICodeUnique;
import com.changhong.sei.core.entity.ITenant;
import com.changhong.sei.dms.general.dto.TaxCategory;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 税类型(TaxType)实体类
 *
 * @author 杨沄炜
 * @create 2021/6/21 9:24
 */
@Entity
@Table(name = "tax_type")
@DynamicInsert
@DynamicUpdate
public class TaxType extends BaseAuditableEntity implements Serializable, ICodeUnique, IRank, ITenant{
    private static final long serialVersionUID = -1710768247895818110L;
    /**
     * Id
     */
    @Column(name = "id", length = 36, nullable = false, unique = true)
    private String id;

    /**
     * 税码
     */
    @Column(name = "code", length = 4, nullable = false, unique = true)
    private String code;

    /**
     * 名称
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    /**
     * 税分类
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "tax_category", nullable = false, length = 20)
    private TaxCategory taxCategory = TaxCategory.OUTPUT;

    /**
     * 税率
     */
    @Column(name = "tax_rate", nullable = false, precision = 10, scale = 4)
    private Double taxRate = 0.00;

    /**
     * 排序
     */
    @Column(name = "rank", nullable = false)
    private Integer rank;

    /**
     * 总账科目代码
     */
    @Column(name = "ledger_account_code", length = 20)
    private String ledgerAccountCode;

    /**
     * 总账科目名称
     */
    @Column(name = "ledger_account_name", length = 100)
    private String ledgerAccountName;

    /**
     * 租户代码
     */
    @Column(name = "tenant_code", length = 10, nullable = false, unique = true)
    private String tenantCode;

    /**
     * 创建人Id
     */
    @Column(name = "creator_id", length = 36)
    private String creatorId;

    /**
     * 创建人账号
     */
    @Column(name = "creator_account", length = 50)
    private String creatorAccount;

    /**
     * 创建人名称
     */
    @Column(name = "creator_name", length = 50)
    private String creatorName;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdDate;

    /**
     * 最后修改人Id
     */
    @Column(name = "last_editor_id", length = 36)
    private String lastEditorId;

    /**
     * 最后修改人账号
     */
    @Column(name = "last_editor_account", length = 50)
    private String lastEditorAccount;

    /**
     * 最后修改人名称
     */
    @Column(name = "last_editor_name", length = 50)
    private String lastEditorName;

    /**
     * 最后修改时间
     */
    @Column(name = "last_edited_date")
    private Date lastEditedDate;

    @Override
    public String getId() { return id; }

    @Override
    public void setId(String id) { this.id = id; }

    @Override
    public String getCode() { return code; }

    @Override
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public TaxCategory getTaxCategory() { return taxCategory; }

    public void setTaxCategory(TaxCategory taxCategory) { this.taxCategory = taxCategory; }

    public Double getTaxRate() { return taxRate; }

    public void setTaxRate(Double taxRate) { this.taxRate = taxRate; }

    @Override
    public Integer getRank() { return rank; }

    public void setRank(Integer rank) { this.rank = rank; }

    public String getLedgerAccountCode() { return ledgerAccountCode; }

    public void setLedgerAccountCode(String ledgerAccountCode) { this.ledgerAccountCode = ledgerAccountCode; }

    public String getLedgerAccountName() { return ledgerAccountName; }

    public void setLedgerAccountName(String ledgerAccountName) { this.ledgerAccountName = ledgerAccountName; }

    @Override
    public String getTenantCode() { return tenantCode; }

    @Override
    public void setTenantCode(String tenantCode) { this.tenantCode = tenantCode; }

    @Override
    public String getCreatorId() { return creatorId; }

    @Override
    public void setCreatorId(String creatorId) { this.creatorId = creatorId; }

    @Override
    public String getCreatorAccount() { return creatorAccount; }

    @Override
    public void setCreatorAccount(String creatorAccount) { this.creatorAccount = creatorAccount; }

    @Override
    public String getCreatorName() { return creatorName; }

    @Override
    public void setCreatorName(String creatorName) { this.creatorName = creatorName; }

    @Override
    public Date getCreatedDate() { return createdDate; }

    @Override
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

    @Override
    public String getLastEditorId() { return lastEditorId; }

    @Override
    public void setLastEditorId(String lastEditorId) { this.lastEditorId = lastEditorId; }

    @Override
    public String getLastEditorAccount() { return lastEditorAccount; }

    @Override
    public void setLastEditorAccount(String lastEditorAccount) { this.lastEditorAccount = lastEditorAccount; }

    @Override
    public String getLastEditorName() { return lastEditorName; }

    @Override
    public void setLastEditorName(String lastEditorName) { this.lastEditorName = lastEditorName; }

    @Override
    public Date getLastEditedDate() { return lastEditedDate; }

    @Override
    public void setLastEditedDate(Date lastEditedDate) { this.lastEditedDate = lastEditedDate; }
}