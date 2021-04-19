package com.changhong.sei.dms.management.dto;

import com.changhong.sei.annotation.Remark;

/**
 * 实现功能:在职状态枚举
 *
 * @author 冯华
 * @create 2021-04-19 10:33
 */
public enum WorkingStatusEnum {
    @Remark("在职")
    ON_JOB,
    @Remark("已离职")
    RESIGNED,
    @Remark("已退休")
    SUPERANNUATED
}
