package com.changhong.sei.dms.general.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.ICodeUnique;
import com.changhong.sei.core.entity.ITenant;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 备用金员工(ERP)(ImprestEmployee)实体类
 *
 * @author sei
 * @since 2021-04-20 16:40:26
 */
@Entity
@Table(name = "imprest_employee")
@DynamicInsert
@DynamicUpdate
public class ImprestEmployee extends BaseAuditableEntity implements Serializable, ICodeUnique, ITenant {
    private static final long serialVersionUID = -27010002538430308L;
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
     * 名称缩写
     */
    @Column(name = "short_name")
    private String shortName;
    /**
     * 员工编号
     */
    @Column(name = "personnel_code")
    private String personnelCode;
    /**
     * 身份证
     */
    @Column(name = "id_card")
    private String idCard;
    /**
     * 移动电话
     */
    @Column(name = "mobile")
    private String mobile;
    /**
     * 说明
     */
    @Column(name = "remark")
    private String remark;
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getPersonnelCode() {
        return personnelCode;
    }

    public void setPersonnelCode(String personnelCode) {
        this.personnelCode = personnelCode;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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