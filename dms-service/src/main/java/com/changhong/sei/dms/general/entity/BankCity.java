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
 * 银行城市(BankCity)实体类
 *
 * @author sei
 * @since 2021-05-07 15:13:00
 */
@Entity
@Table(name = "bank_city")
@DynamicInsert
@DynamicUpdate
public class BankCity extends BaseAuditableEntity implements Serializable, ICodeUnique, IFrozen, IRank, ITenant {
    private static final long serialVersionUID = -41274459418251958L;
    /**
     * 代码
     */
    @Column(name = "code")
    private String code;
    /**
     * 银行省区Id
     */
    @Column(name = "bank_province_id")
    private String bankProvinceId;
    /**
     * 银行省区
     */
    @ManyToOne
    @JoinColumn(name = "bank_province_id", insertable = false, updatable = false)
    private BankProvinces bankProvince;
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

    public String getBankProvinceId() {
        return bankProvinceId;
    }

    public void setBankProvinceId(String bankProvinceId) {
        this.bankProvinceId = bankProvinceId;
    }

    public BankProvinces getBankProvince() {
        return bankProvince;
    }

    public void setBankProvince(BankProvinces bankProvince) {
        this.bankProvince = bankProvince;
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