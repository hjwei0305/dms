package com.changhong.sei.mdms.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.mdms.dto.MasterDataRegisterRequest;
import com.changhong.sei.mdms.dto.MasterDataUiConfigDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * 主数据UI配置(MasterDataUiConfig)API
 *
 * @author sei
 * @since 2020-08-13 22:47:19
 */
@Valid
@FeignClient(name = "mdms", path = "masterDataUiConfig")
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
}