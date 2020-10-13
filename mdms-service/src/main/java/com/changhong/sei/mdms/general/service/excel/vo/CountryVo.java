package com.changhong.sei.mdms.general.service.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.changhong.sei.mdms.common.excel.BaseExcelRow;
import com.changhong.sei.mdms.common.excel.validate.NotDuplicate;
import com.changhong.sei.mdms.general.entity.Country;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 国家(Country)Excel导入导出模版vo
 *
 * @author sei
 * @since 2020-08-17 14:02:39
 */
public class CountryVo extends BaseExcelRow implements Serializable {
    private static final long serialVersionUID = 180242575737929170L;
    /**
     * 代码
     */
    @NotDuplicate
    @NotBlank
    @ExcelProperty(value = "代码", order = 1)
    private String code;
    /**
     * 名称
     */
    @NotBlank
    @ExcelProperty(value = "名称", order = 2)
    private String name;
    /**
     * 国家货币代码
     */
    @NotBlank
    @ExcelProperty(value = "国家货币代码", order = 3)
    private String currencyCode;
    /**
     * 国家货币名称
     */
    @NotBlank
    @ExcelProperty(value = "国家货币名称", order = 4)
    private String currencyName;
    /**
     * 是否国外
     */
    @ExcelProperty(value = "是否国外", order = 5)
    private Boolean toForeign = Boolean.FALSE;
    /**
     * 排序
     */
    @ExcelProperty(value = "排序", order = 6)
    private Integer rank = 0;
    /**
     * 租户代码
     */
    @NotBlank
    @ExcelProperty(value = "租户代码", order = 7)
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