package com.changhong.sei.mdms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.mdms.annotation.MasterData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 行政区域(Region)DTO类
 *
 * @author sei
 * @since 2020-08-17 14:03:33
 */
@MasterData
@ApiModel(description = "行政区域")
public class RegionDto extends BaseEntityDto {
    private static final long serialVersionUID = -65672153789421738L;
    /**
     * 代码
     */
    @ApiModelProperty(value = "代码")
    private String code;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 代码路径
     */
    @ApiModelProperty(value = "代码路径")
    private String codePath;
    /**
     * 名称路径
     */
    @ApiModelProperty(value = "名称路径")
    private String namePath;
    /**
     * 父节点Id
     */
    @ApiModelProperty(value = "父节点Id")
    private String parentId;
    /**
     * 层级
     */
    @ApiModelProperty(value = "层级")
    private Object nodeLevel;
    /**
     * 国家Id
     */
    @ApiModelProperty(value = "国家Id")
    private String countryId;
    /**
     * 排序号
     */
    @ApiModelProperty(value = "排序号")
    private Integer rank;
    /**
     * 缩写
     */
    @ApiModelProperty(value = "缩写")
    private String shortName;
    /**
     * 拼音
     */
    @ApiModelProperty(value = "拼音")
    private String pinYin;
    /**
     * 租户代码
     */
    @ApiModelProperty(value = "租户代码")
    private String tenantCode;
    /**
     * 商旅城市代码
     */
    @ApiModelProperty(value = "商旅城市代码")
    private String travelCityCode;
    /**
     * 商旅城市名称
     */
    @ApiModelProperty(value = "商旅城市名称")
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

    public Object getNodeLevel() {
        return nodeLevel;
    }

    public void setNodeLevel(Object nodeLevel) {
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