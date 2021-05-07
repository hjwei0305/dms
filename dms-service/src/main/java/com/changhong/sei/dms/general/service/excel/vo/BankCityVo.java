package com.changhong.sei.dms.general.service.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.changhong.sei.dms.common.excel.BaseExcelRow;
import com.changhong.sei.dms.common.excel.validate.NotDuplicate;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 实现功能:银行城市(BankCity)Excel导入导出模版vo
 *
 * @author 冯华
 * @create 2021-04-16 11:38
 */
public class BankCityVo extends BaseExcelRow implements Serializable {
    private static final long serialVersionUID = 180242571737329170L;
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
     * 行政区域代码
     */
    @ExcelProperty(value = "行政区域代码", order = 3)
    private String regionCode;
    /**
     * 银行省区代码
     */
    @ExcelProperty(value = "银行省区代码", order = 4)
    private String bankProvinceCode;
    /**
     * 银行省区名称
     */
    @ExcelProperty(value = "银行省区名称", order = 5)
    private String bankProvinceName;
    /**
     * 已冻结
     */
    @ExcelProperty(value = "已冻结", order = 6)
    private Boolean frozen = Boolean.FALSE;
    /**
     * 排序
     */
    @ExcelProperty(value = "排序", order = 7)
    private Integer rank = 0;

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

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
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
}
