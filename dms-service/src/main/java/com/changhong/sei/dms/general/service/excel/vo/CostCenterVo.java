package com.changhong.sei.dms.general.service.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.changhong.sei.dms.common.excel.BaseExcelRow;
import com.changhong.sei.dms.common.excel.validate.NotDuplicate;
import com.changhong.sei.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 实现功能:成本中心Excel导入导出模版vo
 *
 * @author 冯华
 * @create 2021-04-16 11:43
 */
public class CostCenterVo extends BaseExcelRow implements Serializable {
    private static final long serialVersionUID = 180242571037929170L;
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
     * 公司代码
     */
    @NotBlank
    @ExcelProperty(value = "ERP公司代码", order = 3)
    private String erpCorporationCode;
    /**
     * 分类码
     */
    @NotBlank
    @ExcelProperty(value = "分类码", order = 4)
    private String categoryCode;
    /**
     * 货币代码
     */
    @NotBlank
    @ExcelProperty(value = "货币代码", order = 5)
    private String currencyCode;
    /**
     * 起始日期
     */
    @NotNull
    @DateTimeFormat(pattern = DateUtils.DEFAULT_DATE_FORMAT)
    @JsonFormat(pattern = DateUtils.DEFAULT_DATE_FORMAT)
    @ExcelProperty(value = "起始日期(yyyy-MM-dd)", order = 6)
    private Date startDate;
    /**
     * 截止日期
     */
    @NotNull
    @DateTimeFormat(pattern = DateUtils.DEFAULT_DATE_FORMAT)
    @JsonFormat(pattern = DateUtils.DEFAULT_DATE_FORMAT)
    @ExcelProperty(value = "截止日期(yyyy-MM-dd)", order = 7)
    private Date endDate;
    /**
     * 业务范围
     */
    @ExcelProperty(value = "业务范围", order = 8)
    private String costRange;
    /**
     * 负责人
     */
    @ExcelProperty(value = "负责人", order = 9)
    private String keyPerson;
    /**
     * 利润中心代码
     */
    @ExcelProperty(value = "利润中心代码", order = 10)
    private String profitCenterCode;
    /**
     * 功能范围
     */
    @ExcelProperty(value = "功能范围", order = 11)
    private String featureRange;
    /**
     * 已冻结
     */
    @ExcelProperty(value = "已冻结", order = 12)
    private Boolean frozen = Boolean.FALSE;

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

    public String getErpCorporationCode() {
        return erpCorporationCode;
    }

    public void setErpCorporationCode(String erpCorporationCode) {
        this.erpCorporationCode = erpCorporationCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCostRange() {
        return costRange;
    }

    public void setCostRange(String costRange) {
        this.costRange = costRange;
    }

    public String getKeyPerson() {
        return keyPerson;
    }

    public void setKeyPerson(String keyPerson) {
        this.keyPerson = keyPerson;
    }

    public String getProfitCenterCode() {
        return profitCenterCode;
    }

    public void setProfitCenterCode(String profitCenterCode) {
        this.profitCenterCode = profitCenterCode;
    }

    public String getFeatureRange() {
        return featureRange;
    }

    public void setFeatureRange(String featureRange) {
        this.featureRange = featureRange;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }
}
