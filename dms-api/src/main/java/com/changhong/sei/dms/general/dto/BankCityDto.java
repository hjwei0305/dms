package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.dms.annotation.MasterData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 银行城市(BankCity)DTO类
 *
 * @author sei
 * @since 2021-05-07 15:13:25
 */
@MasterData(code = "BankCity", name = "银行城市")
@ApiModel(description = "银行城市DTO")
public class BankCityDto extends BaseEntityDto {
    private static final long serialVersionUID = -94964024585132997L;
    /**
     * 代码
     */
    @NotBlank
    @Size(max = 10)
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
     * 银行省区Id
     */
    @NotBlank
    @ApiModelProperty(value = "银行省区Id")
    private String bankProvinceId;

    /**
     * 银行省区代码
     */
    @ApiModelProperty(value = "银行省区代码")
    private String bankProvinceCode;

    /**
     * 银行省区名称
     */
    @ApiModelProperty(value = "银行省区名称")
    private String bankProvinceName;
    /**
     * 已冻结
     */
    @ApiModelProperty(value = "已冻结")
    private Boolean frozen = Boolean.FALSE;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer rank = 0;
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

    public String getBankProvinceId() {
        return bankProvinceId;
    }

    public void setBankProvinceId(String bankProvinceId) {
        this.bankProvinceId = bankProvinceId;
    }

    public String getBankProvinceCode() {
        return bankProvinceCode;
    }

    public void setBankProvinceCode(String bankProvinceCode) {
        this.bankProvinceCode = bankProvinceCode;
    }

    public String getBankProvinceName() {
        return bankProvinceName;
    }

    public void setBankProvinceName(String bankProvinceName) {
        this.bankProvinceName = bankProvinceName;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
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