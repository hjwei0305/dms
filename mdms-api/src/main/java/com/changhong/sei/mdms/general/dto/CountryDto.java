package com.changhong.sei.mdms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.mdms.annotation.MasterData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 国家(Country)DTO类
 *
 * @author sei
 * @since 2020-08-17 14:03:16
 */
@MasterData
@ApiModel(description = "国家")
public class CountryDto extends BaseEntityDto {
    private static final long serialVersionUID = 202368163739510191L;
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
     * 国家货币代码
     */
    @ApiModelProperty(value = "国家货币代码")
    private String currencyCode;
    /**
     * 国家货币名称
     */
    @ApiModelProperty(value = "国家货币名称")
    private String currencyName;
    /**
     * 是否国外
     */
    @ApiModelProperty(value = "是否国外")
    private Boolean toForeign;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer rank;
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

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public Boolean getToForeign() {
        return toForeign;
    }

    public void setToForeign(Boolean toForeign) {
        this.toForeign = toForeign;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

}