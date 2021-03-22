package com.changhong.sei.dms.management.dto.trans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

/**
 * 实现功能: 需要翻译的属性值
 *
 * @author 王锦光 wangjg
 * @version 2020-03-23 10:40
 */
@ApiModel("需要翻译的属性值")
public class TransPropertyValue implements Serializable {
    private static final long serialVersionUID = -6354963178035722205L;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TransPropertyValue)) {
            return false;
        }
        TransPropertyValue that = (TransPropertyValue) o;
        return Objects.equals(getPropertyName(), that.getPropertyName()) &&
                Objects.equals(getPropertyValue(), that.getPropertyValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPropertyName(), getPropertyValue());
    }
}
