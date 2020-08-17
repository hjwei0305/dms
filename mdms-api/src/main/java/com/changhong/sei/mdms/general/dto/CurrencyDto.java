package com.changhong.sei.mdms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.mdms.annotation.MasterData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 币种(Currency)DTO类
 *
 * @author sei
 * @since 2020-08-17 14:03:22
 */
@MasterData(value = "currency")
@ApiModel(description = "币种")
public class CurrencyDto extends BaseEntityDto {
    private static final long serialVersionUID = 402624026080441813L;
    /**
     * 租户代码
     */
    @ApiModelProperty(value = "租户代码")
    private String tenantCode;
    /**
     * 代码
     */
    @ApiModelProperty(value = "代码")
    private String code;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 冻结状态
     */
    @ApiModelProperty(value = "冻结状态")
    private Double frozen;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Double rank;


    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

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

    public Double getFrozen() {
        return frozen;
    }

    public void setFrozen(Double frozen) {
        this.frozen = frozen;
    }

    public Double getRank() {
        return rank;
    }

    public void setRank(Double rank) {
        this.rank = rank;
    }

}