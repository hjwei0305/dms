package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.api.UnitApi;
import com.changhong.sei.dms.general.dto.UnitDto;
import com.changhong.sei.dms.general.entity.Unit;
import com.changhong.sei.dms.general.service.UnitService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 刘松林
 * @Contact: songlin.liu@changhong.com
 * @Date: 2020/3/12 15:33
 * @Description: 计量单位
 */
@RestController
@Api(value = "unit", tags = "计量单位API服务实现")
@RequestMapping(path = "unit", produces = MediaType.APPLICATION_JSON_VALUE)
public class UnitController extends BaseEntityController<Unit, UnitDto> implements UnitApi {
    @Autowired
    private UnitService service;

    @Override
    public BaseEntityService<Unit> getService() {
        return service;
    }

    /**
     * 获取所有业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<UnitDto>> findAll() {
        return ResultData.success(convertToDtos(service.findAll()));
    }

    /**
     * 获取所有未冻结的业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<UnitDto>> findAllUnfrozen() {
        return ResultData.success(convertToDtos(service.findAllUnfrozen()));
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<UnitDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }
}
