package com.changhong.sei.mdms.management.service.client.dto;

import java.io.Serializable;

/**
 * 实现功能: 翻译的内容
 *
 * @author 王锦光 wangjg
 * @version 2020-03-18 14:01
 */
public class TransContent implements Serializable {
    private static final long serialVersionUID = 4118805265119858149L;
    /**
     * 源内容
     */
    private String src;
    /**
     * 目标内容
     */
    private String dst;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }
}
