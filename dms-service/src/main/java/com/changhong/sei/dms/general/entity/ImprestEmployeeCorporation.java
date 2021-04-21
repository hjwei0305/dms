package com.changhong.sei.dms.general.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.ITenant;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 公司的备用金员工(ERP)(ImprestEmployeeCorporation)实体类
 *
 * @author sei
 * @since 2021-04-20 17:06:38
 */
@Entity
@Table(name = "imprest_employee_corporation")
@DynamicInsert
@DynamicUpdate
public class ImprestEmployeeCorporation extends BaseAuditableEntity implements Serializable, ITenant {
    private static final long serialVersionUID = -94141310572634904L;
    /**
     * 备用金员工Id
     */
    @Column(name = "imprest_employee_id")
    private String imprestEmployeeId;
    /**
     * 备用金员工
     */
    @ManyToOne
    @JoinColumn(name = "imprest_employee_id", insertable = false, updatable = false)
    private ImprestEmployee imprestEmployee;
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
     * 已冻结
     */
    @Column(name = "frozen")
    private Boolean frozen;
    /**
     * 租户代码
     */
    @Column(name = "tenant_code")
    private String tenantCode;


    public String getImprestEmployeeId() {
        return imprestEmployeeId;
    }

    public void setImprestEmployeeId(String imprestEmployeeId) {
        this.imprestEmployeeId = imprestEmployeeId;
    }

    public ImprestEmployee getImprestEmployee() {
        return imprestEmployee;
    }

    public void setImprestEmployee(ImprestEmployee imprestEmployee) {
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