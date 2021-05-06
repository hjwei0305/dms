package com.changhong.sei.dms.general.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.ICodeUnique;
import com.changhong.sei.core.entity.ITenant;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 汇率(ExchangeRate)实体类
 *
 * @author sei
 * @since 2021-05-06 17:04:01
 */
@Entity
@Table(name = "exchange_rate")
@DynamicInsert
@DynamicUpdate
public class ExchangeRate extends BaseAuditableEntity implements Serializable, ICodeUnique, ITenant {
    private static final long serialVersionUID = -33238461864643042L;
    /**
     * 代码
     */
    @Column(name = "code")
    private String code;
    /**
     * 汇率类型
     */
    @Column(name = "rate_type")
    private String rateType;
    /**
     * 生效起始日期
     */
    @Column(name = "start_date")
    private Date startDate;
    /**
     * 货币（从）
     */
    @Column(name = "from_currency")
    private String fromCurrency;
    /**
     * 货币（到）
     */
    @Column(name = "to_currency")
    private String toCurrency;
    /**
     * 比率（从）
     */
    @Column(name = "from_unit")
    private Integer fromUnit;
    /**
     * 比率（到）
     */
    @Column(name = "to_unit")
    private Integer toUnit;
    /**
     * 汇率
     */
    @Column(name = "rate")
    private Double rate;
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

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public Integer getFromUnit() {
        return fromUnit;
    }

    public void setFromUnit(Integer fromUnit) {
        this.fromUnit = fromUnit;
    }

    public Integer getToUnit() {
        return toUnit;
    }

    public void setToUnit(Integer toUnit) {
        this.toUnit = toUnit;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
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