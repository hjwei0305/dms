package com.changhong.sei.dms.general.dto;

import com.changhong.sei.annotation.Remark;

/**
 * 实现功能:税分类枚举
 *
 * @author 杨沄炜
 * @create 2021/06/21 11:28
 */
public enum TaxCategory {
    @Remark("销项")
    OUTPUT,
    @Remark("进项")
    INPUT
}
