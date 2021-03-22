package com.changhong.sei.mdms.management.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.mdms.management.api.SemantemeApi;
import com.changhong.sei.mdms.management.dto.SemantemeDto;
import com.changhong.sei.mdms.management.entity.Semanteme;
import com.changhong.sei.mdms.management.service.SemantemeService;
import io.swagger.annotations.Api;
import org.modelmapper.PropertyMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 实现功能: 语义表API服务实现
 *
 * @author 王锦光 wangjg
 * @version 2020-03-22 8:04
 */
@RestController
@Api(value = "SemantemeApi", tags = "语义表API服务实现")
@RequestMapping(path = "semanteme", produces = MediaType.APPLICATION_JSON_VALUE)
public class SemantemeController extends BaseEntityController<Semanteme, SemantemeDto> implements SemantemeApi {
    private final SemantemeService service;

    public SemantemeController(SemantemeService service) {
        this.service = service;
    }

    @Override
    public BaseEntityService<Semanteme> getService() {
        return service;
    }

    /**
     * 自定义设置Entity转换为DTO的转换器
     */
    @Override
    protected void customConvertToDtoMapper() {
        // 创建自定义映射规则
        PropertyMap<Semanteme, SemantemeDto> propertyMap = new PropertyMap<Semanteme, SemantemeDto>() {
            @Override
            protected void configure() {
                // 使用自定义转换规则
                map().setSemantemeTypeId(source.getSemantemeTypeId());
            }
        };
        // 添加映射器
        dtoModelMapper.addMappings(propertyMap);
    }
}
