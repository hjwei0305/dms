package com.changhong.sei.mdms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.mdms.general.api.CountryApi;
import com.changhong.sei.mdms.general.dto.CountryDto;
import com.changhong.sei.mdms.general.entity.Country;
import com.changhong.sei.mdms.general.service.CountryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 国家(Country)控制类
 *
 * @author sei
 * @since 2020-08-17 14:02:44
 */
@RestController
@Api(value = "CountryApi", tags = "国家服务")
@RequestMapping(path = "country", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CountryController extends BaseEntityController<Country, CountryDto> implements CountryApi {
    /**
     * 国家服务对象
     */
    @Autowired
    private CountryService service;

    @Override
    public BaseEntityService<Country> getService() {
        return service;
    }

}