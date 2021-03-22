package com.changhong.sei.mdms.management.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 实现功能: 译文表DTO
 *
 * @author 王锦光 wangjg
 * @version 2020-03-21 22:07
 */
@ApiModel("译文表DTO")
public class TranslationDto extends BaseEntityDto {
    private static final long serialVersionUID = 3951649990892970500L;
    /**
     * 语言类型Id
     */
    @NotBlank
    @Size(max = 36)
    @ApiModelProperty(value = "语言类型Id", required = true)
    private String languageId;

    /**
     * 语言类型代码
     */
    @ApiModelProperty(value = "语言类型代码")
    private String languageCode;

    /**
     * 语言类型名称
     */
    @ApiModelProperty(value = "语言类型名称")
    private String languageName;

    /**
     * 语义Id
     */
    @NotBlank
    @Size(max = 36)
    @ApiModelProperty(value = "语义Id", required = true)
    private String semantemeId;

    /**
     * 语义属性值
     */
    @ApiModelProperty(value = "语义属性值")
    private String semantemePropertyValue;

    /**
     * 翻译值
     */
    @NotBlank
    @Size(max = 900)
    @ApiModelProperty(value = "翻译值", required = true)
    private String transValue;

    public String getLanguageId() {
        return languageId;
    }

    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getSemantemeId() {
        return semantemeId;
    }

    public void setSemantemeId(String semantemeId) {
        this.semantemeId = semantemeId;
    }

    public String getSemantemePropertyValue() {
        return semantemePropertyValue;
    }

    public void setSemantemePropertyValue(String semantemePropertyValue) {
        this.semantemePropertyValue = semantemePropertyValue;
    }

    public String getTransValue() {
        return transValue;
    }

    public void setTransValue(String transValue) {
        this.transValue = transValue;
    }
}
