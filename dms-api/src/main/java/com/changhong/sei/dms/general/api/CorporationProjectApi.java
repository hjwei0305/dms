package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.dms.general.dto.CorporationProjectDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * 公司项目(CorporationProject)API
 *
 * @author sei
 * @since 2021-07-31 16:02:22
 */
@Valid
@FeignClient(name = "dms", path = CorporationProjectApi.PATH)
public interface CorporationProjectApi extends BaseEntityApi<CorporationProjectDto>, FindByPageApi<CorporationProjectDto> {
    String PATH = "corporationProject";

    /**
     * 按ERP公司代码查询项目
     *
     * @param erpCorpCode ERP公司代码
     * @return 项目清单
     */
    @GetMapping(path = "findByErpCode")
    @ApiOperation(value = "按ERP公司代码查询项目", notes = "按ERP公司代码查询项目")
    ResultData<List<CorporationProjectDto>> findByErpCode(@RequestParam("erpCorpCode") String erpCorpCode);
}