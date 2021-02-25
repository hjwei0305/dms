package com.changhong.sei.mdms.management.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * 应用数据订阅管理(Subscription)DTO类
 *
 * @author sei
 * @since 2020-08-13 22:47:19
 */
@ApiModel(description = "应用数据订阅管理dto")
public class SubscriptionDto extends BaseEntityDto {
    private static final long serialVersionUID = 835886251258143397L;
    /**
     * 应用服务代码
     */
    @NotBlank
    @ApiModelProperty(value = "应用服务代码")
    private String appCode;
    /**
     * 应用服务名称
     */
    @ApiModelProperty(value = "应用服务名称")
    private String appName;
    /**
     * 数据代码
     */
    @NotBlank
    @ApiModelProperty(value = "数据代码")
    private String dataCode;
    /**
     * 数据名称
     */
    @ApiModelProperty(value = "数据名称")
    private String dataName;
    /**
     * 冻结
     * 取消注册即冻结
     */
    @ApiModelProperty(value = "冻结, 取消注册即冻结")
    private Boolean frozen = Boolean.FALSE;
    /**
     * 描述说明
     */
    @ApiModelProperty(value = "描述说明")
    private String remark;
    /**
     * 拥有者名称
     */
    @NotBlank
    @ApiModelProperty(value = "描述说明")
    private String ownerName;
    /**
     * 拥有者邮箱
     */
    @NotBlank
    @ApiModelProperty(value = "描述说明")
    private String ownerEmail;

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getDataCode() {
        return dataCode;
    }

    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }
}