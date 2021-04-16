package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.dms.general.dto.InnerOrderDto;
import com.changhong.sei.dms.general.dto.LedgerAccountCorporationDto;
import com.changhong.sei.dms.general.dto.LedgerAccountDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 总帐科目(LedgerAccount)API
 *
 * @author sei
 * @since 2021-04-16 16:16:43
 */
@Valid
@FeignClient(name = "dms", path = LedgerAccountApi.PATH)
public interface LedgerAccountApi extends BaseEntityApi<LedgerAccountDto>, FindByPageApi<LedgerAccountDto> {
    String PATH = "ledgerAccount";

    /**
     * 获取科目的公司信息
     *
     * @param ledgerAccountId 科目Id
     * @return 公司信息
     */
    @GetMapping(path = "getCorporationInfo")
    @ApiOperation(value = "获取科目的公司信息", notes = "获取科目的公司信息")
    ResultData<List<LedgerAccountCorporationDto>> getCorporationInfo(@RequestParam("ledgerAccountId") String ledgerAccountId);

    /**
     * 保存科目的公司信息
     *
     * @param dto 科目的公司信息DTO
     * @return 操作结果
     */
    @PostMapping(path = "saveCorporationInfo", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "保存科目的公司信息", notes = "保存科目的公司信息")
    ResultData<LedgerAccountCorporationDto> saveCorporationInfo(@RequestBody @Valid LedgerAccountCorporationDto dto);

    /**
     * 删除科目的公司信息
     *
     * @param id 科目的公司信息Id
     * @return 操作结果
     */
    @DeleteMapping(path = "deleteCorporationInfo/{id}")
    @ApiOperation(value = "删除科目的公司信息", notes = "删除科目的公司信息")
    ResultData<?> deleteCorporationInfo(@PathVariable("id") String id);

}