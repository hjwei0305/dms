package com.changhong.sei.dms.management.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 实现功能: 语义类型DTO
 *
 * @author 王锦光 wangjg
 * @version 2020-03-21 22:07
 */
@ApiModel("语义类型DTO")
public class SemantemeTypeDto extends BaseEntityDto {
    private static final long serialVersionUID = -1404491157931589012L;
    /**
     * 业务实体全类名
     */
    @NotBlank
    @Size(max = 100)
    @ApiModelProperty(value = "业务实体全类名", required = true)
    private String className;

    /**
     * 属性名
     */
    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(value = "属性名", required = true)
    private String propertyName;

    /**
     * 描述
     */
    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(value = "描述", required = true)
    private String remark;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
