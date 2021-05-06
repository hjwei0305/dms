package com.changhong.sei.dms.general.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.IFrozen;
import com.changhong.sei.core.entity.ITenant;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 供应商的公司信息(SupplierCorporation)实体类
 *
 * @author sei
 * @since 2021-05-06 14:08:14
 */
@Entity
@Table(name = "supplier_corporation")
@DynamicInsert
@DynamicUpdate
public class SupplierCorporation extends BaseAuditableEntity implements Serializable, ITenant, IFrozen {
    private static final long serialVersionUID = 802624109277219982L;
    /**
     * 供应商Id
     */
    @Column(name = "supplier_id")
    private String supplierId;
    /**
     * 供应商
     */
    @ManyToOne
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    private Supplier supplier;
    /**
     * ERP公司代码
     */
    @Column(name = "erp_corporation_code")
    private String erpCorporationCode;
    /**
     * 统驭科目代码
     */
    @Column(name = "account_code")
    private String accountCode;
    /**
     * 支付条款代码
     */
    @Column(name = "payment_term_code")
    private String paymentTermCode;
    /**
     * 支付冻结
     */
    @Column(name = "pay_frozen")
    private Boolean payFrozen = Boolean.FALSE;
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


    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
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

    @Override
    public Boolean getFrozen() {
        return frozen;
    }

    @Override
    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
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