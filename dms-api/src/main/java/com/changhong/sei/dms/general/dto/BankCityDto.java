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
    @ApiModelProperty(value = "代码", required = true)
    private String code;
    /**
     * 银行省区Id
     */
    @NotBlank
    @ApiModelProperty(value = "银行省区Id", required = true)
    private String bankProvinceId;
    /**
     * 关联银行省区代码
     */
    @ApiModelProperty(value = "(关联)银行省区代码")
    private String bankProvinceCode;
    /**
     * 关联银行省区名称
     */
    @ApiModelProperty(value = "(关联)银行省区名称")
    private String bankProvinceName;
    /**
     * 行政区域Id
     */
    @NotBlank
    @ApiModelProperty(value = "行政区域Id", required = true)
    private String regionId;
    /**
     * 关联行政区域代码
     */
    @ApiModelProperty(value = "(关联)行政区域代码")
    private String regionCode;
    /**
     * 关联行政区域名称
     */
    @ApiModelProperty(value = "(关联)行政区域名称")
    private String regionName;
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

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getBankProvinceId() {
        return bankProvinceId;
    }

    public void setBankProvinceId(String bankProvinceId) {
        this.bankProvinceId = bankProvinceId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
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
}