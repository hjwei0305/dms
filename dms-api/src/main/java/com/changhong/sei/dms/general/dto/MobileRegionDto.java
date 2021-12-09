package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 实现功能: 移动端行政区域Dto
 *
 * @author 冯华
 * @create 2021-12-07 14:49
 */
@ApiModel(description = "移动端行政区域Dto")
public class MobileRegionDto extends BaseEntityDto {
    private static final long serialVersionUID = 709250426720236721L;

    /**
     * 代码
     */
    @ApiModelProperty(value = "代码")
    private String code;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 第一个字首字母
     */
    @ApiModelProperty(value = "第一个字首字母（后台排序用）")
    private String initials;
    /**
     * 拼音
     */
    @ApiModelProperty(value = "拼音（后台排序用）")
    private String pinYin;

    /**
     * 代码路径
     */
    @ApiModelProperty(value = "代码路径")
    private String codePath;

    /**
     * 名称路径
     */
    @ApiModelProperty(value = "名称路径")
    private String namePath;

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

    public String getInitials() {
        return pinYin.substring(0, 1);
    }

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin;
    }

    public String getCodePath() {
        return codePath;
    }

    public void setCodePath(String codePath) {
        this.codePath = codePath;
    }

    public String getNamePath() {
        return namePath;
    }

    public void setNamePath(String namePath) {
        this.namePath = namePath;
    }
}
