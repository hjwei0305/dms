package com.changhong.sei.dms.general.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 总帐科目的公司视图(LedgerAccountCorporation)实体类
 *
 * @author sei
 * @since 2021-04-16 16:28:18
 */
@Entity
@Table(name = "ledger_account_corporation")
@DynamicInsert
@DynamicUpdate
public class LedgerAccountCorporation extends BaseAuditableEntity implements Serializable {
    private static final long serialVersionUID = -28512789568531175L;
    /**
     * 总账科目Id
     */
    @Column(name = "ledger_account_id")
    private String ledgerAccountId;
    /**
     * ERP公司代码
     */
    @Column(name = "erp_corporation_code")
    private String erpCorporationCode;
    /**
     * 统驭科目标识
     */
    @Column(name = "category_code")
    private String categoryCode;
    /**
     * 税务类型
     */
    @Column(name = "tax_category_code")
    private String taxCategoryCode;
    /**
     * 允许无税码过账
     */
    @Column(name = "allow_no_tax")
    private Boolean allowNoTax = Boolean.FALSE;
    /**
     * 字段状态组
     */
    @Column(name = "field_group")
    private String fieldGroup;
    /**
     * 已冻结
     */
    @Column(name = "frozen")
    private Boolean frozen = Boolean.FALSE;
    /**
     * 租户代码
     */
    @Column(name = "tenant_code")
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