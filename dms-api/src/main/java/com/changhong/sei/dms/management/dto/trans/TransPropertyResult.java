package com.changhong.sei.dms.management.dto.trans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 实现功能: 属性翻译结果
 *
 * @author 王锦光 wangjg
 * @version 2020-03-23 10:46
 */
@ApiModel("属性翻译结果")
public class TransPropertyResult implements Serializable {
    private static final long serialVersionUID = 7473981872231673819L;
    /**
     * 属性名
     */
    @NotBlank
    @ApiModelProperty(value = "属性名", required = true)
    private String propertyName;

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

    public TransPropertyResult() {
    }

    public TransPropertyResult(String propertyName, String propertyValue, String transValue) {
        this.propertyName = propertyName;
        this.propertyValue = propertyValue;
        this.transValue = transValue;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
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
