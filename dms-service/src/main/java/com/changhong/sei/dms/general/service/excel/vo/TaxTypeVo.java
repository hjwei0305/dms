package com.changhong.sei.dms.general.service.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.changhong.sei.dms.common.excel.BaseExcelRow;
import com.changhong.sei.dms.common.excel.validate.NotDuplicate;
import com.changhong.sei.dms.general.dto.TaxCategory;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 实现功能: 税类型(TaxType)Excel导入导出模板vo
 *
 * @author 杨沄炜
 * @date 2021/06/24 9:31
 */
public class TaxTypeVo extends BaseExcelRow {
    private static final long serialVersionUID = -8114929321586820297L;

    /**
     * 税码
     */
    @NotDuplicate
    @NotBlank
    @ExcelProperty(value = "税码", order = 1)
    private String code;

    /**
     * 名称
     */
    @NotBlank
    @ExcelProperty(value = "名称", order = 2)
    private String name;

    /**
     * 税分类
     */
    @NotNull
    @ExcelProperty(value = "税分类", order = 3)
    private TaxCategory taxCategory = TaxCategory.OUTPUT;

    /**
     * 税率
     */
    @NotNull
    @ExcelProperty(value = "税率", order = 4)
    private BigDecimal taxRate = BigDecimal.ZERO;

    /**
     * 排序
     */
    @NotNull
    @ExcelProperty(value = "排序", order = 5)
    private Integer rank = 0;

    /**
     * 总账科目代码
     */
    @ExcelProperty(value = "总账科目代码", order = 6)
    private String ledgerAccountCode;

    /**
     * 总账科目名称
     */
    @ExcelProperty(value = "总账科目名称", order = 7)
    private String ledgerAccountName;

    /**
     * 租户代码
     */
    @NotBlank
    @NotDuplicate
    @ExcelProperty(value = "租户代码", order = 8)
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

    public TaxCategory getTaxCategory() {
        return taxCategory;
    }

    public void setTaxCategory(TaxCategory taxCategory) {
        this.taxCategory = taxCategory;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getLedgerAccountCode() {
        return ledgerAccountCode;
    }

    public void setLedgerAccountCode(String ledgerAccountCode) {
        this.ledgerAccountCode = ledgerAccountCode;
    }

    public String getLedgerAccountName() {
        return ledgerAccountName;
    }

    public void setLedgerAccountName(String ledgerAccountName) {
        this.ledgerAccountName = ledgerAccountName;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }
}
