package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.dms.general.dto.BankDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 银行(Bank)API
 *
 * @author sei
 * @since 2021-06-25 11:10:12
 */
@Valid
@FeignClient(name = "dms", path = BankApi.PATH)
public interface BankApi extends BaseEntityApi<BankDto>, FindByPageApi<BankDto> {
    String PATH = "bank";
}