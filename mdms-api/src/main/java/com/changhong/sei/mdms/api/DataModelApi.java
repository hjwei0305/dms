package com.changhong.sei.mdms.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.mdms.dto.DataModelDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 数据模型(DataModel)API
 *
 * @author sei
 * @since 2020-07-28 17:32:34
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "mdms", path = "dataModel")
public interface DataModelApi extends BaseEntityApi<DataModelDto> {

}