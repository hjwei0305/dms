package com.changhong.sei.dms.general.service.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.changhong.sei.dms.common.excel.BaseExcelRow;
import com.changhong.sei.dms.common.excel.validate.NotDuplicate;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 实现功能:
 *
 * @author 冯华
 * @create 2021-04-16 14:41
 */
public class InnerOrderVo extends BaseExcelRow implements Serializable {
    private static final long serialVersionUID = 110242571037929170L;
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
     * ERP公司代码
     */
    @NotBlank
    @ExcelProperty(value = "ERP公司代码", order = 3)
    private String erpCorporationCode;
    /**
     * 订单类型
     */
    @NotBlank
    @ExcelProperty(value = "订单类型",order  =4)
    private String orderType;

    /**
     * 货币代码
     */
    @NotBlank
    @ExcelProperty(value = "货币代码", order = 5)
    private String currency;
    /**
     * 业务范围
     */
    @ExcelProperty(value = "业务范围", order = 7)
    private String costRange;
    /**
     * 负责人
     */
    @ExcelProperty(value = "负责人", order = 8)
    private String keyPerson;
    /**
     * 成本中心代码
     */
    @ExcelProperty(value = "成本中心代码", order = 9)
    private String costCenterCode;
    /**
     * 已冻结
     */
    @ExcelProperty(value = "已冻结", order = 11)
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

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public String getCostCenterCode() {
        return costCenterCode;
    }

    public void setCostCenterCode(String costCenterCode) {
        this.costCenterCode = costCenterCode;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }
}
