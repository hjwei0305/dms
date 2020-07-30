package com.changhong.sei.mdms.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.mdms.dto.DataModelDto;
import com.changhong.sei.mdms.dto.DataModelFieldDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * 数据模型(DataModel)API
 *
 * @author sei
 * @since 2020-07-28 23:23:50
 */
@Valid
@FeignClient(name = "mdms", path = "dataModel")
public interface DataModelApi extends BaseEntityApi<DataModelDto>, FindByPageApi<DataModelDto> {

    /**
     * 根据数据模型id获取模型字段清单
     *
     * @param modelId 数据模型id
     * @return 返回自定的模型字段清单
     */
    @GetMapping(path = "getDataModelFields")
    @ApiOperation(value = "根据数据模型id获取模型字段清单", notes = "根据数据模型id获取模型字段清单")
    ResultData<List<DataModelFieldDto>> getDataModelFields(@RequestParam("modelId") String modelId);

    /**
     * 添加默认审计字段
     *
     * @param modelId 数据模型id
     * @return 返回操作结果
     */
    @PostMapping(path = "addAuditFields")
    @ApiOperation(value = "根据数据模型id获取模型字段清单", notes = "根据数据模型id获取模型字段清单")
    ResultData<Void> addAuditFields(@RequestParam("modelId") String modelId);

    /**
     * 添加数据模型字段
     *
     * @param fieldDtos 数据模型字段dto
     * @return 返回操作结果
     */
    @PostMapping(path = "saveModelFields")
    @ApiOperation(value = "添加数据模型字段", notes = "添加数据模型字段")
    ResultData<Void> saveModelFields(List<DataModelFieldDto> fieldDtos);

    /**
     * 删除数据模型字段
     *
     * @param fieldIds 删除的数据模型字段id清单
     * @return 返回操作结果
     */
    @PostMapping(path = "deleteModelFields")
    @ApiOperation(value = "删除数据模型字段", notes = "删除数据模型字段")
    ResultData<Void> deleteModelFields(List<String> fieldIds);
}