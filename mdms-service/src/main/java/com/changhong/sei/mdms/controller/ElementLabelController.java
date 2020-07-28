package com.changhong.sei.mdms.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.mdms.api.ElementLabelApi;
import com.changhong.sei.mdms.dto.ElementLabelDto;
import com.changhong.sei.mdms.entity.ElementLabel;
import com.changhong.sei.mdms.service.ElementLabelService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 元素标签关系(ElementLabel)控制类
 *
 * @author sei
 * @since 2020-07-28 23:24:30
 */
@RestController
@Api(value = "ElementLabelApi", tags = "元素标签关系服务")
@RequestMapping(path = "elementLabel", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ElementLabelController extends BaseEntityController<ElementLabel, ElementLabelDto> implements ElementLabelApi {
    /**
     * 元素标签关系服务对象
     */
    @Autowired
    private ElementLabelService service;

    @Override
    public BaseEntityService<ElementLabel> getService() {
        return service;
    }

}