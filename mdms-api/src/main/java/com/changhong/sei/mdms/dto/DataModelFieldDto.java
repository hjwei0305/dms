package com.changhong.sei.mdms.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 模型字段(DataModelField)DTO类
 *
 * @author sei
 * @since 2020-07-28 17:34:07
 */
@ApiModel(description = "$tool.trim($!{tableInfo.comment})DTO")
public class DataModelFieldDto extends BaseEntityDto {
    private static final long serialVersionUID = -31098081062994540L;
    /**
     * 数据模型id
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String dataModelId;
    /**
     * 表名
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String fieldName;
    /**
     * 描述说明
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String remark;
    /**
     * 类型
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String dataType;
    /**
     * 长度
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private Integer dataLength;
    /**
     * 精度
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private Integer precision;
    /**
     * 是否主键
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private Boolean primaryKey;
    /**
     * 是否为空
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private Boolean notNull;
    /**
     * 默认值
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String defaultValue;
    /**
     * 外键关联id
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String foreignKey;
    /**
     * 排序
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private Integer rank;
    /**
     * 是否发布
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private Boolean published;


    public String getDataModelId() {
        return dataModelId;
    }

    public void setDataModelId(String dataModelId) {
        this.dataModelId = dataModelId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Integer getDataLength() {
        return dataLength;
    }

    public void setDataLength(Integer dataLength) {
        this.dataLength = dataLength;
    }

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public Boolean getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Boolean getNotNull() {
        return notNull;
    }

    public void setNotNull(Boolean notNull) {
        this.notNull = notNull;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getForeignKey() {
        return foreignKey;
    }

    public void setForeignKey(String foreignKey) {
        this.foreignKey = foreignKey;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

}