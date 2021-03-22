package com.changhong.sei.mdms.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 实现功能: 字符串类名工具类
 *
 * @author 王锦光 wangjg
 * @version 2020-03-24 11:25
 */
public class StringClassNameUtil {

    /**
     * 获取全类名中的简单类名
     *
     * @param className 全类名
     * @return 简单类名
     */
    public static String getSimpleName(String className) {
        int lastDian = StringUtils.lastIndexOf(className, ".");
        if (lastDian <= 0) {
            return className;
        }
        return StringUtils.right(className, className.length() - lastDian - 1);
    }

    /**
     * 获取语义类型的默认描述
     *
     * @param className    全类名
     * @param propertyName 属性名
     * @return 默认描述
     */
    public static String getRemark(String className, String propertyName) {
        String shortName = getSimpleName(className);
        return shortName + "." + propertyName;
    }
}
