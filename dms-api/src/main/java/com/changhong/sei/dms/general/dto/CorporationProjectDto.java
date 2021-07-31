package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.dms.annotation.MasterData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 公司项目(CorporationProject)DTO类
 *
 * @author sei
 * @since 2021-07-31 16:02:20
 */
@MasterData(code = "CorporationProject", name = "公司项目")
@ApiModel(description = "公司项目DTO")
public class CorporationProjectDto extends BaseEntityDto {
    private static final long serialVersionUID = -59692976042104106L;
    /**
     * 名称
     */
    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(value = "名称", required = true)
    private String name;
    /**
     * ERP公司代码
     */
    @NotBlank
    @Size(max = 10)
    @ApiModelProperty(value = "ERP公司代码", required = true)
    private String erpCorporationCode;
    /**
     * WBS项目编号
     */
    @Size(max = 30)
    @ApiModelProperty(value = "WBS项目编号", notes = "WBS项目编号与内部订单编号两者必填一个")
    private String wbsProjectCode;
    /**
     * WBS项目名称
     */
    @Size(max = 50)
    @ApiModelProperty(value = "WBS项目名称")
    private String wbsProjectName;
    /**
     * 内部订单编号
     */
    @Size(max = 20)
    @ApiModelProperty(value = "内部订单编号", notes = "WBS项目编号与内部订单编号两者必填一个")
    private String innerOrderCode;
    /**
     * 内部订单名称
     */
    @Size(max = 50)
    @ApiModelProperty(value = "内部订单名称")
    private String innerOrderName;
    /**
     * 冻结标识
     */
    @ApiModelProperty(value = "冻结标识")
    private Boolean frozen = Boolean.FALSE;
    /**
     * 租户代码
     */
    @ApiModelProperty(value = "租户代码")
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

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

}