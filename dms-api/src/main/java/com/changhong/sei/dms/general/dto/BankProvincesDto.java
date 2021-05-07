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
    @ApiModelProperty(value = "代码")
    private String code;
    /**
     * 行政区域代码
     */
    @Size(max = 20)
    @ApiModelProperty(value = "行政区域代码")
    private String regionCode;
    /**
     * 名称
     */
    @NotBlank
    @Size(max = 20)
    @ApiModelProperty(value = "名称")
    private String name;

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

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }
}