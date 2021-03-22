package com.changhong.sei.mdms.management.dto;

import com.changhong.sei.core.dto.serializer.EnumJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
    /**
     * 数据结构
     */
    @JsonSerialize(using = EnumJsonSerializer.class)
    @ApiModelProperty(value = "数据结构")
    private DataStructureEnum dataStructure;

    public EntityDto() {
    }

    public EntityDto(String code, String name) {
        this.name = name;
        this.code = code;
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

    public DataStructureEnum getDataStructure() {
        return dataStructure;
    }

    public void setDataStructure(DataStructureEnum dataStructure) {
        this.dataStructure = dataStructure;
    }

    /**
     * 属性
     */
    public static class Property implements Serializable {

        private static final long serialVersionUID = -8584286659550768870L;

        private String code;
        private String name;

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
    }
}
