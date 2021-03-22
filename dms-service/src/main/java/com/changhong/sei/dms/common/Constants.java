package com.changhong.sei.dms.common;

/**
 * 实现功能：常量定义
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-08-15 01:38
 */
public interface Constants {
    /**
     * 默认全局租户代码
     */
    String DEFAULT_TENANT = "global";

    /**
     *
     */
    String ENTITY_CACHE_KEY = "sei:mdms:md:clazz";
    String PROPERTY_CACHE_KEY = "sei:mdms:md:property:";

    /**
     * 订阅推送端点-创建
     */
    String PUSH_RECEIVE_CREATE_ENDPOINT = "receiveCreate";
    /**
     * 订阅推送端点-修改
     */
    String PUSH_RECEIVE_MODIFY_ENDPOINT = "receiveCreate";
    /**
     * 订阅推送端点-删除
     */
    String PUSH_RECEIVE_DELETE_ENDPOINT = "receiveCreate";
}
