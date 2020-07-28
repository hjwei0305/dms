package com.changhong.sei.mdms.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 数据模型(DataModel)DTO类
 *
 * @author sei
 * @since 2020-07-28 23:23:49
 */
@ApiModel(description = "数据模型DTO")
public class DataModelDto extends BaseEntityDto {
    private static final long serialVersionUID = -69867743981533719L;
    /**
     * 数据源code
     */
    @ApiModelProperty(value = "数据源code")
    private String dsCode;
    /**
     * 表名
     */
    @ApiModelProperty(value = "表名")
    private String tableName;
    /**
     * 模型分类代码
     */
    @ApiModelProperty(value = "模型分类代码")
    private String modelTypeCode;
    /**
     * 模型分类名称
     */
    @ApiModelProperty(value = "模型分类名称")
    private String modelTypeName;
    /**
     * 描述说明
     */
    @ApiModelProperty(value = "描述说明")
    private String remark;
    /**
     * 版本号
     */
    @ApiModelProperty(value = "版本号")
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