package com.changhong.sei.dms.general.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.ICodeUnique;
import com.changhong.sei.core.entity.ITenant;
import com.changhong.sei.dms.management.dto.WorkingStatusEnum;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 公司员工(ERP)(Personnel)实体类
 *
 * @author sei
 * @since 2021-04-19 10:18:17
 */
@Entity
@Table(name = "personnel")
@DynamicInsert
@DynamicUpdate
public class Personnel extends BaseAuditableEntity implements Serializable, ICodeUnique, ITenant {
    private static final long serialVersionUID = 677012805260200690L;
    /**
     * 员工编号
     */
    @Column(name = "code", length = 10, nullable = false)
    private String code;
    /**
     * 姓名
     */
    @Column(name = "name", length = 40, nullable = false)
    private String name;
    /**
     * 姓名缩写
     */
    @Column(name = "short_name", length = 40)
    private String shortName;
    /**
     * 身份证
     */
    @Column(name = "id_card", nullable = false)
    private String idCard;
    /**
     * ERP公司代码
     */
    @Column(name = "erp_corporation_code", nullable = false)
    private String erpCorporationCode;
    /**
     * 员工组
     */
    @Column(name = "personnel_group", nullable = false)
    private String personnelGroup;
    /**
     * 在职状态
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "working_status", nullable = false)
    private WorkingStatusEnum workingStatus;
    /**
     * HR组织机构代码
     */
    @Column(name = "hr_organization_code", nullable = false)
    private String hrOrganizationCode;
    /**
     * HR组织名称名称
     */
    @Column(name = "hr_organization_name")
    private String hrOrganizationName;
    /**
     * 成本中心代码
     */
    @Column(name = "cost_center_code")
    private String costCenterCode;
    /**
     * 性别(M:男、F:女)
     */
    @Column(name = "gender", nullable = false)
    private String gender;
    /**
     * 职位等级
     */
    @Column(name = "post_grade")
    private String postGrade;
    /**
     * 生日
     */
    @Column(name = "birthday")
    private Date birthday;
    /**
     * 电子邮件
     */
    @Column(name = "email")
    private String email;
    /**
     * 移动电话
     */
    @Column(name = "mobile")
    private String mobile;
    /**
     * 座机电话
     */
    @Column(name = "telephone")
    private String telephone;
    /**
     * 邮政编码
     */
    @Column(name = "postal_code")
    private String postalCode;
    /**
     * 通信地址
     */
    @Column(name = "mailing_address")
    private String mailingAddress;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getErpCorporationCode() {
        return erpCorporationCode;
    }

    public void setErpCorporationCode(String erpCorporationCode) {
        this.erpCorporationCode = erpCorporationCode;
    }

    public String getPersonnelGroup() {
        return personnelGroup;
    }

    public void setPersonnelGroup(String personnelGroup) {
        this.personnelGroup = personnelGroup;
    }

    public WorkingStatusEnum getWorkingStatus() {
        return workingStatus;
    }

    public void setWorkingStatus(WorkingStatusEnum workingStatus) {
        this.workingStatus = workingStatus;
    }

    public String getHrOrganizationCode() {
        return hrOrganizationCode;
    }

    public void setHrOrganizationCode(String hrOrganizationCode) {
        this.hrOrganizationCode = hrOrganizationCode;
    }

    public String getHrOrganizationName() {
        return hrOrganizationName;
    }

    public void setHrOrganizationName(String hrOrganizationName) {
        this.hrOrganizationName = hrOrganizationName;
    }

    public String getCostCenterCode() {
        return costCenterCode;
    }

    public void setCostCenterCode(String costCenterCode) {
        this.costCenterCode = costCenterCode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPostGrade() {
        return postGrade;
    }

    public void setPostGrade(String postGrade) {
        this.postGrade = postGrade;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
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