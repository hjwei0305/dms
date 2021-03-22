package com.changhong.sei.mdms.management.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.mdms.management.dto.DataConfigDto;
import com.changhong.sei.mdms.management.dto.DataDefinitionDto;
import com.changhong.sei.mdms.management.dto.EntityDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 主数据定义(MasterDataUiConfig)API
 *
 * @author sei
 * @since 2020-08-13 22:47:19
 */
@Valid
@FeignClient(name = "dms", path = "dataDefinition")
public interface DataDefinitionApi extends BaseEntityApi<DataDefinitionDto> {

    /**
     * 获取支持的数据结构
     */
    @GetMapping(path = "getDataStructure")
    @ApiOperation(value = "获取支持的数据结构", notes = "获取支持的数据结构")
    ResultData<Map<String, String>> getDataStructure();

    /**
     * 获取支持的配置类型
     */
    @GetMapping(path = "getConfigType")
    @ApiOperation(value = "获取支持的配置类型", notes = "获取支持的配置类型")
    ResultData<Map<String, String>> getConfigType();

    /**
     * 主数据注册
     *
     * @param request 主数据注册请求
     * @return 操作结果
     */
    @PostMapping(path = "register", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "主数据注册", notes = "注册一个主数据")
    ResultData<String> register(@RequestBody @Valid DataDefinitionDto request);

    /**
     * 冻结数据
     *
     * @param id id
     * @return 操作结果
     */
    @PostMapping(path = "frozen/{id}")
    @ApiOperation(value = "冻结数据", notes = "冻结数据")
    ResultData<String> frozen(@PathVariable("id") String id);

    /**
     * 解冻数据
     *
     * @param id id
     * @return 操作结果
     */
    @PostMapping(path = "unfrozen/{id}")
    @ApiOperation(value = "解冻数据", notes = "解冻数据")
    ResultData<String> unfrozen(@PathVariable("id") String id);

    /**
     * 分页查询注册的主数据
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @PostMapping(path = "getRegisterDataByPage", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "分页查询注册的主数据", notes = "分页查询注册的主数据")
    ResultData<PageResult<DataDefinitionDto>> getRegisterDataByPage(@RequestBody Search search);

    /**
     * 获取指定主数据分类获取注册的主数据
     *
     * @param categoryId 分类id
     * @param frozen     是否冻结
     * @return 返回注册的主数据
     */
    @GetMapping(path = "getRegisterDataByCategoryId")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "分类id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "frozen", value = "是否冻结.为空或不存则获取所有状态", paramType = "query")
    })
    @ApiOperation(value = "获取指定主数据分类获取注册的主数据", notes = "获取指定主数据分类获取注册的主数据")
    ResultData<List<DataDefinitionDto>> getRegisterDataByCategoryId(@RequestParam("categoryId") String categoryId,
                                                                    @RequestParam(name = "frozen", required = false) Boolean frozen);

    /**
     * 获取当前所有主数据
     */
    @GetMapping(path = "getAllData")
    @ApiOperation(value = "获取当前所有主数据", notes = "获取当前所有主数据")
    ResultData<List<EntityDto>> getAllMasterData();

    /**
     * 获取指定主数据的属性清单
     *
     * @param code 主数据代码
     * @return 返回指定表字段清单
     */
    @GetMapping(path = "getPropertiesByCode")
    @ApiOperation(value = "获取指定主数据的属性清单", notes = "获取指定主数据的属性清单")
    ResultData<List<EntityDto.Property>> getPropertiesByCode(@RequestParam("code") String code);

    /**
     * 获取指定主数据的UI配置
     *
     * @param id id
     * @return 返回指定主数据的UI配置
     */
    @GetMapping(path = "getConfigById")
    @ApiOperation(value = "获取指定主数据的UI配置", notes = "获取指定主数据的UI配置")
    ResultData<List<DataConfigDto>> getConfigById(@RequestParam("id") String id);

    /**
     * 保存主数据的UI配置
     *
     * @param configDto ui配置
     * @return 返回保存结果
     */
    @PostMapping(path = "saveConfig", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "保存主数据的UI配置", notes = "保存主数据的UI配置")
    ResultData<DataConfigDto> saveConfig(@RequestBody @Valid DataConfigDto configDto);
}