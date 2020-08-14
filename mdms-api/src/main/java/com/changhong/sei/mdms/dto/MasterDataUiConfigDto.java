package com.changhong.sei.mdms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 主数据UI配置(MasterDataUiConfig)DTO类
 *
 * @author sei
 * @since 2020-08-13 22:47:19
 */
@ApiModel(description = "主数据UI配置DTO")
public class MasterDataUiConfigDto extends MasterDataRegisterRequest {
    private static final long serialVersionUID = 835886251258143397L;

    /**
     * UI表格默认排序配置json
     */
    @ApiModelProperty(value = "UI表格默认排序配置json")
    private String rankFields;
    /**
     * UI表格配置json
     */
    @ApiModelProperty(value = "UI表格配置json")
    private String tableData;
    /**
     * UI表单配置json
     */
    @ApiModelProperty(value = "UI表单配置json")
    private String formData;
    /**
     * 导入导出配置json
     */
    @ApiModelProperty(value = "导入导出配置json")
    private String impExpData;

    public String getRankFields() {
        return rankFields;
    }

    public void setRankFields(String rankFields) {
        this.rankFields = rankFields;
    }

    public String getTableData() {
        return tableData;
    }

    public void setTableData(String tableData) {
        this.tableData = tableData;
    }

    public String getFormData() {
        return formData;
    }

    public void setFormData(String formData) {
        this.formData = formData;
    }

    public String getImpExpData() {
        return impExpData;
    }

    public void setImpExpData(String impExpData) {
        this.impExpData = impExpData;
    }

}