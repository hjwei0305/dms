package com.changhong.sei.dms.general.dto;

import com.changhong.sei.annotation.Remark;

/**
 * 实现功能: 收款对象类型枚举
 *
 * @author 冯华
 * @create 2021-06-29 9:21
 */
public enum ReceiverTypeEnum {
    @Remark("供应商")
    K,
    @Remark("客户")
    D,
    @Remark("员工")
    H
}
