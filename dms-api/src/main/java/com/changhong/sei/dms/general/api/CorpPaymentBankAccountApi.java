package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.dms.general.dto.CorpPaymentBankAccountDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * 公司的付款银行账号信息(CorpPaymentBankAccount)API
 *
 * @author sei
 * @since 2021-07-01 16:09:48
 */
@Valid
@FeignClient(name = "dms", path = CorpPaymentBankAccountApi.PATH)
public interface CorpPaymentBankAccountApi extends BaseEntityApi<CorpPaymentBankAccountDto> {
    String PATH = "corpPaymentBankAccount";

    /**
     * 根据公司代码查询付款银行账号信息
     *
     * @param corporationCode 公司代码
     * @return 付款银行账号信息
     */
    @GetMapping(path = "findByCorp")
    @ApiOperation(value = "根据公司代码查询付款银行账号信息", notes = "根据公司代码查询付款银行账号信息")
    ResultData<List<CorpPaymentBankAccountDto>> findByCorp(@RequestParam("corporationCode") String corporationCode);

    /**
     * 根据公司代码和币种获取付款银行账号信息
     *
     * @param corporationCode 公司代码
     * @param currencyCode    币种
     * @return 科目映射付款方信息清单
     */
    @GetMapping(path = "findByCorpAndCurrency")
    @ApiOperation(value = "根据公司代码和币种获取付款银行账号信息", notes = "根据公司代码和币种获取付款银行账号信息")
    ResultData<List<CorpPaymentBankAccountDto>> findByCorpAndCurrency(@RequestParam("corporationCode") String corporationCode,
                                                                      @RequestParam("currencyCode") String currencyCode);

    /**
     * 根据公司代码和币种获取默认的付款银行账号信息
     *
     * @param corporationCode 公司代码
     * @param currencyCode    币种
     * @return 付款方信息
     */
    @GetMapping(path = "findDefaultByCorpAndCurrency")
    @ApiOperation(value = "根据公司代码和币种获取默认的付款银行账号信息", notes = "根据公司代码和币种获取默认的付款银行账号信息(获取默认，无默认获取第一个)")
    ResultData<CorpPaymentBankAccountDto> findDefaultByCorpAndCurrency(@RequestParam("corporationCode") String corporationCode,
                                                                       @RequestParam("currencyCode") String currencyCode);

    /**
     * 根据公司代码和银行行别代码获取付款银行账号信息
     *
     * @param corporationCode  公司代码
     * @param bankCategoryCode 银行行别代码
     * @return 科目映射付款方信息清单
     */
    @GetMapping(path = "findByCorpAndBankCategory")
    @ApiOperation(value = "根据公司代码和银行行别代码获取付款银行账号信息", notes = "根据公司代码和银行行别代码获取付款银行账号信息")
    ResultData<List<CorpPaymentBankAccountDto>> findByCorpAndBankCategory(@RequestParam("corporationCode") String corporationCode
            , @RequestParam("bankCategoryCode") String bankCategoryCode);


    /**
     * 设置默认
     *
     * @param id Id
     * @return 结果
     */
    @PostMapping(path = "setAsDefault/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "设置默认，同一公司下同一币种仅一条默认，替换原有默认数据", notes = "设置默认，同一公司下同一币种仅一条默认，替换原有默认数据")
    ResultData<?> setAsDefault(@PathVariable("id") String id);

    /**
     * 根据银行账号获取付款银行账号信息
     *
     * @param bankAccountNumber 银行账号
     * @return 付款方信息
     */
    @GetMapping(path = "findByBankAccountNumber")
    @ApiOperation(value = "根据银行账号获取付款银行账号信息", notes = "根据银行账号获取付款银行账号信息(当前租户下账号唯一)")
    ResultData<CorpPaymentBankAccountDto> findByBankAccountNumber(@RequestParam("bankAccountNumber") String bankAccountNumber);
}