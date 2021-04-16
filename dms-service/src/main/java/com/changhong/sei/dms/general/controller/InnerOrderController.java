package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.api.InnerOrderApi;
import com.changhong.sei.dms.general.dto.CostCenterDto;
import com.changhong.sei.dms.general.dto.InnerOrderDto;
import com.changhong.sei.dms.general.entity.InnerOrder;
import com.changhong.sei.dms.general.service.InnerOrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 内部订单(InnerOrder)控制类
 *
 * @author sei
 * @since 2021-04-16 14:19:34
 */
@RestController
@Api(value = "InnerOrderApi", tags = "内部订单服务")
@RequestMapping(path = InnerOrderApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class InnerOrderController extends BaseEntityController<InnerOrder, InnerOrderDto> implements InnerOrderApi {
    /**
     * 内部订单服务对象
     */
    @Autowired
    private InnerOrderService service;

    @Override
    public BaseEntityService<InnerOrder> getService() {
        return service;
    }

    /**
     * 获取所有业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<InnerOrderDto>> findAll() {
        return ResultData.success(convertToDtos(service.findAll()));
    }

    /**
     * 获取所有未冻结的业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<InnerOrderDto>> findAllUnfrozen() {
        return ResultData.success(convertToDtos(service.findAllUnfrozen()));
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<InnerOrderDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }

}