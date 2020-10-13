package com.changhong.sei.mdms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindAllApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.mdms.general.dto.CountryDto;
import com.changhong.sei.mdms.general.dto.CurrencyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * 币种(Currency)API
 *
 * @author sei
 * @since 2020-08-17 14:03:30
 */
@Valid
@FeignClient(name = "mdms", path = "currency")
public interface CurrencyApi extends BaseEntityApi<CurrencyDto>, FindByPageApi<CurrencyDto>, FindAllApi<CurrencyDto> {

}