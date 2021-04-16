package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.dms.annotation.MasterData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 实现功能: 现金流代码(CashFlowCode)DTO类
 *
 * @author 冯华
 * @create 2021-04-16 10:10
 */
@MasterData(code = "cashFlowCode", name = "现金流代码")
@ApiModel(description = "现金流代码")
public class CashFlowCodeDto extends BaseEntityDto {
    private static final long serialVersionUID = 402624026080442813L;

    /**
     * 代码
     */
    @NotBlank
    @Size(max = 30)
    @ApiModelProperty(value = "代码", allowableValues = "@Size(max = 20)", required = true)
    private String code;

    /**
     * 名称
     */
    @NotBlank
    @Size(max = 200)
    @ApiModelProperty(value = "名称", allowableValues = "@Size(max = 100)", required = true)
    private String name;

    /**
     * 排序
     */
    @NotNull
    @ApiModelProperty(value = "排序", required = true)
    private Integer rank = 0;

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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
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
