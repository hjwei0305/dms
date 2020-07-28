package com.changhong.sei.mdms.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 元素库(ElementLibrary)DTO类
 *
 * @author sei
 * @since 2020-07-28 17:34:24
 */
@ApiModel(description = "$tool.trim($!{tableInfo.comment})DTO")
public class ElementLibraryDto extends BaseEntityDto {
    private static final long serialVersionUID = 570842453845939121L;
    /**
     * 代码
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String code;
    /**
     * 名称
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String name;
    /**
     * 类型
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String dataType;
    /**
     * 长度
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private Integer dataLength;
    /**
     * 精度
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private Integer precision;
    /**
     * 备注
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

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Integer getDataLength() {
        return dataLength;
    }

    public void setDataLength(Integer dataLength) {
        this.dataLength = dataLength;
    }

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
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