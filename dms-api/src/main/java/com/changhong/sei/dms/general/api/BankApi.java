package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.dms.general.dto.BankDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * 银行(Bank)API
 *
 * @author sei
 * @since 2021-06-25 11:10:12
 */
@Valid
@FeignClient(name = "dms", path = BankApi.PATH)
public interface BankApi extends BaseEntityApi<BankDto>, FindByPageApi<BankDto> {
    String PATH = "bank";

    /**
     * 获取一个银行
     * @param code 12为联行号
     * @return 银行
     */
    @GetMapping(path = "findByCode")
    @ApiOperation(value = "获取一个银行", notes = "通过12为联行号，获取一个银行主数据")
    ResultData<BankDto> findByCode(@RequestParam("code") String code);

    /**
     * 获取一个银行
     * @param name 行名
     * @return 银行
     */
    @GetMapping(path = "findByName")
    @ApiOperation(value = "获取一个银行", notes = "通过行名，获取一个银行主数据")
    ResultData<BankDto> findByName(@RequestParam("name") String name);
}