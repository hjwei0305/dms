package com.changhong.sei.dms.general.dto;

import com.changhong.sei.annotation.Remark;

/**
 * 实现功能:支付信息使用范围
 *
 * @author 冯华
 * @create 2021-06-29 9:33
 */
public enum PaymentInfoUseScopeEnum {
    @Remark("所有")
    ALL,
    @Remark("现金业务")
    CASH,
    @Remark("票据业务")
    BILL

}
