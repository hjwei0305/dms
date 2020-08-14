package com.changhong.sei.mdms.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.mdms.dto.ColumnDto;
import com.changhong.sei.mdms.dto.MasterDataRegisterRequest;
import com.changhong.sei.mdms.dto.MasterDataUiConfigDto;
import com.changhong.sei.mdms.dto.TableDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * 主数据管理API
 *
 * @author sei
 * @since 2020-08-13 22:47:19
 */
@Valid
@FeignClient(name = "mdms", path = "masterData")
public interface MasterDataManageApi {

    /**
     * 获取当前数据库所有的表
     */
    @GetMapping(path = "getAllMasterData")
    @ApiOperation(value = "获取当前数据库所有的表", notes = "获取当前数据库所有的表")
    ResultData<List<TableDto>> getAllMasterData();

    /**
     * 获取指定表字段信息
     *
     * @param code 主数据代码
     * @return 返回指定表字段清单
     */
    @GetMapping(path = "getPropertiesByCode")
    @ApiOperation(value = "获取指定表字段信息", notes = "获取指定表字段信息")
    ResultData<List<ColumnDto>> getPropertiesByCode(@RequestParam("code") String code);
}