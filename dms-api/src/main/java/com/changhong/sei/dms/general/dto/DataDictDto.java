package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 实现功能: 数据字典DTO
 *
 * @author 王锦光 wangjg
 * @version 2020-01-26 19:46
 */
@ApiModel(description = "数据字典DTO")
public class DataDictDto extends BaseEntityDto {
    /**
     * 代码
     */
    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(value = "代码(max = 50)", required = true)
    private String code;

    /**
     * 名称
     */
    @NotBlank
    @Size(max = 100)
    @ApiModelProperty(value = "名称(max = 100)", required = true)
    private String name;

    /**
     * 是否冻结
     */
    @NotNull
    @ApiModelProperty(value = "是否冻结", required = true)
    private Boolean tenantPrivate = Boolean.FALSE;

    /**
     * 租户私有
     */
    @NotNull
    @ApiModelProperty(value = "租户私有", required = true)
    private Boolean frozen = Boolean.FALSE;

    /**
     * 备注
     */
    @Size(max = 100)
    @ApiModelProperty(value = "备注(max = 100)")
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

    public Boolean getTenantPrivate() {
        return tenantPrivate;
    }

    public void setTenantPrivate(Boolean tenantPrivate) {
        this.tenantPrivate = tenantPrivate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
