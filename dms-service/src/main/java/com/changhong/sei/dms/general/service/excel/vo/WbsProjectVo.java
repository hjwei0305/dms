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
 * 实现功能:WBS项目(WbsProject)导入导出服务
 *
 * @author 冯华
 * @create 2021-04-19 17:29
 */
public class WbsProjectVo extends BaseExcelRow implements Serializable {
    private static final long serialVersionUID = 180242521027929170L;

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
     * 父节点代码
     */
    @ExcelProperty(value = "父节点代码", order = 3)
    private String parentCode;
    /**
     * 项目类型
     */
    @NotBlank
    @ExcelProperty(value = "项目类型", order = 4)
    private String projectType;
    /**
     * ERP公司代码
     */
    @NotBlank
    @ExcelProperty(value = "ERP公司代码", order = 5)
    private String erpCorporationCode;
    /**
     * 层级
     */
    @NotNull
    @ExcelProperty(value = "层级", order = 6)
    private Integer nodeLevel;
    /**
     * 成本中心代码
     */
    @ExcelProperty(value = "成本中心代码", order = 7)
    private String costCenterCode;
    /**
     * 业务范围代码
     */
    @ExcelProperty(value = "业务范围代码", order = 8)
    private String rangeCode;
    /**
     * ERP创建日期
     */
    @DateTimeFormat(pattern = DateUtils.DEFAULT_TIME_FORMAT)
    @JsonFormat(pattern = DateUtils.DEFAULT_TIME_FORMAT)
    @ExcelProperty(value = "ERP创建日期", order = 9)
    private Date erpCreateDate;
    /**
     * 总账科目代码
     */
    @ExcelProperty(value = "总账科目代码", order = 10)
    private String ledgerAccountCode;
    /**
     * 总账科目名称
     */
    @ExcelProperty(value = "总账科目名称", order = 11)
    private String ledgerAccountName;
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

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getErpCorporationCode() {
        return erpCorporationCode;
    }

    public void setErpCorporationCode(String erpCorporationCode) {
        this.erpCorporationCode = erpCorporationCode;
    }

    public Integer getNodeLevel() {
        return nodeLevel;
    }

    public void setNodeLevel(Integer nodeLevel) {
        this.nodeLevel = nodeLevel;
    }

    public String getCostCenterCode() {
        return costCenterCode;
    }

    public void setCostCenterCode(String costCenterCode) {
        this.costCenterCode = costCenterCode;
    }

    public String getRangeCode() {
        return rangeCode;
    }

    public void setRangeCode(String rangeCode) {
        this.rangeCode = rangeCode;
    }

    public Date getErpCreateDate() {
        return erpCreateDate;
    }

    public void setErpCreateDate(Date erpCreateDate) {
        this.erpCreateDate = erpCreateDate;
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

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }
}
