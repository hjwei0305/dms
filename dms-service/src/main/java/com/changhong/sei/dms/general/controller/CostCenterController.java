package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.api.CostCenterApi;
import com.changhong.sei.dms.general.dto.CostCenterDto;
import com.changhong.sei.dms.general.entity.CostCenter;
import com.changhong.sei.dms.general.service.CostCenterService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 成本中心(CostCenter)控制类
 *
 * @author sei
 * @since 2021-04-16 11:17:14
 */
@RestController
@Api(value = "CostCenterApi", tags = "成本中心服务")
@RequestMapping(path = CostCenterApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class CostCenterController extends BaseEntityController<CostCenter, CostCenterDto> implements CostCenterApi {
    /**
     * 成本中心服务对象
     */
    @Autowired
    private CostCenterService service;

    @Override
    public BaseEntityService<CostCenter> getService() {
        return service;
    }

    /**
     * 获取所有业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<CostCenterDto>> findAll() {
        return ResultData.success(convertToDtos(service.findAll()));
    }

    /**
     * 获取所有未冻结的业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<CostCenterDto>> findAllUnfrozen() {
        return ResultData.success(convertToDtos(service.findAllUnfrozen()));
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<CostCenterDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }
}