package com.changhong.sei.mdms.dto;

import java.io.Serializable;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-08-14 00:22
 */
public class ColumnDto implements Serializable {

    private static final long serialVersionUID = -8584286659550768870L;

    private Boolean primary;
    private String name;
    private String remark;
    private String type;

    public ColumnDto() {
    }

    public ColumnDto(String name, String remark, String type) {
        this.name = name;
        this.remark = remark;
        this.type = type;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
