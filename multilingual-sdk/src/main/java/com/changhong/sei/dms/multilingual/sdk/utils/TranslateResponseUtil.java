package com.changhong.sei.dms.multilingual.sdk.utils;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.TreeEntity;
import com.changhong.sei.core.log.LogUtil;
import com.changhong.sei.dms.multilingual.sdk.client.dto.TransPropertyResult;
import com.changhong.sei.dms.multilingual.sdk.client.dto.TransPropertyValue;
import com.changhong.sei.exception.ServiceException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * 实现功能: 翻译结果设置工具类
 *
 * @author 王锦光 wangjg
 * @version 2020-03-23 14:52
 */
public class TranslateResponseUtil {
    /**
     * 应用翻译结果到业务实体属性值
     */
    public static void applyResponse(List<TransPropertyResult> transPropertyResults, List<String> propertyNames, Object retValue) {
        if (CollectionUtils.isEmpty(transPropertyResults)) {
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
            returnData.addAll((List<?>) resultData.getData());
        } else {
            returnData.add(resultData.getData());
        }
        if (CollectionUtils.isEmpty(returnData)) {
            return;
        }
        // 循环设置属性值
        returnData.forEach(obj -> setTransPropertyValues(transPropertyResults, propertyNames, obj));
    }

    /**
     * 设置翻译结果到对应属性
     */
    private static void setTransPropertyValues(List<TransPropertyResult> transPropertyResults, List<String> propertyNames, Object obj) {
        // 如果是树形业务实体， 需要递归设置
        if (obj instanceof TreeEntity) {
            setTransPropertyResult(transPropertyResults, propertyNames, obj);
            TreeEntity<?> treeNode = (TreeEntity<?>) obj;
            List<?> children = treeNode.getChildren();
            if (CollectionUtils.isNotEmpty(children)) {
                children.forEach(node -> setTransPropertyValues(transPropertyResults, propertyNames, node));
            }
            return;
        }
        // 一般业务实体
        setTransPropertyResult(transPropertyResults, propertyNames, obj);
    }

    /**
     * 设置一个对象的属性值
     */
    private static void setTransPropertyResult(List<TransPropertyResult> transPropertyResults, List<String> propertyNames, Object obj) {
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
                    // 获取翻译结果
                    Optional<TransPropertyResult> transResult = transPropertyResults.stream().filter(t -> StringUtils.equals(t.getPropertyName(), propertyName)
                            && StringUtils.equals(t.getPropertyValue(), value)).findAny();
                    if (transResult.isPresent()) {
                        TransPropertyResult propertyResult = transResult.get();
                        // 设置翻译结果
                        field.set(obj, propertyResult.getTransValue());
                    }
                }
            } catch (Exception e) {
                LogUtil.error("设置一个对象的属性值异常！", e);
            }
        });
    }
}
