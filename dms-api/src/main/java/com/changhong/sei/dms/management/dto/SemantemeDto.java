package com.changhong.sei.dms.management.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 实现功能: 语义表DTO
 *
 * @author 王锦光 wangjg
 * @version 2020-03-21 22:07
 */
@ApiModel("语义表DTO")
public class SemantemeDto extends BaseEntityDto {
    private static final long serialVersionUID = 6502014850825091367L;
    /**
     * 语义类型Id
     */
    @NotBlank
    @Size(max = 36)
    @ApiModelProperty(value = "语义类型Id", required = true)
    private String semantemeTypeId;

    /**
     * 语义类型类名
     */
    @ApiModelProperty(value = "语义类型类名")
    private String semantemeTypeClassName;

    /**
     * 语义类型属性名
     */
    @ApiModelProperty(value = "语义类型属性名")
    private String semantemeTypePropertyName;

    /**
     * 属性值
     */
    @NotBlank
    @Size(max = 300)
    @ApiModelProperty(value = "属性值", required = true)
    private String propertyValue;

    public String getSemantemeTypeId() {
        return semantemeTypeId;
    }

    public void setSemantemeTypeId(String semantemeTypeId) {
        this.semantemeTypeId = semantemeTypeId;
    }

    public String getSemantemeTypeClassName() {
        return semantemeTypeClassName;
    }

    public void setSemantemeTypeClassName(String semantemeTypeClassName) {
        this.semantemeTypeClassName = semantemeTypeClassName;
    }

    public String getSemantemeTypePropertyName() {
        return semantemeTypePropertyName;
    }

    public void setSemantemeTypePropertyName(String semantemeTypePropertyName) {
        this.semantemeTypePropertyName = semantemeTypePropertyName;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }
}
