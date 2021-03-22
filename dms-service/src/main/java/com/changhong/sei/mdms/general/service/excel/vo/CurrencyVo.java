package com.changhong.sei.mdms.general.service.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.changhong.sei.mdms.common.excel.BaseExcelRow;
import com.changhong.sei.mdms.common.excel.validate.NotDuplicate;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 币种(Currency)Excel导入导出模版vo
 *
 * @author sei
 * @since 2020-08-17 14:02:39
 */
public class CurrencyVo extends BaseExcelRow implements Serializable {
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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}