package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindAllApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.dms.general.dto.CashFlowCodeDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 实现功能:
 *
 * @author 冯华
 * @create 2021-04-16 10:13
 */
@Valid
@FeignClient(name = "dms", path = "cashFlowCode")
public interface CashFlowCodeApi extends BaseEntityApi<CashFlowCodeDto>, FindByPageApi<CashFlowCodeDto>, FindAllApi<CashFlowCodeDto> {

}
