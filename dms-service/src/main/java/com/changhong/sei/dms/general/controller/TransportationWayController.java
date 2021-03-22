package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.api.TransportationWayApi;
import com.changhong.sei.dms.general.dto.TransportationWayDto;
import com.changhong.sei.dms.general.entity.TransportationWay;
import com.changhong.sei.dms.general.service.TransportationWayService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 刘松林
 * @Contact: songlin.liu@changhong.com
 * @Date: 2020/3/12 16:04
 * @Description:运输方式
 */
@RestController
@Api(value = "transportationWay", tags = "运输方式API服务实现")
@RequestMapping(path = "transportationWay", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransportationWayController extends BaseEntityController<TransportationWay, TransportationWayDto>
        implements TransportationWayApi {
    @Autowired
    private TransportationWayService service;

    @Override
    public BaseEntityService<TransportationWay> getService() {
        return service;
    }

    /**
     * 获取所有业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<TransportationWayDto>> findAll() {
        return ResultData.success(convertToDtos(service.findAll()));
    }

    /**
     * 获取所有未冻结的业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<TransportationWayDto>> findAllUnfrozen() {
        return ResultData.success(convertToDtos(service.findAllUnfrozen()));
    }
}
