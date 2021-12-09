package com.changhong.sei.dms.general.dto.search;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 实现功能: 移动端行政区域查询参数
 *
 * @author 冯华
 * @create 2021-09-18 14:16
 */
public class MobileRegionParam implements Serializable {
    private static final long serialVersionUID = -4131741237496852434L;
    /**
     * 首字母
     */
    @ApiModelProperty(value = "首字母")
    private String initials;
    /**
     * 名称搜索值
     */
    @ApiModelProperty(value = "名称搜索值")
    private String nameSearchValue;

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getNameSearchValue() {
        return nameSearchValue;
    }

    public void setNameSearchValue(String nameSearchValue) {
        this.nameSearchValue = nameSearchValue;
    }
}
