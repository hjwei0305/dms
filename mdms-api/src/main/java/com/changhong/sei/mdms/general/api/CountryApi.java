package com.changhong.sei.mdms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindAllApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.mdms.commom.api.ImportExportDataApi;
import com.changhong.sei.mdms.general.dto.CountryDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * 国家(Country)API
 *
 * @author sei
 * @since 2020-08-17 14:03:21
 */
@Valid
@FeignClient(name = "mdms", path = "country")
public interface CountryApi extends BaseEntityApi<CountryDto>, FindByPageApi<CountryDto>, FindAllApi<CountryDto> {

    /**
     * 根据代码查询国家
     * @param code 代码
     * @return 国家信息
     */
    @GetMapping(path = "findByCode")
    @ApiOperation(value = "根据代码查询国家",notes = "根据代码查询国家")
    ResultData<CountryDto> findByCode(@RequestParam("code") String code);
}