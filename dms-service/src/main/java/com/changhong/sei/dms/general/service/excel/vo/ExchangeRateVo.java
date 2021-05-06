package com.changhong.sei.dms.general.service.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.changhong.sei.dms.common.excel.BaseExcelRow;
import com.changhong.sei.dms.common.excel.validate.NotDuplicate;
import com.changhong.sei.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 实现功能:汇率Excel导入导出模版vo
 *
 * @author 冯华
 * @create 2021-04-16 11:38
 */
public class ExchangeRateVo extends BaseExcelRow implements Serializable {
    private static final long serialVersionUID = 180242571737929170L;
    /**
     * 汇率类型
     */
    @NotBlank
    @ExcelProperty(value = "汇率类型", order = 1)
    private String rateType;
    /**
     * 生效起始日期
     */
    @NotBlank
    @DateTimeFormat(pattern = DateUtils.DEFAULT_DATE_FORMAT)
    @JsonFormat(pattern = DateUtils.DEFAULT_DATE_FORMAT)
    @ExcelProperty(value = "生效起始日期", order = 2)
    private Date startDate;
    /**
     * 货币（从）
     */
    @ExcelProperty(value = "货币（从）", order = 3)
    private String fromCurrency;
    /**
     * 货币（到）
     */
    @ExcelProperty(value = "货币（到）", order = 4)
    private String toCurrency;
    /**
     * 比率（从）
     */
    @ExcelProperty(value = "比率（从）", order = 5)
    private Integer fromUnit;
    /**
     * 比率（到）
     */
    @ExcelProperty(value = "比率（到）", order = 6)
    private Integer toUnit;
    /**
     * 汇率
     */
    @ExcelProperty(value = "汇率", order = 7)
    private Double rate;

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public Integer getFromUnit() {
        return fromUnit;
    }

    public void setFromUnit(Integer fromUnit) {
        this.fromUnit = fromUnit;
    }

    public Integer getToUnit() {
        return toUnit;
    }

    public void setToUnit(Integer toUnit) {
        this.toUnit = toUnit;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
