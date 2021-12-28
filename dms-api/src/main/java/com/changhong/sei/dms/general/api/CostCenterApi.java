package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.dms.general.dto.CostCenterDto;
import com.changhong.sei.dms.general.dto.ProfitCenterDto;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * 成本中心(CostCenter)API
 *
 * @author sei
 * @since 2021-04-16 11:18:11
 */
@Valid
@FeignClient(name = "dms", path = CostCenterApi.PATH)
public interface CostCenterApi extends BaseEntityApi<CostCenterDto>, FindByPageApi<CostCenterDto> {
    String PATH = "costCenter";

    /**
     * 根据代码查询成本中心
     * @param code 代码
     * @return 成本中心
     */
    @GetMapping(path = "findByCode")
    @ApiOperation(value = "根据代码查询成本中心", notes = "根据代码查询成本中心，当前租户")
    ResultData<CostCenterDto> findByCode(@RequestParam("code") String code);

    /**
     * 分页查询成本中心
     * @param searchParam 查询参数
     * @return 分页查询结果
     */
    @PostMapping(path = "search", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "分页查询成本中心", notes = "分页查询成本中心，限定ERP公司代码")
    ResultData<PageResult<CostCenterDto>> search(@RequestBody ErpCodeQuickSearchParam searchParam);
}