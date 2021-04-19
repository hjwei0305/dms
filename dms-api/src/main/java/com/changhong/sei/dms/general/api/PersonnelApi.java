package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.dms.general.dto.LedgerAccountDto;
import com.changhong.sei.dms.general.dto.PersonnelDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 公司员工(ERP)(Personnel)API
 *
 * @author sei
 * @since 2021-04-19 10:53:34
 */
@Valid
@FeignClient(name = "dms", path = PersonnelApi.PATH)
public interface PersonnelApi extends BaseEntityApi<PersonnelDto>, FindByPageApi<PersonnelDto> {
    String PATH = "personnel";
}