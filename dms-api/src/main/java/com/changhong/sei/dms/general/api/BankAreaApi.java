package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.dms.general.dto.BankAreaDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 银行地区(BankArea)API
 *
 * @author sei
 * @since 2021-05-07 15:55:30
 */
@Valid
@FeignClient(name = "dms", path = BankAreaApi.PATH)
public interface BankAreaApi extends BaseEntityApi<BankAreaDto>, FindByPageApi<BankAreaDto> {
    String PATH = "bankArea";
}