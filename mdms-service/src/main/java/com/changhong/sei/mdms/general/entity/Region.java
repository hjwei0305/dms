package com.changhong.sei.mdms.general.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 行政区域(Region)实体类
 *
 * @author sei
 * @since 2020-08-17 14:02:47
 */
@Entity
@Table(name = "region")
@DynamicInsert
@DynamicUpdate
public class Region extends BaseAuditableEntity implements Serializable {
    private static final long serialVersionUID = -42649044200407426L;
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
     * 代码路径
     */
    @Column(name = "code_path")
    private String codePath;
    /**
     * 名称路径
     */
    @Column(name = "name_path")
    private String namePath;
    /**
     * 父节点Id
     */
    @Column(name = "parent_id")
    private String parentId;
    /**
     * 层级
     */
    @Column(name = "node_level")
    private Integer nodeLevel;
    /**
     * 国家Id
     */
    @Column(name = "country_id")
    private String countryId;
    /**
     * 排序号
     */
    @Column(name = "rank")
    private Integer rank;
    /**
     * 缩写
     */
    @Column(name = "short_name")
    private String shortName;
    /**
     * 拼音
     */
    @Column(name = "pin_yin")
    private String pinYin;
    /**
     * 租户代码
     */
    @Column(name = "tenant_code")
    private String tenantCode;
    /**
     * 商旅城市代码
     */
    @Column(name = "travel_city_code")
    private String travelCityCode;
    /**
     * 商旅城市名称
     */
    @Column(name = "travel_city_name")
    private String travelCityName;


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

    public String getCodePath() {
        return codePath;
    }

    public void setCodePath(String codePath) {
        this.codePath = codePath;
    }

    public String getNamePath() {
        return namePath;
    }

    public void setNamePath(String namePath) {
        this.namePath = namePath;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getNodeLevel() {
        return nodeLevel;
    }

    public void setNodeLevel(Integer nodeLevel) {
        this.nodeLevel = nodeLevel;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public String getTravelCityCode() {
        return travelCityCode;
    }

    public void setTravelCityCode(String travelCityCode) {
        this.travelCityCode = travelCityCode;
    }

    public String getTravelCityName() {
        return travelCityName;
    }

    public void setTravelCityName(String travelCityName) {
        this.travelCityName = travelCityName;
    }

}