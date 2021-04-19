package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.dms.annotation.MasterData;
import com.changhong.sei.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * HR组织机构(ERP)(HrOrganization)DTO类
 *
 * @author sei
 * @since 2021-04-19 14:59:25
 */
@MasterData(code = "HrOrganization", name = "HR组织机构")
@ApiModel(description = "HR组织机构DTO")
public class HrOrganizationDto extends BaseEntityDto {
    private static final long serialVersionUID = -98413581382520252L;
    /**
     * 代码
     */
    @NotBlank
    @Size(max = 8)
    @ApiModelProperty(value = "代码(必需，最大长度8)")
    private String code;
    /**
     * 名称
     */
    @NotBlank
    @Size(max = 40)
    @ApiModelProperty(value = "名称(必需，最大长度40)")
    private String name;
    /**
     * 父节点代码
     */
    @Size(max = 8)
    @ApiModelProperty(value = "父节点代码(最大长度8)")
    private String parentCode;
    /**
     * 成本中心代码
     */
    @Size(max = 10)
    @ApiModelProperty(value = "成本中心代码((最大长度10)")
    private String costCenterCode;
    /**
     * 起始日期
     */
    @DateTimeFormat(pattern = DateUtils.DEFAULT_DATE_FORMAT)
    @JsonFormat(pattern = DateUtils.DEFAULT_DATE_FORMAT)
    @ApiModelProperty(value = "起始日期")
    private Date startDate;
    /**
     * 截止日期
     */
    @DateTimeFormat(pattern = DateUtils.DEFAULT_DATE_FORMAT)
    @JsonFormat(pattern = DateUtils.DEFAULT_DATE_FORMAT)
    @ApiModelProperty(value = "截止日期")
    private Date endDate;
    /**
     * 组织机构Id
     */
    @ApiModelProperty(value = "组织机构Id")
    private String organizationId;
    /**
     * 已冻结
     */
    @NotNull
    @ApiModelProperty(value = "已冻结", required = true)
    private Boolean frozen = Boolean.FALSE;
    /**
     * 租户代码
     */
    @ApiModelProperty(value = "租户代码")
    private String tenantCode;

    /**
     * 子节点列表
     */
    @ApiModelProperty(value = "子节点列表")
    private List<HrOrganizationDto> children;


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

    public List<HrOrganizationDto> getChildren() {
        return children;
    }

    public void setChildren(List<HrOrganizationDto> children) {
        this.children = children;
    }
}