package com.changhong.sei.mdms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.mdms.general.api.CurrencyApi;
import com.changhong.sei.mdms.general.dto.CountryDto;
import com.changhong.sei.mdms.general.dto.CurrencyDto;
import com.changhong.sei.mdms.general.entity.Currency;
import com.changhong.sei.mdms.general.service.CurrencyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 币种(Currency)控制类
 *
 * @author sei
 * @since 2020-08-17 14:02:46
 */
@RestController
@Api(value = "CurrencyApi", tags = "币种服务")
@RequestMapping(path = "currency", produces = MediaType.APPLICATION_JSON_VALUE)
public class CurrencyController extends BaseEntityController<Currency, CurrencyDto> implements CurrencyApi {
    /**
     * 币种服务对象
     */
    @Autowired
    private CurrencyService service;

    @Override
    public BaseEntityService<Currency> getService() {
        return service;
    }

    /**
     * 获取所有业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<CurrencyDto>> findAll() {
        return ResultData.success(convertToDtos(service.findAll()));
    }

    /**
     * 获取所有未冻结的业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<CurrencyDto>> findAllUnfrozen() {
        return ResultData.success(convertToDtos(service.findAllUnfrozen()));
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<CurrencyDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }
}