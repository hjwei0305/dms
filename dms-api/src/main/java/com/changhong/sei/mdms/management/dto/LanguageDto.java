package com.changhong.sei.mdms.management.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 实现功能: 语言类型DTO
 *
 * @author 王锦光 wangjg
 * @version 2020-03-21 22:07
 */
@ApiModel("语言类型DTO")
public class LanguageDto extends BaseEntityDto {
    public static final String DEFAULT_LANG = "zh_CN";
    private static final long serialVersionUID = -2236581347157212980L;
    /**
     * 代码
     */
    @NotBlank
    @Size(max = 10)
    @ApiModelProperty(value = "代码", required = true)
    private String code;

    /**
     * 名称
     */
    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(value = "名称", required = true)
    private String name;

    /**
     * 基础语言码
     */
    @NotBlank
    @Size(max = 10)
    @ApiModelProperty(value = "基础语言码", required = true)
    private String baseCode;

    /**
     * 排序号
     */
    @NotNull
    @Min(0)
    @ApiModelProperty(value = "排序号", required = true)
    private Integer rank = 0;

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

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
