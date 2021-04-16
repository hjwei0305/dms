package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.api.CashFlowCodeApi;
import com.changhong.sei.dms.general.dto.CashFlowCodeDto;
import com.changhong.sei.dms.general.entity.CashFlowCode;
import com.changhong.sei.dms.general.service.CashFlowCodeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 实现功能:  现金流代码(CashFlowCode)控制类
 *
 * @author 冯华
 * @create 2021-04-16 10:29
 */
@RestController
@Api(value = "CashFlowCodeApi", tags = "现金流代码服务")
@RequestMapping(path = "cashFlowCode", produces = MediaType.APPLICATION_JSON_VALUE)
public class CashFlowCodeController extends BaseEntityController<CashFlowCode, CashFlowCodeDto> implements CashFlowCodeApi {
    @Autowired
    private CashFlowCodeService service;

    /**
     * 获取使用的业务逻辑实现
     *
     * @return 业务逻辑
     */
    @Override
    public BaseEntityService<CashFlowCode> getService() {
        return service;
    }


    /**
     * 获取所有业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<CashFlowCodeDto>> findAll() {
        return ResultData.success(convertToDtos(service.findAll()));
    }

    /**
     * 获取所有未冻结的业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<CashFlowCodeDto>> findAllUnfrozen() {
        return ResultData.success(convertToDtos(service.findAllUnfrozen()));
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<CashFlowCodeDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }
}
