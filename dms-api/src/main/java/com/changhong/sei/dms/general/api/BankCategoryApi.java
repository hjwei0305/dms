package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.dms.general.dto.BankCategoryDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 银行类别(BankCategory)API
 *
 * @author sei
 * @since 2021-05-07 11:29:16
 */
@Valid
@FeignClient(name = "dms", path = BankCategoryApi.PATH)
public interface BankCategoryApi extends BaseEntityApi<BankCategoryDto>, FindByPageApi<BankCategoryDto> {
    String PATH = "bankCategory";
}