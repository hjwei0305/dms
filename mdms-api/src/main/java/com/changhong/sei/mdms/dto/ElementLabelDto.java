package com.changhong.sei.mdms.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 元素标签关系(ElementLabel)DTO类
 *
 * @author sei
 * @since 2020-07-28 17:34:22
 */
@ApiModel(description = "$tool.trim($!{tableInfo.comment})DTO")
public class ElementLabelDto extends BaseEntityDto {
    private static final long serialVersionUID = -42412647874545677L;
    /**
     * 元素id
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String elementId;
    /**
     * 标签id
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String labelId;


    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

}