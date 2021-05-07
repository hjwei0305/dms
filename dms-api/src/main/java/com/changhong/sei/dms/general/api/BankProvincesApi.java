package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.dms.general.dto.BankProvincesDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 银行省区(BankProvinces)API
 *
 * @author sei
 * @since 2021-05-07 14:35:01
 */
@Valid
@FeignClient(name = "dms", path = BankProvincesApi.PATH)
public interface BankProvincesApi extends BaseEntityApi<BankProvincesDto>, FindByPageApi<BankProvincesDto> {
    String PATH = "bankProvinces";
}