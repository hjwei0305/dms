package com.changhong.sei.mdms.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 数据模型分类(DataModelType)DTO类
 *
 * @author sei
 * @since 2020-07-28 17:32:37
 */
@ApiModel(description = "$tool.trim($!{tableInfo.comment})DTO")
public class DataModelTypeDto extends BaseEntityDto {
    private static final long serialVersionUID = -73965700030067522L;
    /**
     * 标识符
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String code;
    /**
     * 名称
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String name;
    /**
     * 父节点Id
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String parentId;
    /**
     * 层级
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private Object nodeLevel;
    /**
     * 代码路径
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String codePath;
    /**
     * 名称路径
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String namePath;
    /**
     * 排序
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private Integer rank;
    /**
     * 描述说明
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String remark;
    /**
     * 冻结
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
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

    public Object getNodeLevel() {
        return nodeLevel;
    }

    public void setNodeLevel(Object nodeLevel) {
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