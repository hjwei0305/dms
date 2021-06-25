package com.changhong.sei.dms.multilingual.sdk.aspect;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.log.LogUtil;
import com.changhong.sei.core.util.JsonUtils;
import com.changhong.sei.dms.multilingual.sdk.annotation.MultilingualEnable;
import com.changhong.sei.dms.multilingual.sdk.client.TranslationManager;
import com.changhong.sei.dms.multilingual.sdk.client.dto.LanguageDto;
import com.changhong.sei.dms.multilingual.sdk.client.dto.TransPropertyResult;
import com.changhong.sei.dms.multilingual.sdk.client.dto.TranslateRequest;
import com.changhong.sei.dms.multilingual.sdk.utils.TranslateRequestUtil;
import com.changhong.sei.dms.multilingual.sdk.utils.TranslateResponseUtil;
import com.changhong.sei.exception.ServiceException;
import org.apache.commons.collections.CollectionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 实现功能: 主数据多语言切面
 *
 * @author 王锦光 wangjg
 * @version 2020-03-16 14:09
 */
@Component
@Aspect
public class MultilingualAspect {
    /**
     * 翻译API服务调用
     */
    private final TranslationManager translationManager;

    public MultilingualAspect(TranslationManager translationManager) {
        this.translationManager = translationManager;
    }

    // 注解声明切面
    @Pointcut("@annotation(com.changhong.sei.dms.multilingual.sdk.annotation.MultilingualEnable)")
    public void multilingual() {
    }

    /**
     * 获取请求方法
     *
     * @param joinPoint 切面的切入点
     * @return 方法
     */
    public Method getInvokedMethod(JoinPoint joinPoint) {
        // 调用方法的参数
        List<Class<?>> classList = new LinkedList<>();
        for (Object obj : joinPoint.getArgs()) {
            classList.add(obj.getClass());
        }
        Class<?>[] argsCls = classList.toArray(new Class<?>[0]);

        // 被调用方法名称
        String methodName = joinPoint.getSignature().getName();
        Method method;
        try {
            Class<?> serviceClass = joinPoint.getTarget().getClass();
            method = serviceClass.getMethod(methodName, argsCls);
        } catch (NoSuchMethodException e) {
            throw new ServiceException("通过类型获取指定的方法异常！", e);
        }
        return method;
    }

    /**
     * 后置通知
     */
    @AfterReturning(pointcut = "multilingual()", returning = "retValue")
    public void doAfterService(JoinPoint joinPoint, Object retValue) {
//        if (retValue instanceof ResultData) {
//            return;
//        }
        // 判断当前语言为zh_CN，则不执行多语言翻译
        String localeLang = ContextUtil.getLocaleLang();
        if (LanguageDto.DEFAULT_LANG.equals(localeLang)) {
            return;
        }
        // 获取方法上的注解MultilingualEnable
        Method method = getInvokedMethod(joinPoint);
        MultilingualEnable enable = method.getAnnotation(MultilingualEnable.class);
        LogUtil.bizLog("需要翻译的属性名：{}，语言代码为：{}", enable.propertyNames(), ContextUtil.getLocaleLang());
        // 构造翻译请求
        TranslateRequest request = new TranslateRequest();
        request.setClassName(enable.className());
        request.setLangCode(localeLang);
        request.setPropertyNames(Arrays.asList(enable.propertyNames()));
        // 构造翻译申请的属性值清单
        TranslateRequestUtil.constructRequest(request, retValue);
        if (CollectionUtils.isEmpty(request.getPropertyValues())) {
            return;
        }
        // 调用API获取翻译结果
        LogUtil.bizLog("翻译请求：" + JsonUtils.toJson(request));
        List<TransPropertyResult> transPropertyResults = translationManager.translate(request);
        // 将翻译结果设置到业务实体的属性上
        TranslateResponseUtil.applyResponse(transPropertyResults, request.getPropertyNames(), retValue);
    }
}
