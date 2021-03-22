package com.changhong.sei.dms.multilingual.sdk.annotation;

import java.lang.annotation.*;

/**
 * 实现功能: 在方法上启用主数据多语言
 *
 * @author 王锦光 wangjg
 * @version 2020-03-16 14:31
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.PARAMETER, ElementType.METHOD})
public @interface MultilingualEnable {
    /**
     * 如果为true，则方法上启用多语言
     *
     * @return 启用多语言
     */
    boolean enable() default true;

    /**
     * 业务实体的全类名，默认为返回业务实体的类型全名
     *
     * @return 业务实体的全类名
     */
    String className() default "";

    /**
     * 需要多语言翻译的属性名清单
     *
     * @return 属性名清单
     */
    String[] propertyNames() default {"name"};
}
