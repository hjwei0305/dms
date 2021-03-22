package com.changhong.sei.mdms.management.dto.trans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 实现功能: 翻译请求
 *
 * @author 王锦光 wangjg
 * @version 2020-03-26 9:33
 */
@ApiModel("翻译请求")
public class TranslateQuery implements Serializable {
    private static final long serialVersionUID = 511891522926867134L;
    /**
     * 目标语言代码(示例：en)
     */
    @ApiModelProperty(value = "目标语言代码", required = true, example = "en")
    private String to;

    /**
     * 需要翻译的语句清单
     */
    @ApiModelProperty(value = "需要翻译的语句清单", required = true)
    private List<String> queries;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<String> getQueries() {
        return queries;
    }

    public void setQueries(List<String> queries) {
        this.queries = queries;
    }
}
