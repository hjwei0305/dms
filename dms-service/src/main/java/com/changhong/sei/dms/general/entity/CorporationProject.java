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
 * 公司项目(CorporationProject)实体类
 *
 * @author sei
 * @since 2021-07-31 16:02:40
 */
@Entity
@Table(name = "corporation_project")
@DynamicInsert
@DynamicUpdate
public class CorporationProject extends BaseAuditableEntity implements Serializable, IFrozen, ITenant {
    private static final long serialVersionUID = 625515561127872327L;
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
     * WBS项目编号
     */
    @Column(name = "wbs_project_code")
    private String wbsProjectCode;
    /**
     * WBS项目名称
     */
    @Column(name = "wbs_project_name")
    private String wbsProjectName;
    /**
     * 内部订单编号
     */
    @Column(name = "inner_order_code")
    private String innerOrderCode;
    /**
     * 内部订单名称
     */
    @Column(name = "inner_order_name")
    private String innerOrderName;
    /**
     * 冻结标识
     */
    @Column(name = "frozen")
    private Boolean frozen;
    /**
     * 租户代码
     */
    @Column(name = "tenant_code")
    private String tenantCode;


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

    public String getWbsProjectCode() {
        return wbsProjectCode;
    }

    public void setWbsProjectCode(String wbsProjectCode) {
        this.wbsProjectCode = wbsProjectCode;
    }

    public String getWbsProjectName() {
        return wbsProjectName;
    }

    public void setWbsProjectName(String wbsProjectName) {
        this.wbsProjectName = wbsProjectName;
    }

    public String getInnerOrderCode() {
        return innerOrderCode;
    }

    public void setInnerOrderCode(String innerOrderCode) {
        this.innerOrderCode = innerOrderCode;
    }

    public String getInnerOrderName() {
        return innerOrderName;
    }

    public void setInnerOrderName(String innerOrderName) {
        this.innerOrderName = innerOrderName;
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