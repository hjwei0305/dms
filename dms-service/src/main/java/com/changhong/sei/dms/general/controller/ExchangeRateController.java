package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.ResponseData;
import com.changhong.sei.core.utils.ResultDataUtil;
import com.changhong.sei.dms.general.api.ExchangeRateApi;
import com.changhong.sei.dms.general.dto.ExchangeRateDto;
import com.changhong.sei.dms.general.entity.ExchangeRate;
import com.changhong.sei.dms.general.service.ExchangeRateService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 汇率(ExchangeRate)控制类
 *
 * @author sei
 * @since 2021-05-06 17:04:04
 */
@RestController
@Api(value = "ExchangeRateApi", tags = "汇率服务")
@RequestMapping(path = ExchangeRateApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class ExchangeRateController extends BaseEntityController<ExchangeRate, ExchangeRateDto> implements ExchangeRateApi {
    /**
     * 汇率服务对象
     */
    @Autowired
    private ExchangeRateService service;

    @Override
    public BaseEntityService<ExchangeRate> getService() {
        return service;
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<ExchangeRateDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }

    /**
     * 根据币种获取当前有效的汇率
     *
     * @param fromCurrency 来源币种
     * @param toCurrency   目标币种
     */
    @Override
    public ResultData<ExchangeRateDto> getValidExchangeRate(String fromCurrency, String toCurrency) {
        ResponseData<ExchangeRate> responseData = service.getValidExchangeRate(fromCurrency, toCurrency);
        return ResultDataUtil.convertFromResponseData(responseData, convertToDto(responseData.getData()));
    }
}