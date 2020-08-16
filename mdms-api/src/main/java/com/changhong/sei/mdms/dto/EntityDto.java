package com.changhong.sei.mdms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-08-14 00:22
 */
@ApiModel(description = "实体对象DTO")
public class EntityDto implements Serializable {

    private static final long serialVersionUID = -8584286659550768870L;

    @ApiModelProperty(value = "首字母小写类名")
    private String code;
    @ApiModelProperty(value = "备注描述")
    private String name;
    @ApiModelProperty(value = "全路径类名")
    private String fullName;

    public EntityDto() {
    }

    public EntityDto(String code, String name, String fullName) {
        this.name = name;
        this.code = code;
        this.fullName = fullName;
    }

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
