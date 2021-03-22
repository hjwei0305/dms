package com.changhong.sei.mdms.management.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 实现功能: 译文保存输入参数
 *
 * @author 王锦光 wangjg
 * @version 2020-03-25 14:09
 */
@ApiModel("译文保存输入参数")
public class TranslationParam implements Serializable {
    private static final long serialVersionUID = 1187833025791978038L;
    /**
     * 语种Id
     */
    @NotBlank
    @ApiModelProperty(value = "语言类型Id", required = true)
    private String languageId;

    /**
     * 语义类型Id
     */
    @NotBlank
    @ApiModelProperty(value = "语义类型Id", required = true)
    private String semantemeTypeId;

    /**
     * 属性值
     */
    @NotBlank
    @ApiModelProperty(value = "属性值", required = true)
    private String propertyValue;

    /**
     * 翻译值
     */
    @NotBlank
    @ApiModelProperty(value = "翻译值", required = true)
    private String transValue;

    public String getLanguageId() {
        return languageId;
    }

    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    public String getSemantemeTypeId() {
        return semantemeTypeId;
    }

    public void setSemantemeTypeId(String semantemeTypeId) {
        this.semantemeTypeId = semantemeTypeId;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public String getTransValue() {
        return transValue;
    }

    public void setTransValue(String transValue) {
        this.transValue = transValue;
    }
}
