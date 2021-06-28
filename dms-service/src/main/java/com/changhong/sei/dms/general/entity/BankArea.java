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
 * 银行地区(BankArea)实体类
 *
 * @author sei
 * @since 2021-05-07 15:55:09
 */
@Entity
@Table(name = "bank_area")
@DynamicInsert
@DynamicUpdate
public class BankArea extends BaseAuditableEntity implements Serializable, ICodeUnique, IFrozen, IRank, ITenant {
    private static final long serialVersionUID = 997432399095487489L;
    /**
     * 代码
     */
    @Column(name = "code")
    private String code;
    /**
     * 行政区域Id
     */
    @Column(name = "region_id")
    private String regionId;
    /**
     * 行政区域
     */
    @ManyToOne
    @JoinColumn(name = "region_id", insertable = false, updatable = false)
    private Region region;
    /**
     * 银行城市Id
     */
    @Column(name = "bank_city_id")
    private String bankCityId;
    /**
     * 银行城市
     */
    @ManyToOne
    @JoinColumn(name = "bank_city_id", insertable = false, updatable = false)
    private BankCity bankCity;
    /**
     * 级别代码
     */
    @Column(name = "level_code")
    private Integer levelCode;
    /**
     * 级别名称
     */
    @Column(name = "level_name")
    private String levelName;
    /**
     * 已冻结
     */
    @Column(name = "frozen")
    private Boolean frozen;
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

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }


    public String getBankCityId() {
        return bankCityId;
    }

    public void setBankCityId(String bankCityId) {
        this.bankCityId = bankCityId;
    }

    public BankCity getBankCity() {
        return bankCity;
    }

    public void setBankCity(BankCity bankCity) {
        this.bankCity = bankCity;
    }

    public Integer getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(Integer levelCode) {
        this.levelCode = levelCode;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
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

}