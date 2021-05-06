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
public class SupplierVo extends BaseExcelRow implements Serializable {
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
     * 账户组
     */
    @ExcelProperty(value = "账户组", order = 3)
    private String accountGroup;
    /**
     * 城市
     */
    @ExcelProperty(value = "城市", order = 4)
    private String city;
    /**
     * 街道
     */
    @ExcelProperty(value = "街道", order = 5)
    private String street;
    /**
     * 邮编
     */
    @ExcelProperty(value = "邮编", order = 6)
    private String postCode;
    /**
     * 电话
     */
    @ExcelProperty(value = "电话", order = 7)
    private String telephone;
    /**
     * 纳税人识别号
     */
    @ExcelProperty(value = "纳税人识别号", order = 8)
    private String taxNumber;


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

    public String getAccountGroup() {
        return accountGroup;
    }

    public void setAccountGroup(String accountGroup) {
        this.accountGroup = accountGroup;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

}
