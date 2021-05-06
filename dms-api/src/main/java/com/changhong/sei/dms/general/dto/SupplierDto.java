package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 供应商(Supplier)DTO类
 *
 * @author sei
 * @since 2021-05-06 14:07:48
 */
@ApiModel(description = "供应商DTO")
public class SupplierDto extends BaseEntityDto {
    private static final long serialVersionUID = 919578515133581473L;
    /**
     * 代码
     */
    @NotBlank
    @Size(max = 20)
    @ApiModelProperty(value = "代码")
    private String code;
    /**
     * 名称
     */
    @NotBlank
    @Size(max = 100)
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 账户组
     */
    @Size(max = 10)
    @ApiModelProperty(value = "账户组")
    private String accountGroup;
    /**
     * 城市
     */
    @Size(max = 50)
    @ApiModelProperty(value = "城市")
    private String city;
    /**
     * 街道
     */
    @Size(max = 200)
    @ApiModelProperty(value = "街道")
    private String street;
    /**
     * 邮编
     */
    @Size(max = 10)
    @ApiModelProperty(value = "邮编")
    private String postCode;
    /**
     * 电话
     */
    @Size(max = 20)
    @ApiModelProperty(value = "电话")
    private String telephone;
    /**
     * 纳税人识别号
     */
    @Size(max = 30)
    @ApiModelProperty(value = "纳税人识别号")
    private String taxNumber;
    /**
     * 租户代码
     */
    @ApiModelProperty(value = "租户代码")
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

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

}