package com.changhong.sei.mdms.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.mdms.api.DataSourceApi;
import com.changhong.sei.mdms.dto.DBType;
import com.changhong.sei.mdms.dto.DBTypeDto;
import com.changhong.sei.mdms.dto.DataSourceDto;
import com.changhong.sei.mdms.entity.DataSource;
import com.changhong.sei.mdms.service.DataSourceService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据源(DataSource)控制类
 *
 * @author sei
 * @since 2020-07-28 23:24:27
 */
@RestController
@Api(value = "DataSourceApi", tags = "数据源服务")
@RequestMapping(path = "dataSource", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DataSourceController extends BaseEntityController<DataSource, DataSourceDto> implements DataSourceApi {
    /**
     * 数据源服务对象
     */
    @Autowired
    private DataSourceService service;

    @Override
    public BaseEntityService<DataSource> getService() {
        return service;
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<DataSourceDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }

    /**
     * 获取所有支持的数据库类型
     */
    @Override
    public ResultData<List<DBTypeDto>> getDBTypes() {
        List<DBTypeDto> dtos = new ArrayList<>();
        for (DBType type : DBType.values()) {
            dtos.add(new DBTypeDto(type));
        }
        return ResultData.success(dtos);
    }
}