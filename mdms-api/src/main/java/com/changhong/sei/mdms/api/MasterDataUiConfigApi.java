package com.changhong.sei.mdms.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.mdms.dto.CodeNameDto;
import com.changhong.sei.mdms.dto.EntityDto;
import com.changhong.sei.mdms.dto.MasterDataRegisterDto;
import com.changhong.sei.mdms.dto.MasterDataUiConfigDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 主数据UI配置(MasterDataUiConfig)API
 *
 * @author sei
 * @since 2020-08-13 22:47:19
 */
@Valid
@FeignClient(name = "mdms", path = "config")
public interface MasterDataUiConfigApi extends BaseEntityApi<MasterDataUiConfigDto> {

    /**
     * 主数据注册
     *
     * @PARAM REQUEST 主数据注册请求
     * @RETURN 操作结果
     */
    @PostMapping(path = "register", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "主数据注册", notes = "注册一个主数据")
    ResultData<String> register(@RequestBody @Valid MasterDataRegisterDto request);

    /**
     * 取消主数据注册
     *
     * @param id 取消主数据注册请求id
     * @return 操作结果
     */
    @PostMapping(path = "unregister/{id}")
    @ApiOperation(value = "取消主数据注册", notes = "取消主数据注册")
    ResultData<String> unregister(@PathVariable("id") String id);

    /**
     * 获取指定主数据分类获取注册的主数据
     *
     * @param typeCode 分类代码
     * @return 返回注册的主数据
     */
    @GetMapping(path = "getRegisterDataByTypeCode")
    @ApiOperation(value = "获取指定主数据分类获取注册的主数据", notes = "获取指定主数据分类获取注册的主数据")
    ResultData<List<MasterDataRegisterDto>> getRegisterDataByTypeCode(@RequestParam("typeCode") String typeCode);

    /**
     * 获取指定分类的主数据UI配置
     *
     * @param typeCode 分类代码
     * @return 返回指定主数据的UI配置
     */
    @GetMapping(path = "getConfigByTypeCode")
    @ApiOperation(value = "获取指定分类的主数据UI配置", notes = "获取指定分类的主数据UI配置")
    ResultData<List<MasterDataUiConfigDto>> getConfigByTypeCode(@RequestParam("typeCode") String typeCode);

    /**
     * 获取指定主数据的UI配置
     *
     * @param code 代码
     * @return 返回指定主数据的UI配置
     */
    @GetMapping(path = "getConfigByCode")
    @ApiOperation(value = "获取指定主数据的UI配置", notes = "获取指定主数据的UI配置")
    ResultData<MasterDataUiConfigDto> getConfigByCode(@RequestParam("code") String code);

    /**
     * 获取当前所有主数据
     */
    @GetMapping(path = "getAllMasterData")
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
    ResultData<List<CodeNameDto>> getPropertiesByCode(@RequestParam("code") String code);
}