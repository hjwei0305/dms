package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.dms.general.dto.CostCenterDto;
import com.changhong.sei.dms.general.dto.HrOrganizationDto;
import com.changhong.sei.dms.general.dto.WbsProjectDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

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
     * 获取WBS项目树（含冻结）
     */
    @GetMapping(path = "getAllTree")
    @ApiOperation(value = "获取WBS项目树（含冻结）", notes = "获取WBS项目树（含冻结）")
    List<WbsProjectDto> getAllTree();

    /**
     * 获取未冻结的WBS项目树
     */
    @GetMapping(path = "getUnfrozenTree")
    @ApiOperation(value = "获取未冻结的WBS项目树", notes = "获取未冻结的WBS项目树")
    List<WbsProjectDto> getUnfrozenTree();
}