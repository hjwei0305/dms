package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.dms.general.dto.HrOrganizationDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * HR组织机构(ERP)(HrOrganization)API
 *
 * @author sei
 * @since 2021-04-19 14:59:28
 */
@Valid
@FeignClient(name = "dms", path = HrOrganizationApi.PATH)
public interface HrOrganizationApi extends BaseEntityApi<HrOrganizationDto>, FindByPageApi<HrOrganizationDto> {
    String PATH = "hrOrganization";

    /**
     * 获取未冻结的HR组织机构树
     */
    @GetMapping(path = "getHrOrganizationTree")
    @ApiOperation(value = "获取未冻结的HR组织机构树", notes = "获取未冻结的HR组织机构树")
    List<HrOrganizationDto> getUnfrozenTree();

    /**
     * 添加映射关系
     *
     * @param id             HR组织机构Id
     * @param organizationId 组织机构Id
     * @return 操作结果
     */
    @PostMapping(path = "insertRelation", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "添加映射关系", notes = "添加HR组织机构与平台组织机构的映射关系")
    ResultData<HrOrganizationDto> insertRelation(@RequestParam("id") String id
            , @RequestParam("organizationId") String organizationId);

    /**
     * 移除映射关系
     *
     * @param id HR组织机构Id
     * @return 操作结果
     */
    @PostMapping(path = "removeRelation", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "移除映射关系", notes = "移除HR组织机构的映射关系")
    ResultData<HrOrganizationDto> removeRelation(@RequestParam("id") String id);
}