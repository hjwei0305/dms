package com.changhong.sei.dms.general.service.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.changhong.sei.dms.common.excel.BaseExcelRow;
import com.changhong.sei.dms.common.excel.validate.NotDuplicate;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 实现功能:
 *
 * @author 冯华
 * @create 2021-04-20 17:01
 */
public class ImprestEmployeeVo extends BaseExcelRow implements Serializable {
    private static final long serialVersionUID = 110342571037929170L;
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
     * 名称缩写
     */
    @ExcelProperty(value = "名称缩写", order = 3)
    private String shortName;
    /**
     * 员工编号
     */
    @ExcelProperty(value = "员工编号", order = 4)
    private String personnelCode;
    /**
     * 身份证
     */
    @ExcelProperty(value = "身份证", order = 5)
    private String idCard;
    /**
     * 移动电话
     */
    @ExcelProperty(value = "移动电话", order = 6)
    private String mobile;
    /**
     * 说明
     */
    @ExcelProperty(value = "说明", order = 7)
    private String remark;

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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getPersonnelCode() {
        return personnelCode;
    }

    public void setPersonnelCode(String personnelCode) {
        this.personnelCode = personnelCode;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
