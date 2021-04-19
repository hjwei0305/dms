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
 * WBS项目(WbsProject)实体类
 *
 * @author sei
 * @since 2021-04-19 16:58:43
 */
@Entity
@Table(name = "wbs_project")
@DynamicInsert
@DynamicUpdate
public class WbsProject extends BaseAuditableEntity implements Serializable, ICodeUnique, ITenant, IFrozen {
    private static final long serialVersionUID = -84078908592984994L;
    /**
     * 代码
     */
    @Column(name = "code", length = 30, nullable = false)
    private String code;
    /**
     * 名称
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    /**
     * 父节点代码
     */
    @Column(name = "parent_code", length = 30)
    private String parentCode;
    /**
     * 项目类型
     */
    @Column(name = "project_type", length = 2, nullable = false)
    private String projectType;
    /**
     * ERP公司代码
     */
    @Column(name = "erp_corporation_code", length = 4, nullable = false)
    private String erpCorporationCode;
    /**
     * 层级
     */
    @Column(name = "node_level", nullable = false)
    private Integer nodeLevel;
    /**
     * 成本中心代码
     */
    @Column(name = "cost_center_code", length = 10)
    private String costCenterCode;
    /**
     * 业务范围代码
     */
    @Column(name = "range_code", length = 4)
    private String rangeCode;
    /**
     * ERP创建日期
     */
    @Column(name = "erp_create_date")
    private Date erpCreateDate;
    /**
     * 总账科目代码
     */
    @Column(name = "ledger_account_code", length = 10)
    private String ledgerAccountCode;
    /**
     * 总账科目名称
     */
    @Column(name = "ledger_account_name", length = 200)
    private String ledgerAccountName;
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

    /**
     * 子节点列表
     */
    @Transient
    private List<WbsProject> children;

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

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getErpCorporationCode() {
        return erpCorporationCode;
    }

    public void setErpCorporationCode(String erpCorporationCode) {
        this.erpCorporationCode = erpCorporationCode;
    }

    public Integer getNodeLevel() {
        return nodeLevel;
    }

    public void setNodeLevel(Integer nodeLevel) {
        this.nodeLevel = nodeLevel;
    }

    public String getCostCenterCode() {
        return costCenterCode;
    }

    public void setCostCenterCode(String costCenterCode) {
        this.costCenterCode = costCenterCode;
    }

    public String getRangeCode() {
        return rangeCode;
    }

    public void setRangeCode(String rangeCode) {
        this.rangeCode = rangeCode;
    }

    public Date getErpCreateDate() {
        return erpCreateDate;
    }

    public void setErpCreateDate(Date erpCreateDate) {
        this.erpCreateDate = erpCreateDate;
    }

    public String getLedgerAccountCode() {
        return ledgerAccountCode;
    }

    public void setLedgerAccountCode(String ledgerAccountCode) {
        this.ledgerAccountCode = ledgerAccountCode;
    }

    public String getLedgerAccountName() {
        return ledgerAccountName;
    }

    public void setLedgerAccountName(String ledgerAccountName) {
        this.ledgerAccountName = ledgerAccountName;
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

    public List<WbsProject> getChildren() {
        return children;
    }

    public void setChildren(List<WbsProject> children) {
        this.children = children;
    }
}