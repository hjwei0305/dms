package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindAllApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.dms.general.dto.CurrencyDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;

/**
 * 币种(Currency)API
 *
 * @author sei
 * @since 2020-08-17 14:03:30
 */
@Valid
@FeignClient(name = "dms", path = "currency")
public interface CurrencyApi extends BaseEntityApi<CurrencyDto>, FindByPageApi<CurrencyDto>, FindAllApi<CurrencyDto> {
    /**
     * 获取一个币种
     * @param code 代码
     * @return 币种
     */
    @GetMapping(path = "findByCode")
    @ApiOperation(value = "获取一个币种", notes = "通过币种代码，获取一个币种主数据")
    ResultData<CurrencyDto> findByCode(String code);
}