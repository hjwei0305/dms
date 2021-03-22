package com.changhong.sei.dms.general.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.ICodeUnique;
import com.changhong.sei.core.entity.IFrozen;
import com.changhong.sei.core.entity.ITenant;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 计量单位
 * Author:jamson
 * date:2018/1/8
 */
@Entity
@Table(name = "unit")
@Access(AccessType.FIELD)
@DynamicInsert
@DynamicUpdate
public class Unit extends BaseAuditableEntity implements IFrozen, ITenant, ICodeUnique {

    public static final String NAME = "name";
    private static final long serialVersionUID = 5428749188960737205L;

    /**
     * 代码
     */
    @Column(name = "code", length = 20, nullable = false, unique = true)
    private String code;
    /**
     * 名称
     */
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    /**
     * 单位描述
     */
    @Column(name = "unit_desc", length = 32, nullable = false)
    private String unitDesc;

    /**
     * 租户代码
     */
    @Column(name = "tenant_code", length = 50, nullable = false)
    private String tenantCode;

    /**
     * 冻结
     */
    @Column(name = "frozen", nullable = false)
    private Boolean frozen = Boolean.FALSE;

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

    @Override
    public String getTenantCode() {
        return tenantCode;
    }

    @Override
    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    @Override
    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    public String getUnitDesc() {
        return unitDesc;
    }

    public void setUnitDesc(String unitDesc) {
        this.unitDesc = unitDesc;
    }
}
