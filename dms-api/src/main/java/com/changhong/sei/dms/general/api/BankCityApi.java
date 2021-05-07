package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.dms.general.dto.BankCityDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 银行城市(BankCity)API
 *
 * @author sei
 * @since 2021-05-07 15:13:26
 */
@Valid
@FeignClient(name = "dms", path = BankCityApi.PATH)
public interface BankCityApi extends BaseEntityApi<BankCityDto>, FindByPageApi<BankCityDto> {
    String PATH = "bankCity";
}