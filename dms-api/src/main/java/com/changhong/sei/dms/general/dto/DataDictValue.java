package com.changhong.sei.dms.general.dto;

import java.io.Serializable;

/**
 * 数据字典值
 */
public class DataDictValue implements Serializable {
    private static final long serialVersionUID = 8990918592301339034L;

    /**
     * 展示值
     */
    private String dataName;

    /**
     * 使用值
     */
    private String dataValue;

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }
}
