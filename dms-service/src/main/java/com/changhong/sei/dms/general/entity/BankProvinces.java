package com.changhong.sei.dms.general.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.ICodeUnique;
import com.changhong.sei.core.entity.ITenant;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 银行省区(BankProvinces)实体类
 *
 * @author sei
 * @since 2021-05-07 14:34:37
 */
@Entity
@Table(name = "bank_provinces")
@DynamicInsert
@DynamicUpdate
public class BankProvinces extends BaseAuditableEntity implements Serializable, ICodeUnique, ITenant {
    private static final long serialVersionUID = -29950594657524757L;
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

    @Override
    public String getTenantCode() {
        return tenantCode;
    }

    @Override
    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }
}