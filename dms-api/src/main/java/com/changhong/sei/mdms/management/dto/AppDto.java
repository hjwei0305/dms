package com.changhong.sei.mdms.management.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * 应用服务(App)DTO类
 *
 * @author sei
 * @since 2020-08-13 22:47:19
 */
@ApiModel(description = "应用服务dto")
public class AppDto extends BaseEntityDto {
    private static final long serialVersionUID = 835886251258143397L;
    /**
     * 代码
     */
    @NotBlank
    @ApiModelProperty(value = "应用服务代码")
    private String code;
    /**
     * 名称
     */
    @NotBlank
    @ApiModelProperty(value = "应用服务名称")
    private String name;

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

}