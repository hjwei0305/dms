package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindAllApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.dms.general.dto.InnerOrderDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 内部订单(InnerOrder)API
 *
 * @author sei
 * @since 2021-04-16 14:20:24
 */
@Valid
@FeignClient(name = "dms", path = InnerOrderApi.PATH)
public interface InnerOrderApi extends BaseEntityApi<InnerOrderDto> , FindByPageApi<InnerOrderDto>, FindAllApi<InnerOrderDto> {
    String PATH = "innerOrder";
}