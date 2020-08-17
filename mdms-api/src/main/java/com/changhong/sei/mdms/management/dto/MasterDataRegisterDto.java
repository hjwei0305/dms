package com.changhong.sei.mdms.management.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * 主数据UI配置(MasterDataUiConfig)DTO类
 *
 * @author sei
 * @since 2020-08-13 22:47:19
 */
@ApiModel(description = "主数据注册dto")
public class MasterDataRegisterDto extends BaseEntityDto {
    private static final long serialVersionUID = 835886251258143397L;
    /**
     * 代码(表名)
     */
    @NotBlank
    @ApiModelProperty(value = "代码")
    private String code;
    /**
     * 名称
     */
    @NotBlank
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 全路径类名
     */
    @NotBlank
    @ApiModelProperty(value = "全路径类名")
    private String fullName;
    /**
     * 分类代码
     */
    @NotBlank
    @ApiModelProperty(value = "分类代码")
    private String typeCode;
    /**
     * 分类名称
     */
    @NotBlank
    @ApiModelProperty(value = "分类名称")
    private String typeName;
    /**
     * 冻结
     * 取消注册即冻结
     */
    @ApiModelProperty(value = "冻结, 取消注册即冻结")
    private Boolean frozen = Boolean.FALSE;
    /**
     * 描述说明
     */
    @ApiModelProperty(value = "描述说明")
    private String remark;


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

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}