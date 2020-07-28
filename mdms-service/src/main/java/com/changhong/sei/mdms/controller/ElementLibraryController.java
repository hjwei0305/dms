package com.changhong.sei.mdms.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.mdms.api.ElementLibraryApi;
import com.changhong.sei.mdms.dto.ElementLibraryDto;
import com.changhong.sei.mdms.entity.ElementLibrary;
import com.changhong.sei.mdms.service.ElementLibraryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 元素库(ElementLibrary)控制类
 *
 * @author sei
 * @since 2020-07-28 17:31:47
 */
@RestController
@Api(value = "ElementLibraryApi", tags = "$tool.trim($!{tableInfo.comment})服务")
@RequestMapping(path = "elementLibrary", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ElementLibraryController extends BaseEntityController<ElementLibrary, ElementLibraryDto> implements ElementLibraryApi {
    /**
     * 元素库服务对象
     */
    @Autowired
    private ElementLibraryService service;

    @Override
    public BaseEntityService<ElementLibrary> getService() {
        return service;
    }

}