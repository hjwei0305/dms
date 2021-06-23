package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindAllApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.dms.general.dto.TaxTypeDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 税分类(TaxType)API
 *
 * @author 杨沄炜
 * @since 2021/06/23 9:12
 */
@Valid
@FeignClient(name = "dms", path = TaxTypeApi.PATH)
public interface TaxTypeApi extends BaseEntityApi<TaxTypeDto>, FindByPageApi<TaxTypeDto>, FindAllApi<TaxTypeDto> {
    String PATH = "taxType";
}