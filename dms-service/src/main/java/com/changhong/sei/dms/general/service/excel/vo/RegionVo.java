package com.changhong.sei.dms.general.service.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.changhong.sei.dms.common.excel.BaseExcelRow;
import com.changhong.sei.dms.common.excel.validate.NotDuplicate;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 行政区域(Region)Excel导入导出模版vo
 *
 * @author sei
 * @since 2020-08-17 14:02:39
 */
public class RegionVo extends BaseExcelRow implements Serializable {
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
     * 父节点code
     */
    @ExcelProperty(value = "父节点代码", order = 3)
    private String parentCode;

    /**
     * 国家Id
     */
    @ExcelProperty(value = "国家代码", order = 4)
    private String countryCode;

    /**
     * 排序
     */
    @ExcelProperty(value = "排序", order = 5)
    private Integer rank;


    /**
     * 缩写
     */
    @ExcelProperty(value = "缩写", order = 6)
    private String shortName;

    /**
     * 拼音
     */
    @ExcelProperty(value = "拼音", order = 7)
    private String pinYin;

    /**
     * 商旅城市代码
     */
    @ExcelProperty(value = "商旅城市代码", order = 8)
    private String travelCityCode;

    /**
     * 商旅城市名称
     */
    @ExcelProperty(value = "商旅城市名称", order = 9)
    private String travelCityName;

    /**
     * 租户代码
     */
    @ExcelProperty(value = "租户代码", order = 10)
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

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin;
    }

    public String getTravelCityCode() {
        return travelCityCode;
    }

    public void setTravelCityCode(String travelCityCode) {
        this.travelCityCode = travelCityCode;
    }

    public String getTravelCityName() {
        return travelCityName;
    }

    public void setTravelCityName(String travelCityName) {
        this.travelCityName = travelCityName;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }
}