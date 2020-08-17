package com.changhong.sei.mdms.config;

import com.changhong.sei.core.cache.CacheBuilder;
import com.changhong.sei.core.log.LogUtil;
import com.changhong.sei.mdms.annotation.MasterData;
import com.changhong.sei.mdms.common.Constants;
import com.changhong.sei.mdms.management.dto.EntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.autoconfigure.domain.EntityScanPackages;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-08-15 00:59
 */
@Configuration
public class AnnotationScan implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * 是否已执行标示,只需要执行一次
     */
    private static volatile AtomicBoolean executed = new AtomicBoolean(false);

    @Autowired
    private CacheBuilder cacheBuilder;

    /**
     * 初始化方法
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (executed.compareAndSet(false, true)) {
            ApplicationContext context = event.getApplicationContext();
            List<EntityDto> entityDtos = new ArrayList<>();
            try {
                Set<Class<?>> classSet = this.scan(context, MasterData.class, ApiModel.class);
                if (CollectionUtils.isNotEmpty(classSet)) {
                    ApiModelProperty property;
                    EntityDto dto;
                    Field[] fields;
                    EntityDto.Property propertyDto;
                    List<EntityDto.Property> propertyDtos = new ArrayList<>();
                    for (Class<?> clazz : classSet) {
                        MasterData masterData = clazz.getAnnotation(MasterData.class);
                        if (Objects.isNull(masterData)) {
                            continue;
                        }
                        ApiModel apiModel = clazz.getAnnotation(ApiModel.class);
                        if (Objects.isNull(apiModel)) {
                            continue;
                        }

                        // 首字母小写
                        String code = StringUtils.uncapitalize(masterData.value());
                        dto = new EntityDto();
                        dto.setCode(code);
                        dto.setFullName(clazz.getName());
                        dto.setName(apiModel.description());
                        entityDtos.add(dto);

                        for (Class<?> superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
                            fields = superClass.getDeclaredFields();
                            for (Field field : fields) {
                                property = field.getAnnotation(ApiModelProperty.class);
                                if (Objects.isNull(property)) {
                                    continue;
                                }
                                propertyDto = new EntityDto.Property();
                                propertyDto.setCode(field.getName());
                                propertyDto.setName(property.value());
                                propertyDtos.add(propertyDto);
                            }
                        }

                        // 排序
                        propertyDtos.sort(Comparator.comparing(EntityDto.Property::getCode));
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


    /**
     * Scan for entities with the specified annotations.
     *
     * @param annotationTypes the annotation types used on the entities
     * @return a set of entity classes
     * @throws ClassNotFoundException if an entity class cannot be loaded
     */
    @SafeVarargs
    public final Set<Class<?>> scan(ApplicationContext context, Class<? extends Annotation>... annotationTypes)
            throws ClassNotFoundException {
        List<String> packages = EntityScanPackages.get(context).getPackageNames();
        if (packages.isEmpty() && AutoConfigurationPackages.has(context)) {
            packages = AutoConfigurationPackages.get(context);
        }
        if (packages.isEmpty()) {
            return Collections.emptySet();
        }

        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.setEnvironment(context.getEnvironment());
        scanner.setResourceLoader(context);

        for (Class<? extends Annotation> annotationType : annotationTypes) {
            scanner.addIncludeFilter(new AnnotationTypeFilter(annotationType));
        }

        ClassLoader classLoader = context.getClassLoader();
        Set<Class<?>> entitySet = new HashSet<>();
        for (String basePackage : packages) {
            if (StringUtils.isNotBlank(basePackage)) {
                for (BeanDefinition candidate : scanner.findCandidateComponents(basePackage)) {
                    entitySet.add(ClassUtils.forName(Objects.requireNonNull(candidate.getBeanClassName()), classLoader));
                }
            }
        }
        return entitySet;
    }
}
