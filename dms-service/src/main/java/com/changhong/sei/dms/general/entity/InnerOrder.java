package com.changhong.sei.dms.general.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.ICodeUnique;
import com.changhong.sei.core.entity.IFrozen;
import com.changhong.sei.core.entity.ITenant;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 内部订单(InnerOrder)实体类
 *
 * @author sei
 * @since 2021-04-16 14:19:31
 */
@Entity
@Table(name = "inner_order")
@DynamicInsert
@DynamicUpdate
public class InnerOrder extends BaseAuditableEntity implements Serializable, ICodeUnique, ITenant, IFrozen {
    private static final long serialVersionUID = 878352427446969959L;
    /**
     * 代码
     */
    @Column(name = "code")
    private String code;
    /**
     * 名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 订单类型
     */
    @Column(name = "order_type")
    private String orderType;
    /**
     * ERP公司代码
     */
    @Column(name = "erp_corporation_code")
    private String erpCorporationCode;
    /**
     * 货币代码
     */
    @Column(name = "currency_code")
    private String currencyCode;
    /**
     * 业务范围
     */
    @Column(name = "cost_range")
    private String costRange;
    /**
     * 负责人
     */
    @Column(name = "key_person")
    private String keyPerson;
    /**
     * 成本中心代码
     */
    @Column(name = "cost_center_code")
    private String costCenterCode;
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

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getErpCorporationCode() {
        return erpCorporationCode;
    }

    public void setErpCorporationCode(String erpCorporationCode) {
        this.erpCorporationCode = erpCorporationCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCostRange() {
        return costRange;
    }

    public void setCostRange(String costRange) {
        this.costRange = costRange;
    }

    public String getKeyPerson() {
        return keyPerson;
    }

    public void setKeyPerson(String keyPerson) {
        this.keyPerson = keyPerson;
    }

    public String getCostCenterCode() {
        return costCenterCode;
    }

    public void setCostCenterCode(String costCenterCode) {
        this.costCenterCode = costCenterCode;
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