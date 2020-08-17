package com.changhong.sei.mdms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.mdms.general.dto.RegionDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 行政区域(Region)API
 *
 * @author sei
 * @since 2020-08-17 14:03:33
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "mdms", path = "region")
public interface RegionApi extends BaseEntityApi<RegionDto> {

}