package com.changhong.sei.mdms.management.api;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.mdms.management.dto.AppDto;
import com.changhong.sei.mdms.management.dto.DataDefinitionDto;
import com.changhong.sei.mdms.management.dto.SubscriptionDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2021-02-22 11:10
 */
@Valid
@FeignClient(name = "dms", path = "appSubscription")
public interface AppSubscriptionApi {

    /**
     * 保存应用服务
     *
     * @param dto app DTO
     * @return 操作结果
     */
    @PostMapping(path = "saveApp", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "保存应用服务", notes = "保存应用服务")
    ResultData<AppDto> saveApp(@RequestBody @Valid AppDto dto);

//    /**
//     * 通过Id获取一个应用服务
//     *
//     * @param id AppId
//     * @return 业务实体
//     */
//    @GetMapping(path = "findOneApp")
//    @ApiOperation(value = "获取一个应用服务", notes = "通过Id获取一个应用服务")
//    ResultData<AppDto> findOne(@RequestParam("id") String id);

    /**
     * 分页查询应用服务
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @PostMapping(path = "findAppByPage", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "分页查询应用服务", notes = "分页查询应用服务")
    ResultData<PageResult<AppDto>> findByPage(@RequestBody Search search);

    /**
     * 获取未分配的数据清单
     *
     * @param appCode appCode
     * @return 子实体清单
     */
    @GetMapping(path = "getUnassigned")
    @ApiOperation(value = "获取未分配的数据清单", notes = "获取未分配的数据清单")
    ResultData<List<DataDefinitionDto>> getUnassignedChildren(@RequestParam("appCode") String appCode);

    /**
     * 通过appCode获取订阅数据清单
     *
     * @param appCode appCode
     * @return 订阅数据清单
     */
    @GetMapping(path = "getDataFromAppCode")
    @ApiOperation(value = "通过appCode获取订阅数据清单", notes = "通过appCode获取订阅数据清单")
    ResultData<List<SubscriptionDto>> getDataFromAppCode(@RequestParam("appCode") String appCode);

    /**
     * 保存应用与数据订阅关系
     *
     * @param subscriptionDto 分配关系参数
     * @return 操作结果
     */
    @PostMapping(path = "saveRelation")
    @ApiOperation(value = "保存应用与数据订阅关系", notes = "保存应用与数据订阅关系")
    ResultData<SubscriptionDto> saveRelation(@RequestBody SubscriptionDto subscriptionDto);

    /**
     * 移除分配关系
     *
     * @param subscriptionIds 分配关系参数
     * @return 操作结果
     */
    @DeleteMapping(path = "removeRelations")
    @ApiOperation(value = "移除分配关系", notes = "通过分配关系参数移除分配关系")
    ResultData<Void> removeRelations(@RequestBody Set<String> subscriptionIds);

}
