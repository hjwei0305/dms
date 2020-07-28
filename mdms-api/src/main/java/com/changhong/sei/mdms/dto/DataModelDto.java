package com.changhong.sei.mdms.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 数据模型(DataModel)DTO类
 *
 * @author sei
 * @since 2020-07-28 17:32:32
 */
@ApiModel(description = "$tool.trim($!{tableInfo.comment})DTO")
public class DataModelDto extends BaseEntityDto {
    private static final long serialVersionUID = -94523332540832078L;
    /**
     * 数据源code
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String dsCode;
    /**
     * 表名
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String tableName;
    /**
     * 模型分类代码
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String modelTypeCode;
    /**
     * 模型分类名称
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String modelTypeName;
    /**
     * 描述说明
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String remark;
    /**
     * 版本号
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String version_;


    public String getDsCode() {
        return dsCode;
    }

    public void setDsCode(String dsCode) {
        this.dsCode = dsCode;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getModelTypeCode() {
        return modelTypeCode;
    }

    public void setModelTypeCode(String modelTypeCode) {
        this.modelTypeCode = modelTypeCode;
    }

    public String getModelTypeName() {
        return modelTypeName;
    }

    public void setModelTypeName(String modelTypeName) {
        this.modelTypeName = modelTypeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getVersion_() {
        return version_;
    }

    public void setVersion_(String version_) {
        this.version_ = version_;
    }

}