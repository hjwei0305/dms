package com.changhong.sei.dms.general.service.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.changhong.sei.dms.common.excel.BaseExcelRow;
import com.changhong.sei.dms.common.excel.validate.NotDuplicate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 税率(TaxRate)Excel导入导出模版vo
 *
 * @author sei
 * @since 2020-08-17 14:02:39
 */
public class TaxRateVo extends BaseExcelRow implements Serializable {
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
     * 税率
     */
    @ExcelProperty(value = "税率", order = 3)
    private Double taxRate;

    /**
     * 冻结
     */
    @ExcelProperty(value = "冻结", order = 4)
    private Boolean frozen = Boolean.FALSE;

    /**
     * 租户代码
     */
    @ExcelProperty(value = "租户代码", order = 5)
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

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }
}