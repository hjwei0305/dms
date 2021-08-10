package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.core.dto.serializer.EnumJsonSerializer;
import com.changhong.sei.dms.annotation.MasterData;
import com.changhong.sei.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

/**
 * 公司员工(ERP)(Personnel)DTO类
 *
 * @author sei
 * @since 2021-04-19 10:53:32
 */
@MasterData(code = "Personnel", name = "公司员工(ERP)")
@ApiModel(description = "公司员工(ERP)DTO")
public class PersonnelDto extends BaseEntityDto {
    private static final long serialVersionUID = -89687121328610836L;
    /**
     * 员工编号
     */
    @NotBlank
    @Size(max = 10)
    @ApiModelProperty(value = "员工编号(必需，最大长度10)")
    private String code;
    /**
     * 姓名
     */
    @NotBlank
    @Size(max = 40)
    @ApiModelProperty(value = "姓名(必需，最大长度40)")
    private String name;
    /**
     * 姓名缩写
     */
    @Size(max = 40)
    @ApiModelProperty(value = "姓名缩写(最大长度40)")
    private String shortName;
    /**
     * 身份证
     */
    @NotBlank
    @Size(max = 20)
    @ApiModelProperty(value = "身份证(必需，最大长度20)")
    private String idCard;
    /**
     * ERP公司代码
     */
    @NotBlank
    @Size(max = 10)
    @ApiModelProperty(value = "ERP公司代码(必需，最大长度4)")
    private String erpCorporationCode;
    /**
     * 员工组
     */
    @Size(max = 1)
    @ApiModelProperty(value = "员工组(最大长度1)")
    private String personnelGroup;
    /**
     * 在职状态
     */
    @NotNull
    @JsonSerialize(using = EnumJsonSerializer.class)
    @ApiModelProperty(value = "在职状态(必需)")
    private WorkingStatusEnum workingStatus;
    /**
     * 在职
     */
    @ApiModelProperty(value = "在职")
    private Boolean onJob;
    /**
     * HR组织机构代码
     */
    @NotBlank
    @Size(max = 8)
    @ApiModelProperty(value = "HR组织机构代码(必需，最大长度8)")
    private String hrOrganizationCode;
    /**
     * HR组织名称名称
     */
    @Size(max = 40)
    @ApiModelProperty(value = "HR组织名称名称(最大长度40)")
    private String hrOrganizationName;
    /**
     * 成本中心代码
     */
    @Size(max = 10)
    @ApiModelProperty(value = "成本中心代码(最大长度10)")
    private String costCenterCode;
    /**
     * 性别(M:男、F:女)
     */
    @NotBlank
    @ApiModelProperty(value = "性别(必需，M:男、F:女)")
    private String gender;
    /**
     * 职位
     */
    @Size(max = 8)
    @ApiModelProperty(value = "职位(最大长度8)")
    private String post;
    /**
     * 生日
     */
    @ApiModelProperty(value = "生日")
    @DateTimeFormat(pattern = DateUtils.DEFAULT_DATE_FORMAT)
    @JsonFormat(pattern = DateUtils.DEFAULT_DATE_FORMAT)
    private Date birthday;
    /**
     * 电子邮件
     */
    @Size(max = 100)
    @ApiModelProperty(value = "电子邮件(最大长度100)")
    private String email;
    /**
     * 移动电话
     */
    @Size(max = 30)
    @ApiModelProperty(value = "移动电话(最大长度30)")
    private String mobile;
    /**
     * 座机电话
     */
    @Size(max = 30)
    @ApiModelProperty(value = "座机电话(最大长度30)")
    private String telephone;
    /**
     * 邮政编码
     */
    @Size(max = 10)
    @ApiModelProperty(value = "邮政编码(最大长度10)")
    private String postalCode;
    /**
     * 通信地址
     */
    @Size(max = 100)
    @ApiModelProperty(value = "通信地址(最大长度100)")
    private String mailingAddress;
    /**
     * 租户代码
     */
    @ApiModelProperty(value = "租户代码")
    private String tenantCode;


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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
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

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public Boolean getOnJob() {
        return Objects.equals(WorkingStatusEnum.ON_JOB, workingStatus);
    }
}