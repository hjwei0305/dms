
package com.changhong.sei.dms.general.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.ICodeUnique;
import com.changhong.sei.core.entity.IFrozen;
import com.changhong.sei.core.entity.ITenant;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


/**
 * 实现功能：税率
 *
 * @author 秦嘉
 * @version 1.0.00
 */
@Entity
@Table(name = "tax_rate")
@Access(AccessType.FIELD)
@DynamicInsert
@DynamicUpdate
public class TaxRate extends BaseAuditableEntity implements ITenant, ICodeUnique, IFrozen {
    private static final long serialVersionUID = -7478208606931406061L;
    /**
     * 代码
     */
    @Column(name = "code", length = 20, nullable = false)
    private String code;

    /**
     * 名称
     */
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    /**
     * 税率
     */
    @Column(name = "tax_rate", nullable = false)
    private Double taxRate;

    /**
     * 冻结
     */
    @Column(name = "frozen")
    private Boolean frozen = Boolean.FALSE;
    /**
     * 租户代码
     */
    @Column(name = "tenant_code", length = 50, nullable = false)
    private String tenantCode;

    /**
     * 税率的百分比形式
     */
    @Transient
    private String ratePercent;

    public String getRatePercent() {
        return ratePercent;
    }

    public void setRatePercent(String ratePercent) {
        this.ratePercent = ratePercent;
    }

    @Override
    public String getTenantCode() {
        return tenantCode;
    }

    @Override
    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

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

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }
}
