package com.changhong.sei.mdms.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.mdms.dto.ElementLabelDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 元素标签关系(ElementLabel)API
 *
 * @author sei
 * @since 2020-07-28 17:34:23
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "mdms", path = "elementLabel")
public interface ElementLabelApi extends BaseEntityApi<ElementLabelDto> {

}