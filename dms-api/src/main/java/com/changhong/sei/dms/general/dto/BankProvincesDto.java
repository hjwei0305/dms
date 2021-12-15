package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.dms.annotation.MasterData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 银行省区(BankProvinces)DTO类
 *
 * @author sei
 * @since 2021-05-07 14:34:59
 */
@MasterData(code = "BankProvinces", name = "银行省区")
@ApiModel(description = "银行省区DTO")
public class BankProvincesDto extends BaseEntityDto {
    private static final long serialVersionUID = -27579069213496779L;
    /**
     * 代码
     */
    @NotBlank
    @Size(max = 3)
    @ApiModelProperty(value = "代码", required = true)
    private String code;
    /**
     * 行政区域Id
     */
    @NotBlank
    @ApiModelProperty(value = "行政区域Id", required = true)
    private String regionId;
    /**
     * (关联)行政区域代码
     */
    @ApiModelProperty(value = "(关联)行政区域代码")
    private String regionCode;
    /**
     * (关联)行政区域名称
     */
    @ApiModelProperty(value = "(关联)行政区域名称")
    private String regionName;
    /**
     * (关联)国家代码
     */
    @ApiModelProperty(value = "(关联)国家代码")
    private String countryCode;

    /**
     * (关联)国家名称
     */
    @ApiModelProperty(value = "(关联)国家名称")
    private String countryName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}