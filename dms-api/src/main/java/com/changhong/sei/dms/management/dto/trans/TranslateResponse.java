package com.changhong.sei.dms.management.dto.trans;

import java.io.Serializable;
import java.util.List;

/**
 * 实现功能: 业务实体翻译结果
 *
 * @author 王锦光 wangjg
 * @version 2020-03-23 10:45
 */
public class TranslateResponse implements Serializable {
    private static final long serialVersionUID = 695602195041836009L;
    /**
     * 翻译结果
     */
    private List<TransPropertyResult> transPropertyResults;

    public List<TransPropertyResult> getTransPropertyResults() {
        return transPropertyResults;
    }

    public void setTransPropertyResults(List<TransPropertyResult> transPropertyResults) {
        this.transPropertyResults = transPropertyResults;
    }
}
