package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.api.BankCityApi;
import com.changhong.sei.dms.general.dto.BankCityDto;
import com.changhong.sei.dms.general.entity.BankCity;
import com.changhong.sei.dms.general.service.BankCityService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 银行城市(BankCity)控制类
 *
 * @author sei
 * @since 2021-05-07 15:13:02
 */
@RestController
@Api(value = "BankCityApi", tags = "银行城市服务")
@RequestMapping(path = BankCityApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class BankCityController extends BaseEntityController<BankCity, BankCityDto> implements BankCityApi {
    /**
     * 银行城市服务对象
     */
    @Autowired
    private BankCityService service;

    @Override
    public BaseEntityService<BankCity> getService() {
        return service;
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<BankCityDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }
}