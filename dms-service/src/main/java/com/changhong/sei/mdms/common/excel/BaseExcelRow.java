package com.changhong.sei.mdms.common.excel;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * 实现功能： excel导入导出基类
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-10-13 08:49
 */
public abstract class BaseExcelRow implements Serializable {
    private static final long serialVersionUID = -832238348740436047L;

    /**
     * 所属行数，从0开始
     */
    private int rowNum = 0;
    /**
     * 校验消息，业务尽量使用校验码做判断
     */
    private String validateMessage;

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public String getValidateMessage() {
        return validateMessage;
    }

    public void setValidateMessage(String validateMessage) {
        this.validateMessage = validateMessage;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "[", "]")
                .add("rowNum=" + rowNum)
                .add("validateMessage='" + validateMessage + "'")
                .toString();
    }
}
