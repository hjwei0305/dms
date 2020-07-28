package com.changhong.sei.mdms.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.mdms.dto.DataTypeDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 数据类型(DataType)API
 *
 * @author sei
 * @since 2020-07-28 23:24:03
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "mdms", path = "dataType")
public interface DataTypeApi extends BaseEntityApi<DataTypeDto> {

}