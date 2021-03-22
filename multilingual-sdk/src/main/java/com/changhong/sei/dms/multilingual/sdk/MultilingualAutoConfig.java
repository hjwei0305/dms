package com.changhong.sei.dms.multilingual.sdk;

import com.changhong.sei.dms.multilingual.sdk.aspect.MultilingualAspect;
import com.changhong.sei.dms.multilingual.sdk.client.TranslationManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 实现功能: 通用主数据配置类
 *
 * @author 王锦光 wangjg
 * @version 2020-03-25 10:51
 */
@Configuration
public class MultilingualAutoConfig {
    /**
     * 配置调用译文API服务
     *
     * @return 调用译文API服务Bean
     */
    @Bean
    public TranslationManager translationManager() {
        return new TranslationManager();
    }

    /**
     * 配置主数据多语言切面拦截
     *
     * @return 主数据多语言切面拦截Bean
     */
    @Bean
    public MultilingualAspect multilingualAspect() {
        return new MultilingualAspect(translationManager());
    }
}
