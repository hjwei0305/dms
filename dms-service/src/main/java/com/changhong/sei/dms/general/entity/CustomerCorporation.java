package com.changhong.sei.dms.general.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.IFrozen;
import com.changhong.sei.core.entity.ITenant;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 客户的公司视图(CustomerCorporation)实体类
 *
 * @author sei
 * @since 2021-05-06 13:09:31
 */
@Entity
@Table(name = "customer_corporation")
@DynamicInsert
@DynamicUpdate
public class CustomerCorporation extends BaseAuditableEntity implements Serializable, ITenant, IFrozen {
    private static final long serialVersionUID = 549392523730992071L;
    /**
     * 客户Id
     */
    @Column(name = "customer_id")
    private String customerId;
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
    private Boolean frozen = Boolean.FALSE;
    /**
     * 支付冻结标识
     */
    @Column(name = "pay_frozen")
    private Boolean payFrozen = Boolean.FALSE;
    /**
     * 租户代码
     */
    @Column(name = "tenant_code")
    private String tenantCode;


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    @Override
    public Boolean getFrozen() {
        return frozen;
    }

    @Override
    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    public Boolean getPayFrozen() {
        return payFrozen;
    }

    public void setPayFrozen(Boolean payFrozen) {
        this.payFrozen = payFrozen;
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