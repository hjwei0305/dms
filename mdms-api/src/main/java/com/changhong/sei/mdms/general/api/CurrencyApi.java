package com.changhong.sei.mdms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.mdms.general.dto.CurrencyDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 币种(Currency)API
 *
 * @author sei
 * @since 2020-08-17 14:03:30
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "mdms", path = "currency")
public interface CurrencyApi extends BaseEntityApi<CurrencyDto> {

}