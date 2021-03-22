package com.changhong.sei.dms.management.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.core.dto.serializer.EnumJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 主数据配置(DataConfig)DTO类
 *
 * @author sei
 * @since 2020-08-13 22:47:19
 */
@ApiModel(description = "数据配置dto")
public class DataConfigDto extends BaseEntityDto {
    private static final long serialVersionUID = 835886251258143397L;
    /**
     * 数据定义Id
     */
    @NotBlank
    @ApiModelProperty(value = "数据定义Id")
    private String dataDefinitionId;
    /**
     * 配置类型枚举
     */
    @NotNull
    @JsonSerialize(using = EnumJsonSerializer.class)
    @ApiModelProperty(value = "数据结构")
    private ConfigTypeEnum configType;
    /**
     * json格式配置数据
     */
    @NotBlank
    @ApiModelProperty(value = "json格式配置数据")
    private String configData;

    public String getDataDefinitionId() {
        return dataDefinitionId;
    }

    public void setDataDefinitionId(String dataDefinitionId) {
        this.dataDefinitionId = dataDefinitionId;
    }

    public ConfigTypeEnum getConfigType() {
        return configType;
    }

    public void setConfigType(ConfigTypeEnum configType) {
        this.configType = configType;
    }

    public String getConfigData() {
        return configData;
    }

    public void setConfigData(String configData) {
        this.configData = configData;
    }
}