package com.changhong.sei.mdms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.mdms.general.api.RegionApi;
import com.changhong.sei.mdms.general.dto.RegionDto;
import com.changhong.sei.mdms.general.entity.Region;
import com.changhong.sei.mdms.general.service.RegionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 行政区域(Region)控制类
 *
 * @author sei
 * @since 2020-08-17 14:02:48
 */
@RestController
@Api(value = "RegionApi", tags = "行政区域服务")
@RequestMapping(path = "region", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RegionController extends BaseEntityController<Region, RegionDto> implements RegionApi {
    /**
     * 行政区域服务对象
     */
    @Autowired
    private RegionService service;

    @Override
    public BaseEntityService<Region> getService() {
        return service;
    }

}