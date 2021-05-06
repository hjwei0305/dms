package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.dms.annotation.MasterData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 客户(Customer)DTO类
 *
 * @author sei
 * @since 2021-05-06 13:05:40
 */
@MasterData(code = "Customer", name = "客户")
@ApiModel(description = "客户DTO")
public class CustomerDto extends BaseEntityDto {
    private static final long serialVersionUID = -42721049848803105L;
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
    @Size(max = 20)
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
     * 单位地址
     */
    @Size(max = 200)
    @ApiModelProperty(value = "单位地址")
    private String address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

}