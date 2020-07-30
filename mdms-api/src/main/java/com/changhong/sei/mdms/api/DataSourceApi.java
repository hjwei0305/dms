package com.changhong.sei.mdms.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.mdms.dto.DBTypeDto;
import com.changhong.sei.mdms.dto.DataSourceDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * 数据源(DataSource)API
 *
 * @author sei
 * @since 2020-07-28 23:24:02
 */
@Valid
@FeignClient(name = "mdms", path = "dataSource")
public interface DataSourceApi extends BaseEntityApi<DataSourceDto>, FindByPageApi<DataSourceDto> {

    /**
     * 获取所有支持的数据库类型
     */
    @GetMapping(path = "getDBTypes")
    @ApiOperation(value = "获取所有支持的数据库类型", notes = "获取所有支持的数据库类型")
    ResultData<List<DBTypeDto>> getDBTypes();
}