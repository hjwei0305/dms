package com.changhong.sei.mdms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.core.dto.TreeEntity;
import com.changhong.sei.mdms.annotation.MasterData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 行政区域(Region)DTO类
 *
 * @author sei
 * @since 2020-08-17 14:03:33
 */
@MasterData(value = "region")
@ApiModel(description = "行政区域")
public class RegionDto extends BaseEntityDto implements TreeEntity<RegionDto> {
    private static final long serialVersionUID = -65672153789421738L;
    /**
     * 代码
     */
    @NotBlank
    @Size(max = 10)
    @ApiModelProperty(value = "代码", allowableValues="@Size(max = 10)", required = true)
    private String code;

    /**
     * 名称
     */
    @NotBlank
    @Size(max = 90)
    @ApiModelProperty(value = "名称", allowableValues = "@Size(max = 90)", required = true)
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
    @NotNull
    @Min(0)
    @ApiModelProperty(value = "层级")
    private Integer nodeLevel = 0;

    /**
     * 国家Id
     */
    @Size(max = 36)
    @ApiModelProperty(value = "国家Id", allowableValues = "@Size(max = 36)")
    private String countryId;

    /**
     * 关联国家代码
     */
    @ApiModelProperty(value = "关联国家代码")
    private String countryCode;

    /**
     * 关联国家名称
     */
    @ApiModelProperty(value = "关联国家名称")
    private String countryName;

    /**
     * 排序
     */
    @NotNull
    @Min(0)
    @ApiModelProperty(value = "排序", allowableValues = "@Min(0)")
    private Integer rank = 0;


    /**
     * 缩写
     */
    @Size(max = 30)
    @ApiModelProperty(value = "缩写", allowableValues = "@Size(max = 30)")
    private String shortName;

    /**
     * 拼音
     */
    @Size(max = 200)
    @ApiModelProperty(value = "拼音", allowableValues = "@Size(max = 200)")
    private String pinYin;

    /**
     * 租户代码
     */
    @ApiModelProperty(value = "租户代码")
    private String tenantCode;
    /**
     * 商旅城市代码
     */
    @Size(max = 10)
    @ApiModelProperty(value = "商旅城市代码", allowableValues = "@Size(max = 10)")
    private String travelCityCode;

    /**
     * 商旅城市名称
     */
    @Size(max = 90)
    @ApiModelProperty(value = "商旅城市名称", allowableValues = "@Size(max = 90)")
    private String travelCityName;

    /**
     * 子节点列表
     */
    @ApiModelProperty(value = "子节点列表", allowableValues = "list")
    private List<RegionDto> children;

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCodePath() {
        return codePath;
    }

    @Override
    public void setCodePath(String codePath) {
        this.codePath = codePath;
    }

    @Override
    public String getNamePath() {
        return namePath;
    }

    @Override
    public void setNamePath(String namePath) {
        this.namePath = namePath;
    }

    @Override
    public String getParentId() {
        return parentId;
    }

    @Override
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public Integer getNodeLevel() {
        return nodeLevel;
    }

    @Override
    public void setNodeLevel(Integer nodeLevel) {
        this.nodeLevel = nodeLevel;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
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

    @Override
    public List<RegionDto> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<RegionDto> children) {
        this.children = children;
    }
}