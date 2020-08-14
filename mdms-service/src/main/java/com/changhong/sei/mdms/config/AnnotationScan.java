package com.changhong.sei.mdms.config;

import com.changhong.sei.core.cache.CacheBuilder;
import com.changhong.sei.core.log.LogUtil;
import com.changhong.sei.mdms.annotation.MasterData;
import com.changhong.sei.mdms.common.Constants;
import com.changhong.sei.mdms.dto.CodeNameDto;
import com.changhong.sei.mdms.dto.EntityDto;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScanner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.annotation.Persistent;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-08-15 00:59
 */
@Configuration
public class AnnotationScan implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private CacheBuilder cacheBuilder;

    /**
     * 初始化方法
     *
     * @param event
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        List<EntityDto> entityDtos = new ArrayList<>();
        try {
            EntityScanner scanner = new EntityScanner(event.getApplicationContext());
            Set<Class<?>> classSet = scanner.scan(MasterData.class, Persistent.class);
            if (CollectionUtils.isNotEmpty(classSet)) {
                EntityDto dto;
                Field[] fields;
                CodeNameDto propertyDto;
                List<CodeNameDto> propertyDtos = new ArrayList<>();
                for (Class<?> clazz : classSet) {
                    String code = StringUtils.uncapitalize(clazz.getSimpleName());
                    dto = new EntityDto();
                    dto.setName(code);
                    dto.setFullName(clazz.getName());
                    dto.setRemark(clazz.getAnnotation(MasterData.class).name());
                    entityDtos.add(dto);
                    fields = clazz.getDeclaredFields();
                    for (Field field : fields) {
                        propertyDto = new CodeNameDto();
                        propertyDto.setName(field.getName());
                        propertyDto.setCode(field.getName());
                        propertyDtos.add(propertyDto);
                    }

                    // 排序
                    propertyDtos.sort(Comparator.comparing(CodeNameDto::getCode));
                    cacheBuilder.set(Constants.PROPERTY_CACHE_KEY + code, propertyDtos);
                }
            }
            // 排序
            entityDtos.sort(Comparator.comparing(EntityDto::getName));
            cacheBuilder.set(Constants.ENTITY_CACHE_KEY, entityDtos);
        } catch (ClassNotFoundException e) {
            LogUtil.error("读取主数据标示[@MasterData]异常.", e);
        }
    }
}
