package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.dms.general.dto.CostCenterDto;
import com.changhong.sei.dms.general.dto.HrOrganizationDto;
import com.changhong.sei.dms.general.dto.WbsProjectDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * WBS项目(WbsProject)API
 *
 * @author sei
 * @since 2021-04-19 17:00:16
 */
@Valid
@FeignClient(name = "dms", path = WbsProjectApi.PATH)
public interface WbsProjectApi extends BaseEntityApi<WbsProjectDto>, FindByPageApi<WbsProjectDto> {
    String PATH = "wbsProject";

    /**
     * 根据ERP公司代码获取WBS项目树（含冻结）
     */
    @GetMapping(path = "getAllTree")
    @ApiOperation(value = "根据ERP公司代码获取WBS项目树（含冻结）", notes = "根据ERP公司代码获取WBS项目树（含冻结）")
    ResultData<List<WbsProjectDto>> getAllTree(@RequestParam("erpCorporationCode") String erpCorporationCode);

    /**
     * 根据ERP公司代码获取未冻结的WBS项目树
     */
    @GetMapping(path = "getUnfrozenTree")
    @ApiOperation(value = "根据ERP公司代码获取未冻结的WBS项目树", notes = "根据ERP公司代码获取未冻结的WBS项目树")
    ResultData<List<WbsProjectDto>> getUnfrozenTree(@RequestParam("erpCorporationCode") String erpCorporationCode);
}