package com.changhong.sei.mdms.dto;

import java.io.Serializable;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-08-14 00:22
 */
public class CodeNameDto implements Serializable {

    private static final long serialVersionUID = -8584286659550768870L;

    private String code;
    private String name;

    public CodeNameDto() {
    }

    public CodeNameDto(String code, String name) {
        this.code = code;
        this.name = name;
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

}
