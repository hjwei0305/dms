package com.changhong.sei.mdms.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.mdms.api.DataModelFieldApi;
import com.changhong.sei.mdms.dto.DataModelFieldDto;
import com.changhong.sei.mdms.entity.DataModelField;
import com.changhong.sei.mdms.service.DataModelFieldService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模型字段(DataModelField)控制类
 *
 * @author sei
 * @since 2020-07-28 23:24:24
 */
@RestController
@Api(value = "DataModelFieldApi", tags = "模型字段服务")
@RequestMapping(path = "dataModelField", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DataModelFieldController extends BaseEntityController<DataModelField, DataModelFieldDto> implements DataModelFieldApi {
    /**
     * 模型字段服务对象
     */
    @Autowired
    private DataModelFieldService service;

    @Override
    public BaseEntityService<DataModelField> getService() {
        return service;
    }

}