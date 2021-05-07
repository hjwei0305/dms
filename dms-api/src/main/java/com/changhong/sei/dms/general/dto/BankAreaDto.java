package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.dms.annotation.MasterData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 银行地区(BankArea)DTO类
 *
 * @author sei
 * @since 2021-05-07 15:55:29
 */
@MasterData(code = "BankArea", name = "银行地区")
@ApiModel(description = "银行地区DTO")
public class BankAreaDto extends BaseEntityDto {
    private static final long serialVersionUID = -13214805485278715L;
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
     * 银行城市Id
     */
    @ApiModelProperty(value = "银行城市Id")
    private String bankCityId;
    /**
     * 银行城市
     */
    @ApiModelProperty(value = "银行城市")
    private BankCityDto bankCity;
    /**
     * 级别代码
     */
    @ApiModelProperty(value = "级别代码")
    private Integer levelCode;
    /**
     * 级别名称
     */
    @ApiModelProperty(value = "级别名称")
    private String levelName;
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

    public String getBankCityId() {
        return bankCityId;
    }

    public void setBankCityId(String bankCityId) {
        this.bankCityId = bankCityId;
    }

    public BankCityDto getBankCity() {
        return bankCity;
    }

    public void setBankCity(BankCityDto bankCity) {
        this.bankCity = bankCity;
    }

    public Integer getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(Integer levelCode) {
        this.levelCode = levelCode;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
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