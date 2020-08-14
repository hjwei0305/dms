package com.changhong.sei.mdms.dto;

import java.io.Serializable;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-08-14 00:22
 */
public class TableDto implements Serializable {

    private static final long serialVersionUID = -8584286659550768870L;

    private String name;
    private String remark;

    public TableDto() {
    }

    public TableDto(String name, String remark) {
        this.name = name;
        this.remark = remark;
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
}
