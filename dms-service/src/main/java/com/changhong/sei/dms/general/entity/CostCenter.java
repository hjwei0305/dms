package com.changhong.sei.dms.general.entity;

import com.changhong.sei.core.dto.IRank;
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
import java.util.Date;

/**
 * 成本中心(CostCenter)实体类
 *
 * @author sei
 * @since 2021-04-16 11:17:11
 */
@Entity
@Table(name = "cost_center")
@DynamicInsert
@DynamicUpdate
public class CostCenter extends BaseAuditableEntity implements Serializable, ICodeUnique, ITenant, IFrozen {
    private static final long serialVersionUID = 218780805691278588L;
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
     * ERP公司代码
     */
    @Column(name = "erp_corporation_code")
    private String erpCorporationCode;
    /**
     * 分类码
     */
    @Column(name = "category_code")
    private String categoryCode;
    /**
     * 货币代码
     */
    @Column(name = "currency")
    private String currency;
    /**
     * 起始日期
     */
    @Column(name = "start_date")
    private Date startDate;
    /**
     * 截止日期
     */
    @Column(name = "end_date")
    private Date endDate;
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
     * 利润中心代码
     */
    @Column(name = "profit_center_code")
    private String profitCenterCode;
    /**
     * 功能范围
     */
    @Column(name = "feature_range")
    private String featureRange;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public String getProfitCenterCode() {
        return profitCenterCode;
    }

    public void setProfitCenterCode(String profitCenterCode) {
        this.profitCenterCode = profitCenterCode;
    }

    public String getFeatureRange() {
        return featureRange;
    }

    public void setFeatureRange(String featureRange) {
        this.featureRange = featureRange;
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