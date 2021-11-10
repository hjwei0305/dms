package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindAllApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.dms.general.dto.TaxRateTypeCodeDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * 税收分类编码(TaxRateTypeCode)API
 *
 * @author sei
 * @since 2021-11-10 14:20:07
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "rcsit-prc", path = TaxRateTypeCodeApi.PATH)
public interface TaxRateTypeCodeApi extends BaseEntityApi<TaxRateTypeCodeDto>, FindByPageApi<TaxRateTypeCodeDto>, FindAllApi<TaxRateTypeCodeDto> {
    String PATH = "taxRateTypeCode";

    @PostMapping("/getRootNode")
    @ApiOperation(value = "获取根节点列表")
    ResultData<List<TaxRateTypeCodeDto>> getRootNode();


    @PostMapping("/getNodeByPid")
    @ApiOperation(value = "获取根节点列表")
    ResultData<List<TaxRateTypeCodeDto>> getNodeByPid(String pid);

    @PostMapping("/getNodeByPrefix")
    @ApiOperation(value = "通过商品编码前缀获取节点列表")
    ResultData<List<TaxRateTypeCodeDto>> getNodeByPrefix(String prefixCode);
}