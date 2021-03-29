package com.changhong.sei.dms.annotation;

import java.lang.annotation.*;

/**
 * 实现功能：主数据标示
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-08-15 00:11
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.TYPE})
public @interface MasterData {
    /**
     * @return 主数据实体名作为代码
     */
    String code();

    /**
     * @return 主数据描述说明
     */
    String name();
}
