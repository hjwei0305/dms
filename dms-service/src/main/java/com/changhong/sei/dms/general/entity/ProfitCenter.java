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
 * 利润中心(ProfitCenter)实体类
 *
 * @author sei
 * @since 2021-07-30 14:57:52
 */
@Entity
@Table(name = "profit_center")
@DynamicInsert
@DynamicUpdate
public class ProfitCenter extends BaseAuditableEntity implements Serializable, ICodeUnique, ITenant, IFrozen {
    private static final long serialVersionUID = -30529602277856354L;
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
     * 利润中心组
     */
    @Column(name = "profit_group")
    private String profitGroup;
    /**
     * 负责人
     */
    @Column(name = "key_person")
    private String keyPerson;
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

    public String getProfitGroup() {
        return profitGroup;
    }

    public void setProfitGroup(String profitGroup) {
        this.profitGroup = profitGroup;
    }

    public String getKeyPerson() {
        return keyPerson;
    }

    public void setKeyPerson(String keyPerson) {
        this.keyPerson = keyPerson;
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