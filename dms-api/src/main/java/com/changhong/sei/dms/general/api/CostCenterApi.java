package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindAllApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.dms.general.dto.CashFlowCodeDto;
import com.changhong.sei.dms.general.dto.CostCenterDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 成本中心(CostCenter)API
 *
 * @author sei
 * @since 2021-04-16 11:18:11
 */
@Valid
@FeignClient(name = "dms", path = CostCenterApi.PATH)
public interface CostCenterApi extends BaseEntityApi<CostCenterDto>, FindByPageApi<CostCenterDto>, FindAllApi<CostCenterDto> {
    String PATH = "costCenter";
}