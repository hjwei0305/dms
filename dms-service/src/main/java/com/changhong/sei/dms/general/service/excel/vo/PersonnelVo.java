package com.changhong.sei.dms.general.service.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.changhong.sei.dms.common.excel.BaseExcelRow;
import com.changhong.sei.dms.common.excel.validate.NotDuplicate;
import com.changhong.sei.dms.general.dto.WorkingStatusEnum;
import com.changhong.sei.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 实现功能:公司员工(ERP)(Personnel)Excel导入导出模版vo
 *
 * @author 冯华
 * @create 2021-04-19 13:29
 */
public class PersonnelVo extends BaseExcelRow implements Serializable {
    private static final long serialVersionUID = 180242271037929170L;

    /**
     * 员工编号
     */
    @NotDuplicate
    @NotBlank
    @ExcelProperty(value = "员工编号", order = 1)
    private String code;
    /**
     * 姓名
     */
    @NotBlank
    @ExcelProperty(value = "姓名", order = 2)
    private String name;
    /**
     * 姓名缩写
     */
    @ExcelProperty(value = "姓名缩写", order = 3)
    private String shortName;
    /**
     * 身份证
     */
    @NotBlank
    @NotDuplicate
    @ExcelProperty(value = "身份证", order = 4)
    private String idCard;
    /**
     * ERP公司代码
     */
    @NotBlank
    @ExcelProperty(value = "ERP公司代码", order = 5)
    private String erpCorporationCode;
    /**
     * 员工组
     */
    @ExcelProperty(value = "员工组", order = 6)
    private String personnelGroup;
    /**
     * 在职状态
     */
    @NotNull
    @ExcelProperty(value = "在职状态", order = 7)
    private WorkingStatusEnum workingStatus;
    /**
     * HR组织机构代码
     */
    @NotBlank
    @ExcelProperty(value = "HR组织机构代码", order = 8)
    private String hrOrganizationCode;
    /**
     * HR组织名称名称
     */
    @ExcelProperty(value = "HR组织名称名称", order = 9)
    private String hrOrganizationName;
    /**
     * 成本中心代码
     */
    @ExcelProperty(value = "成本中心代码", order = 10)
    private String costCenterCode;
    /**
     * 性别(M:男、F:女)
     */
    @NotBlank
    @ExcelProperty(value = "性别(M:男、F:女)", order = 11)
    private String gender;
    /**
     * 职位等级
     */
    @ExcelProperty(value = "职位等级", order = 12)
    private String postGrade;
    /**
     * 生日
     */
    @ExcelProperty(value = "生日", order = 13)
    @DateTimeFormat(pattern = DateUtils.DEFAULT_DATE_FORMAT)
    @JsonFormat(pattern = DateUtils.DEFAULT_DATE_FORMAT)
    private Date birthday;
    /**
     * 电子邮件
     */
    @ExcelProperty(value = "电子邮件", order = 14)
    private String email;
    /**
     * 移动电话
     */
    @ExcelProperty(value = "移动电话", order = 15)
    private String mobile;
    /**
     * 座机电话
     */
    @ExcelProperty(value = "座机电话", order = 16)
    private String telephone;
    /**
     * 邮政编码
     */
    @ExcelProperty(value = "邮政编码", order = 17)
    private String postalCode;
    /**
     * 通信地址
     */
    @ExcelProperty(value = "通信地址", order = 18)
    private String mailingAddress;

    public String getCode() {
        return code;
    }

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
}
