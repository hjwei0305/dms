package com.changhong.sei.mdms.controller;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.log.LogUtil;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.mdms.api.DataSourceApi;
import com.changhong.sei.mdms.dto.DBType;
import com.changhong.sei.mdms.dto.DBTypeDto;
import com.changhong.sei.mdms.dto.DataSourceDto;
import com.changhong.sei.mdms.entity.DataSource;
import com.changhong.sei.mdms.service.DataSourceService;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
     * 保存业务实体
     *
     * @param dto 业务实体DTO
     * @return 操作结果
     */
    @Override
    public ResultData<DataSourceDto> save(DataSourceDto dto) {
        ResultData<String> checkResult = checkDto(dto);
        if (checkResult.failed()) {
            return ResultData.fail(checkResult.getMessage());
        }
        // 数据转换 to Entity
        DataSource entity = convertToEntity(dto);
        OperateResultWithData<DataSource> result;
        try {
            result = getService().save(entity);
        } catch (Exception e) {
            e.printStackTrace();
            // 捕获异常，并返回
            LogUtil.error("保存业务实体异常！", e);
            // 保存业务实体异常！{0}
            return ResultData.fail(ContextUtil.getMessage("core_service_00003", e.getMessage()));
        }
        if (result.notSuccessful()) {
            return ResultData.fail(result.getMessage());
        }
        // 数据转换 to DTO
        DataSourceDto resultData = convertToDto(result.getData());
        return ResultData.success(result.getMessage(), resultData);
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