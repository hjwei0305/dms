package com.changhong.sei.mdms.management.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 主数据分类(MasterDataType)DTO类
 *
 * @author sei
 * @since 2020-08-13 22:47:08
 */
@ApiModel(description = "主数据分类DTO")
public class DataCategoryDto extends BaseEntityDto {
    private static final long serialVersionUID = 555387474014808942L;
    /**
     * 标识符
     */
    @ApiModelProperty(value = "标识符")
    private String code;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 父节点Id
     */
    @ApiModelProperty(value = "父节点Id")
    private String parentId;
    /**
     * 层级
     */
    @ApiModelProperty(value = "层级")
    private Integer nodeLevel;
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
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer rank;
    /**
     * 描述说明
     */
    @ApiModelProperty(value = "描述说明")
    private String remark;
    /**
     * 冻结
     */
    @ApiModelProperty(value = "冻结")
    private Boolean frozen;


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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

}