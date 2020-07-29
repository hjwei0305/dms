package com.changhong.sei.mdms.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.mdms.dto.DataModelFieldDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 模型字段(DataModelField)API
 *
 * @author sei
 * @since 2020-07-28 23:23:51
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "mdms", path = "dataModelField")
public interface DataModelFieldApi extends BaseEntityApi<DataModelFieldDto>, FindByPageApi<DataModelFieldDto> {

}