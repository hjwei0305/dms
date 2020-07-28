package com.changhong.sei.mdms.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.mdms.api.DataModelApi;
import com.changhong.sei.mdms.dto.DataModelDto;
import com.changhong.sei.mdms.entity.DataModel;
import com.changhong.sei.mdms.service.DataModelService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据模型(DataModel)控制类
 *
 * @author sei
 * @since 2020-07-28 17:31:41
 */
@RestController
@Api(value = "DataModelApi", tags = "$tool.trim($!{tableInfo.comment})服务")
@RequestMapping(path = "dataModel", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DataModelController extends BaseEntityController<DataModel, DataModelDto> implements DataModelApi {
    /**
     * 数据模型服务对象
     */
    @Autowired
    private DataModelService service;

    @Override
    public BaseEntityService<DataModel> getService() {
        return service;
    }

}