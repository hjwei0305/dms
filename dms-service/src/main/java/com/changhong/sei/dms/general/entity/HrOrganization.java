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
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * HR组织机构(ERP)(HrOrganization)实体类
 *
 * @author sei
 * @since 2021-04-19 14:59:01
 */
@Entity
@Table(name = "hr_organization")
@DynamicInsert
@DynamicUpdate
public class HrOrganization extends BaseAuditableEntity implements Serializable, ICodeUnique, ITenant, IFrozen {
    private static final long serialVersionUID = -60967128016047253L;
    /**
     * 代码
     */
    @Column(name = "code", length = 8, nullable = false)
    private String code;
    /**
     * 名称
     */
    @Column(name = "name", length = 40, nullable = false)
    private String name;
    /**
     * 父节点代码
     */
    @Column(name = "parent_code", length = 8)
    private String parentCode;
    /**
     * 成本中心代码
     */
    @Column(name = "cost_center_code", length = 10)
    private String costCenterCode;
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
     * 组织机构Id
     */
    @Column(name = "organization_id")
    private String organizationId;
    /**
     * 已冻结
     */
    @Column(name = "frozen", nullable = false)
    private Boolean frozen = Boolean.FALSE;
    /**
     * 租户代码
     */
    @Column(name = "tenant_code")
    private String tenantCode;

    /**
     * 子节点列表
     */
    @Transient
    private List<HrOrganization> children;

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

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getCostCenterCode() {
        return costCenterCode;
    }

    public void setCostCenterCode(String costCenterCode) {
        this.costCenterCode = costCenterCode;
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

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
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

    public List<HrOrganization> getChildren() {
        return children;
    }

    public void setChildren(List<HrOrganization> children) {
        this.children = children;
    }
}