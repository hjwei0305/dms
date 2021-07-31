package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.dms.general.dto.ProfitCenterDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 利润中心(ProfitCenter)API
 *
 * @author sei
 * @since 2021-07-30 14:59:18
 */
@Valid
@FeignClient(name = "dms", path = ProfitCenterApi.PATH)
public interface ProfitCenterApi extends BaseEntityApi<ProfitCenterDto> {
    String PATH = "profitCenter";
}