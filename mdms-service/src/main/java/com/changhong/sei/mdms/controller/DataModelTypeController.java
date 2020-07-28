package com.changhong.sei.mdms.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.mdms.api.DataModelTypeApi;
import com.changhong.sei.mdms.dto.DataModelTypeDto;
import com.changhong.sei.mdms.entity.DataModelType;
import com.changhong.sei.mdms.service.DataModelTypeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据模型分类(DataModelType)控制类
 *
 * @author sei
 * @since 2020-07-28 23:24:26
 */
@RestController
@Api(value = "DataModelTypeApi", tags = "数据模型分类服务")
@RequestMapping(path = "dataModelType", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DataModelTypeController extends BaseEntityController<DataModelType, DataModelTypeDto> implements DataModelTypeApi {
    /**
     * 数据模型分类服务对象
     */
    @Autowired
    private DataModelTypeService service;

    @Override
    public BaseEntityService<DataModelType> getService() {
        return service;
    }

}