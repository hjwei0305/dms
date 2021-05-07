package com.changhong.sei.dms.general.service.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.changhong.sei.dms.common.excel.BaseExcelRow;
import com.changhong.sei.dms.common.excel.validate.NotDuplicate;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 实现功能:银行类别(BankCategory)Excel导入导出模版vo
 *
 * @author 冯华
 * @create 2021-04-16 11:38
 */
public class BankCategoryVo extends BaseExcelRow implements Serializable {
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
     * 简码
     */
    @ExcelProperty(value = "简码", order = 3)
    private String shortCode;
    /**
     * 简称
     */
    @ExcelProperty(value = "简称", order = 4)
    private String shortName;
    /**
     * 已冻结
     */
    @ExcelProperty(value = "已冻结", order = 5)
    private Boolean frozen = Boolean.FALSE;
    /**
     * 排序
     */
    @ExcelProperty(value = "排序", order = 6)
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

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
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
