package com.changhong.sei.mdms.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.mdms.api.DataTypeApi;
import com.changhong.sei.mdms.dto.DataTypeDto;
import com.changhong.sei.mdms.entity.DataType;
import com.changhong.sei.mdms.service.DataTypeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据类型(DataType)控制类
 *
 * @author sei
 * @since 2020-07-28 23:24:29
 */
@RestController
@Api(value = "DataTypeApi", tags = "数据类型服务")
@RequestMapping(path = "dataType", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DataTypeController extends BaseEntityController<DataType, DataTypeDto> implements DataTypeApi {
    /**
     * 数据类型服务对象
     */
    @Autowired
    private DataTypeService service;

    @Override
    public BaseEntityService<DataType> getService() {
        return service;
    }

}