package com.changhong.sei.dms.general.api;


import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.dms.general.dto.CorporationProjectDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 公司项目(CorporationProject)API
 *
 * @author sei
 * @since 2021-07-31 16:02:22
 */
@Valid
@FeignClient(name = "dms", path = CorporationProjectApi.PATH)
public interface CorporationProjectApi extends BaseEntityApi<CorporationProjectDto>, FindByPageApi<CorporationProjectDto> {
    String PATH = "corporationProject";
}