package com.changhong.sei.mdms.management.dto;

import com.changhong.sei.annotation.Remark;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-08-18 09:38
 */
public enum ConfigTypeEnum {
    
    /**
     * 表单
     */
    @Remark("表单")
    UI,

    /**
     * 导入
     */
    @Remark("导入")
    Import,

    /**
     * 导出
     */
    @Remark("导出")
    Export
}
