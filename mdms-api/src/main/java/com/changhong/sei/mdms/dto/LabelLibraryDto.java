package com.changhong.sei.mdms.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 标签库(LabelLibrary)DTO类
 *
 * @author sei
 * @since 2020-07-28 17:34:27
 */
@ApiModel(description = "$tool.trim($!{tableInfo.comment})DTO")
public class LabelLibraryDto extends BaseEntityDto {
    private static final long serialVersionUID = 234794923167369969L;
    /**
     * 标识符
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String code;
    /**
     * 名称
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String name;
    /**
     * 类型code
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String labelTypeCode;
    /**
     * 类型name
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String labelTypeName;
    /**
     * 描述说明
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String remark;
    /**
     * 冻结
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private Boolean frozen;


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

    public String getLabelTypeCode() {
        return labelTypeCode;
    }

    public void setLabelTypeCode(String labelTypeCode) {
        this.labelTypeCode = labelTypeCode;
    }

    public String getLabelTypeName() {
        return labelTypeName;
    }

    public void setLabelTypeName(String labelTypeName) {
        this.labelTypeName = labelTypeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

}