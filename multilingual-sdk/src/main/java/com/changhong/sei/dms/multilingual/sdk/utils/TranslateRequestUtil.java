package com.changhong.sei.dms.multilingual.sdk.utils;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.TreeEntity;
import com.changhong.sei.core.log.LogUtil;
import com.changhong.sei.dms.multilingual.sdk.client.dto.TransPropertyValue;
import com.changhong.sei.dms.multilingual.sdk.client.dto.TranslateRequest;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 实现功能: 翻译请求生成工具类
 *
 * @author 王锦光 wangjg
 * @version 2020-03-23 14:52
 */
public class TranslateRequestUtil {
    /**
     * 构造翻译申请的属性值清单
     */
    public static void constructRequest(TranslateRequest request, Object retValue) {
        if (Objects.isNull(retValue)) {
            return;
        }
        // 将返回对象转换为ResultData
        ResultData<?> resultData;
        try {
            resultData = (ResultData<?>) retValue;
        } catch (Exception e) {
            // 转换失败不进行翻译;
            return;
        }
        // 获取返回的数据
        List<Object> returnData = new LinkedList<>();
        if (resultData.getData() instanceof List) {
            List<?> listData = (List<?>) resultData.getData();
            if (CollectionUtils.isEmpty(listData)) {
                return;
            }
            // 检查实体的类名=注解指定的类名
            if (!StringUtils.equals(request.getClassName(), listData.get(0).getClass().getName())) {
                return;
            }
            returnData.addAll(listData);
        } else {
            // 检查实体的类名=注解指定的类名
            if (!StringUtils.equals(request.getClassName(), resultData.getData().getClass().getName())) {
                return;
            }
            returnData.add(resultData.getData());
        }
        if (CollectionUtils.isEmpty(returnData)) {
            return;
        }
        // 循环构造属性值清单
        Set<TransPropertyValue> propertyValues = new LinkedHashSet<>();
        returnData.forEach(obj -> addTransPropertyValues(propertyValues, obj, request.getPropertyNames()));
        request.setPropertyValues(new LinkedList<>(propertyValues));
    }

    /**
     * 添加构造翻译属性值清单
     *
     * @param propertyValues 需要组装的属性值清单
     * @param obj            业务对象
     * @param propertyNames  属性清单
     */
    private static void addTransPropertyValues(Set<TransPropertyValue> propertyValues, Object obj, List<String> propertyNames) {
        // 如果是树形业务实体， 需要递归构造
        if (obj instanceof TreeEntity) {
            propertyValues.addAll(getTransPropertyValue(obj, propertyNames));
            TreeEntity<?> treeNode = (TreeEntity<?>) obj;
            List<?> children = treeNode.getChildren();
            if (CollectionUtils.isNotEmpty(children)) {
                children.forEach(node -> addTransPropertyValues(propertyValues, node, propertyNames));
            }
            return;
        }
        // 一般业务实体
        propertyValues.addAll(getTransPropertyValue(obj, propertyNames));
    }

    /**
     * 获取一个对象的属性值清单
     *
     * @param obj           对象
     * @param propertyNames 属性名清单
     * @return 属性值清单
     */
    private static List<TransPropertyValue> getTransPropertyValue(Object obj, List<String> propertyNames) {
        Set<TransPropertyValue> propertyValues = new LinkedHashSet<>();
        Class<?> clazz = obj.getClass();
        /* 得到类中的所有属性集合 */
        Field[] fields = clazz.getDeclaredFields();
        propertyNames.forEach(propertyName -> {
            try {
                Optional<Field> fieldResult = Arrays.stream(fields).filter(f -> StringUtils.equals(f.getName(), propertyName)).findAny();
                if (fieldResult.isPresent()) {
                    Field field = fieldResult.get();
                    field.setAccessible(true); // 设置些属性是可以访问的
                    TransPropertyValue propertyValue = new TransPropertyValue();
                    propertyValue.setPropertyName(propertyName);
                    String value = (String) field.get(obj);
                    propertyValue.setPropertyValue(value);
                    propertyValues.add(propertyValue);
                }
            } catch (Exception e) {
                LogUtil.error("获取一个对象的属性值清单异常！", e);
            }
        });
        return new LinkedList<>(propertyValues);
    }
}
