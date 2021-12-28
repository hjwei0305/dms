package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.dms.general.dto.ExchangeRateDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * 汇率(ExchangeRate)API
 *
 * @author sei
 * @since 2021-05-06 17:04:29
 */
@Valid
@FeignClient(name = "dms", path = ExchangeRateApi.PATH)
public interface ExchangeRateApi extends BaseEntityApi<ExchangeRateDto>, FindByPageApi<ExchangeRateDto> {
    String PATH = "exchangeRate";

    /**
     * 根据币种获取当前有效的汇率
     *
     * @param fromCurrency 来源币种
     * @param toCurrency   目标币种
     * @return 汇率
     */

    @GetMapping(path = "getValidExchangeRate")
    @ApiOperation(value = "根据币种获取当前有效的汇率", notes = "根据币种获取当前有效的汇率")
    ResultData<ExchangeRateDto> getValidExchangeRate(@RequestParam("fromCurrency") String fromCurrency, @RequestParam("toCurrency") String toCurrency);
}