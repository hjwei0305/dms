package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.dms.general.dto.ProfitCenterDto;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * 利润中心(ProfitCenter)API
 *
 * @author sei
 * @since 2021-07-30 14:59:18
 */
@Valid
@FeignClient(name = "dms", path = ProfitCenterApi.PATH)
public interface ProfitCenterApi extends BaseEntityApi<ProfitCenterDto>, FindByPageApi<ProfitCenterDto> {
    String PATH = "profitCenter";

    /**
     * 分页查询利润中心
     *
     * @param searchParam 查询参数
     * @return 分页查询结果
     */
    @PostMapping(path = "search", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "分页查询利润中心", notes = "分页查询利润中心，限定ERP公司代码")
    ResultData<PageResult<ProfitCenterDto>> search(@RequestBody ErpCodeQuickSearchParam searchParam);
}