package com.changhong.sei.mdms.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.mdms.dto.CodeNameDto;
import com.changhong.sei.mdms.dto.MasterDataRegisterRequest;
import com.changhong.sei.mdms.dto.MasterDataUiConfigDto;
import com.changhong.sei.mdms.dto.EntityDto;
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
     * @param request 主数据注册请求
     * @return 操作结果
     */
    @PostMapping(path = "register", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "主数据注册", notes = "注册一个主数据")
    ResultData<String> register(@RequestBody @Valid MasterDataRegisterRequest request);

    /**
     * 获取指定主数据的UI配置
     *
     * @param typeCode 分类代码
     * @return 返回指定主数据的UI配置
     */
    @GetMapping(path = "getConfigByTypeCode")
    @ApiOperation(value = "获取指定主数据的UI配置", notes = "获取指定主数据的UI配置")
    ResultData<List<MasterDataUiConfigDto>> getConfigByTypeCode(@RequestParam("typeCode") String typeCode);

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