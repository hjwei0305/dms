package com.changhong.sei.mdms.management.dto.search;

import com.changhong.sei.core.dto.serach.QuickQueryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * 实现功能: 译文的分页查询参数
 *
 * @author 王锦光 wangjg
 * @version 2020-03-24 9:40
 */
@ApiModel("译文的分页查询参数")
public class TranslationQuickQueryParam extends QuickQueryParam {
    private static final long serialVersionUID = -7673673803337973830L;
    /**
     * 语言类型Id
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
}
