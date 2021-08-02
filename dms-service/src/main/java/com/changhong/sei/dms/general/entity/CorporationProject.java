package com.changhong.sei.dms.general.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.IFrozen;
import com.changhong.sei.core.entity.ITenant;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
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
     * WBS项目Id
     */
    @Column(name = "wbs_project_id")
    private String wbsProjectId;
    /**
     * WBS项目
     */
    @ManyToOne
    @JoinColumn(name = "wbs_project_id", updatable = false, insertable = false)
    private WbsProject wbsProject;
    /**
     * 内部订单Id
     */
    @Column(name = "inner_order_id")
    private String innerOrderId;
    /**
     * WBS项目
     */
    @ManyToOne
    @JoinColumn(name = "inner_order_id", updatable = false, insertable = false)
    private InnerOrder innerOrder;
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

    public String getWbsProjectId() {
        return wbsProjectId;
    }

    public void setWbsProjectId(String wbsProjectId) {
        this.wbsProjectId = wbsProjectId;
    }

    public String getInnerOrderId() {
        return innerOrderId;
    }

    public void setInnerOrderId(String innerOrderId) {
        this.innerOrderId = innerOrderId;
    }

    public WbsProject getWbsProject() {
        return wbsProject;
    }

    public void setWbsProject(WbsProject wbsProject) {
        this.wbsProject = wbsProject;
    }

    public InnerOrder getInnerOrder() {
        return innerOrder;
    }

    public void setInnerOrder(InnerOrder innerOrder) {
        this.innerOrder = innerOrder;
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