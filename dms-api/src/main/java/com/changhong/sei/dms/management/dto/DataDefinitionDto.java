package com.changhong.sei.dms.management.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.core.dto.serializer.EnumJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * 主数据定义(DataDefinition)DTO类
 *
 * @author sei
 * @since 2020-08-13 22:47:19
 */
@ApiModel(description = "数据定义dto")
public class DataDefinitionDto extends BaseEntityDto {
    private static final long serialVersionUID = 835886251258143397L;
    /**
     * 代码(表名)
     */
    @NotBlank
    @ApiModelProperty(value = "代码")
    private String code;
    /**
     * 名称
     */
    @NotBlank
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 数据结构
     */
    @JsonSerialize(using = EnumJsonSerializer.class)
    @ApiModelProperty(value = "数据结构")
    private DataStructureEnum dataStructure;
    /**
     * 分类id
     */
    @NotBlank
    @ApiModelProperty(value = "分类id")
    private String categoryId;
    /**
     * 分类名称
     */
    @NotBlank
    @ApiModelProperty(value = "分类名称")
    private String categoryName;
    /**
     * 冻结
     * 取消注册即冻结
     */
    @ApiModelProperty(value = "冻结, 取消注册即冻结")
    private Boolean frozen = Boolean.FALSE;
    /**
     * 描述说明
     */
    @ApiModelProperty(value = "描述说明")
    private String remark;

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

    public DataStructureEnum getDataStructure() {
        return dataStructure;
    }

    public void setDataStructure(DataStructureEnum dataStructure) {
        this.dataStructure = dataStructure;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}