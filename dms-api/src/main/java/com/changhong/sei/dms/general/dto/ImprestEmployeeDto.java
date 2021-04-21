package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.dms.annotation.MasterData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 备用金员工(ERP)(ImprestEmployee)DTO类
 *
 * @author sei
 * @since 2021-04-20 16:41:12
 */
@MasterData(code = "ImprestEmployee", name = "备用金员工")
@ApiModel(description = "备用金员工(ERP)DTO")
public class ImprestEmployeeDto extends BaseEntityDto {
    private static final long serialVersionUID = 187126013380876313L;
    /**
     * 代码
     */
    @NotBlank
    @Size(max = 20)
    @ApiModelProperty(value = "代码")
    private String code;
    /**
     * 名称
     */
    @NotBlank
    @Size(max = 100)
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 名称缩写
     */
    @Size(max = 40)
    @ApiModelProperty(value = "名称缩写")
    private String shortName;
    /**
     * 员工编号
     */
    @Size(max = 10)
    @ApiModelProperty(value = "员工编号")
    private String personnelCode;
    /**
     * 身份证
     */
    @Size(max = 20)
    @ApiModelProperty(value = "身份证")
    private String idCard;
    /**
     * 移动电话
     */
    @Size(max = 30)
    @ApiModelProperty(value = "移动电话")
    private String mobile;
    /**
     * 说明
     */
    @Size(max = 200)
    @ApiModelProperty(value = "说明")
    private String remark;
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

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

}