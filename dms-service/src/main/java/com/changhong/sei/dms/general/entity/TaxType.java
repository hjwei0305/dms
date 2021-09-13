package com.changhong.sei.dms.general.entity;

import com.changhong.sei.core.dto.IRank;
import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.ICodeUnique;
import com.changhong.sei.core.entity.ITenant;
import com.changhong.sei.dms.general.dto.TaxCategory;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;

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
public class TaxType extends BaseAuditableEntity implements ICodeUnique, IRank, ITenant {
    private static final long serialVersionUID = -1710768247895818110L;
    /**
     * Id
     */
    @Column(name = "id", length = 36, nullable = false, unique = true)
    private String id;

    /**
     * 税码
     */
    @Column(name = "code", length = 10, nullable = false, unique = true)
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
    private BigDecimal taxRate = BigDecimal.ZERO;

    /**
     * 排序
     */
    @Column(name = "rank", nullable = false)
    private Integer rank = 0;

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
     * 转出科目代码
     */
    @Column(name = "transfer_account_code", length = 20)
    private String transferAccountCode;

    /**
     * 转出科目名称
     */
    @Column(name = "transfer_account_name", length = 100)
    private String transferAccountName;

    /**
     * 租户代码
     */
    @Column(name = "tenant_code", length = 10, nullable = false, unique = true)
    private String tenantCode;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
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

    @Override
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

    @Override
    public String getTenantCode() {
        return tenantCode;
    }

    @Override
    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }
}