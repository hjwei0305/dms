package com.changhong.sei.mdms.management.service.client.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 实现功能: 百度API翻译结果
 *
 * @author 王锦光 wangjg
 * @version 2020-03-18 13:47
 */
public class TransResult implements Serializable {
    private static final long serialVersionUID = -4239545828618801154L;
    /**
     * 语种（从）
     */
    private String from;
    /**
     * 语种（到）
     */
    private String to;
    /**
     * 翻译的内容
     */
    private List<TransContent> trans_result;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<TransContent> getTrans_result() {
        return trans_result;
    }

    public void setTrans_result(List<TransContent> trans_result) {
        this.trans_result = trans_result;
    }
}
