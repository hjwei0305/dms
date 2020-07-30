package com.changhong.sei.mdms.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.BaseTreeApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.mdms.dto.DataModelTypeDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 数据模型分类(DataModelType)API
 *
 * @author sei
 * @since 2020-07-28 23:24:00
 */
@Valid
@FeignClient(name = "mdms", path = "dataModelType")
public interface DataModelTypeApi extends BaseEntityApi<DataModelTypeDto>, BaseTreeApi<DataModelTypeDto> {

}