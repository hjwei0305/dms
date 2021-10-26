package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.dms.annotation.MasterData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 银行(Bank)DTO类
 *
 * @author sei
 * @since 2021-06-25 11:10:10
 */
@MasterData(code = "Bank", name = "银行")
@ApiModel(description = "银行DTO")
public class BankDto extends BaseEntityDto {
    private static final long serialVersionUID = 295118302733741054L;
    /**
     * 银行行号
     */
    @ApiModelProperty(value = "银行行号", required = true)
    @NotBlank
    @Size(max = 15)
    private String code;
    /**
     * 银行行名
     */
    @ApiModelProperty(value = "银行行名", required = true)
    @NotBlank
    @Size(max = 120)
    private String name;
    /**
     * 银行行别Id
     */
    @ApiModelProperty(value = "银行行别Id", required = true)
    @NotBlank
    private String bankCategoryId;
    /**
     * 关联银行行别代码
     */
    @ApiModelProperty(value = "关联银行行别代码")
    private String bankCategoryCode;
    /**
     * 关联银行行别名称
     */
    @ApiModelProperty(value = "关联银行行别名称")
    private String bankCategoryName;
    /**
     * 银行地区Id
     */
    @ApiModelProperty(value = "银行地区Id")
    private String bankAreaId;
    /**
     * 关联国家代码
     */
    @ApiModelProperty(value = "关联国家代码")
    private String countryCode;
    /**
     * 关联国家名称
     */
    @ApiModelProperty(value = "关联国家名称")
    private String countryName;
    /**
     * 关联银行省区代码
     */
    @ApiModelProperty(value = "关联银行省区代码")
    private String bankProvinceCode;
    /**
     * 关联银行省区名称
     */
    @ApiModelProperty(value = "关联银行省区名称")
    private String bankProvinceName;
    /**
     * 关联银行城市代码
     */
    @ApiModelProperty(value = "关联银行城市代码")
    private String bankCityCode;
    /**
     * 关联银行城市名称
     */
    @ApiModelProperty(value = "关联银行城市名称")
    private String bankCityName;
    /**
     * 关联银行地区代码
     */
    @ApiModelProperty(value = "关联银行地区代码")
    private String bankAreaCode;
    /**
     * 关联银行地区名称
     */
    @ApiModelProperty(value = "关联银行地区名称")
    private String bankAreaName;
    /**
     * 关联银行省区代码(行政)
     */
    @ApiModelProperty(value = "关联银行省区代码(行政)")
    private String regionProvinceCode;
    /**
     * 关联银行城市代码(行政)
     */
    @ApiModelProperty(value = "关联银行城市代码(行政)")
    private String regionCityCode;
    /**
     * 关联银行地区代码(行政)
     */
    @ApiModelProperty(value = "关联银行地区代码(行政)")
    private String regionAreaCode;
    /**
     * ERP银行代码
     */
    @ApiModelProperty(value = "ERP银行代码")
    private String erpBankCode;
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
    /**
     * 已冻结
     */
    @ApiModelProperty(value = "已冻结")
    private Boolean frozen;


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

    public String getBankCategoryId() {
        return bankCategoryId;
    }

    public void setBankCategoryId(String bankCategoryId) {
        this.bankCategoryId = bankCategoryId;
    }

    public String getBankCategoryCode() {
        return bankCategoryCode;
    }

    public void setBankCategoryCode(String bankCategoryCode) {
        this.bankCategoryCode = bankCategoryCode;
    }

    public String getBankCategoryName() {
        return bankCategoryName;
    }

    public void setBankCategoryName(String bankCategoryName) {
        this.bankCategoryName = bankCategoryName;
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

    public String getBankCityCode() {
        return bankCityCode;
    }

    public void setBankCityCode(String bankCityCode) {
        this.bankCityCode = bankCityCode;
    }

    public String getBankCityName() {
        return bankCityName;
    }

    public void setBankCityName(String bankCityName) {
        this.bankCityName = bankCityName;
    }

    public String getBankAreaCode() {
        return bankAreaCode;
    }

    public void setBankAreaCode(String bankAreaCode) {
        this.bankAreaCode = bankAreaCode;
    }

    public String getBankAreaName() {
        return bankAreaName;
    }

    public void setBankAreaName(String bankAreaName) {
        this.bankAreaName = bankAreaName;
    }

    public String getBankAreaId() {
        return bankAreaId;
    }

    public void setBankAreaId(String bankAreaId) {
        this.bankAreaId = bankAreaId;
    }

    public String getErpBankCode() {
        return erpBankCode;
    }

    public void setErpBankCode(String erpBankCode) {
        this.erpBankCode = erpBankCode;
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

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    public String getRegionProvinceCode() {
        return regionProvinceCode;
    }

    public void setRegionProvinceCode(String regionProvinceCode) {
        this.regionProvinceCode = regionProvinceCode;
    }

    public String getRegionCityCode() {
        return regionCityCode;
    }

    public void setRegionCityCode(String regionCityCode) {
        this.regionCityCode = regionCityCode;
    }

    public String getRegionAreaCode() {
        return regionAreaCode;
    }

    public void setRegionAreaCode(String regionAreaCode) {
        this.regionAreaCode = regionAreaCode;
    }
}