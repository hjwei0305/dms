package com.changhong.sei.mdms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.mdms.general.dto.CountryDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 国家(Country)API
 *
 * @author sei
 * @since 2020-08-17 14:03:21
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "mdms", path = "country")
public interface CountryApi extends BaseEntityApi<CountryDto>, FindByPageApi<CountryDto> {

}