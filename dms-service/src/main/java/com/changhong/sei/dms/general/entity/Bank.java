package com.changhong.sei.dms.general.entity;

import com.changhong.sei.core.dto.IRank;
import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.ICodeUnique;
import com.changhong.sei.core.entity.IFrozen;
import com.changhong.sei.core.entity.ITenant;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 银行(Bank)实体类
 *
 * @author sei
 * @since 2021-06-25 11:10:31
 */
@Entity
@Table(name = "bank")
@DynamicInsert
@DynamicUpdate
public class Bank extends BaseAuditableEntity implements Serializable, ICodeUnique, IFrozen, IRank, ITenant {
    private static final long serialVersionUID = -93663508868424226L;
    /**
     * 银行行号
     */
    @Column(name = "code")
    private String code;
    /**
     * 银行行名
     */
    @Column(name = "name")
    private String name;
    /**
     * 银行行别Id
     */
    @Column(name = "bank_category_id")
    private String bankCategoryId;
    /**
     * 银行行别Id
     */
    @ManyToOne
    @JoinColumn(name = "bank_category_id", insertable = false, updatable = false)
    private BankCategory bankCategory;
    /**
     * 银行地区Id
     */
    @Column(name = "bank_area_id")
    private String bankAreaId;
    /**
     * 银行地区Id
     */
    @ManyToOne
    @JoinColumn(name = "bank_area_id", insertable = false, updatable = false)
    private BankArea bankArea;
    /**
     * ERP银行代码
     */
    @Column(name = "erp_bank_code")
    private String erpBankCode;
    /**
     * 排序
     */
    @Column(name = "rank")
    private Integer rank;
    /**
     * 租户代码
     */
    @Column(name = "tenant_code")
    private String tenantCode;
    /**
     * 已冻结
     */
    @Column(name = "frozen")
    private Boolean frozen;

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

    public String getBankCategoryId() {
        return bankCategoryId;
    }

    public void setBankCategoryId(String bankCategoryId) {
        this.bankCategoryId = bankCategoryId;
    }

    public BankCategory getBankCategory() {
        return bankCategory;
    }

    public void setBankCategory(BankCategory bankCategory) {
        this.bankCategory = bankCategory;
    }

    public String getBankAreaId() {
        return bankAreaId;
    }

    public void setBankAreaId(String bankAreaId) {
        this.bankAreaId = bankAreaId;
    }

    public BankArea getBankArea() {
        return bankArea;
    }

    public void setBankArea(BankArea bankArea) {
        this.bankArea = bankArea;
    }

    public String getErpBankCode() {
        return erpBankCode;
    }

    public void setErpBankCode(String erpBankCode) {
        this.erpBankCode = erpBankCode;
    }

    @Override
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public String getTenantCode() {
        return tenantCode;
    }

    @Override
    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    @Override
    public Boolean getFrozen() {
        return frozen;
    }

    @Override
    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

}