package com.changhong.sei.mdms.management.dto.trans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 实现功能: 业务实体翻译请求
 *
 * @author 王锦光 wangjg
 * @version 2020-03-23 10:32
 */
@ApiModel("业务实体翻译请求")
public class TranslateRequest implements Serializable {
    private static final long serialVersionUID = -1254292945136874072L;
    /**
     * 业务实体类型名(语义类型)
     */
    @NotBlank
    @ApiModelProperty(value = "业务实体类型全名", required = true)
    private String className;

    /**
     * 需要翻译的属性名清单
     */
    @NotNull
    @ApiModelProperty(value = "需要翻译的属性名清单", required = true)
    private List<String> propertyNames;

    /**
     * 目标语言代码
     */
    @NotBlank
    @ApiModelProperty(value = "目标语言代码", required = true)
    private String langCode;

    /**
     * 需要翻译的业务实体属性值清单
     */
    @NotNull
    @ApiModelProperty(value = "需要翻译的业务实体属性值清单", required = true)
    private List<TransPropertyValue> propertyValues;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<String> getPropertyNames() {
        return propertyNames;
    }

    public void setPropertyNames(List<String> propertyNames) {
        this.propertyNames = propertyNames;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public List<TransPropertyValue> getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(List<TransPropertyValue> propertyValues) {
        this.propertyValues = propertyValues;
    }
}
