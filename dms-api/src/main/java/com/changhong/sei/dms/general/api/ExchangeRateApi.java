package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.dms.general.dto.ExchangeRateDto;
import org.springframework.cloud.openfeign.FeignClient;

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
}