package com.changhong.sei.dms.general.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.ICodeUnique;
import com.changhong.sei.core.entity.ITenant;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 供应商(Supplier)实体类
 *
 * @author sei
 * @since 2021-05-06 14:07:29
 */
@Entity
@Table(name = "supplier")
@DynamicInsert
@DynamicUpdate
public class Supplier extends BaseAuditableEntity implements Serializable, ICodeUnique, ITenant {
    private static final long serialVersionUID = 957616246150462844L;
    /**
     * 代码
     */
    @Column(name = "code")
    private String code;
    /**
     * 名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 账户组
     */
    @Column(name = "account_group")
    private String accountGroup;
    /**
     * 城市
     */
    @Column(name = "city")
    private String city;
    /**
     * 街道
     */
    @Column(name = "street")
    private String street;
    /**
     * 邮编
     */
    @Column(name = "post_code")
    private String postCode;
    /**
     * 电话
     */
    @Column(name = "telephone")
    private String telephone;
    /**
     * 纳税人识别号
     */
    @Column(name = "tax_number")
    private String taxNumber;
    /**
     * 租户代码
     */
    @Column(name = "tenant_code")
    private String tenantCode;

    @Override
    public String getCode() {
        return code;
    }

    @Override
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

    @Override
    public String getTenantCode() {
        return tenantCode;
    }

    @Override
    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

}