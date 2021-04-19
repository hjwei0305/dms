package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.api.WbsProjectApi;
import com.changhong.sei.dms.general.dto.WbsProjectDto;
import com.changhong.sei.dms.general.entity.WbsProject;
import com.changhong.sei.dms.general.service.WbsProjectService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * WBS项目(WbsProject)控制类
 *
 * @author sei
 * @since 2021-04-19 16:58:45
 */
@RestController
@Api(value = "WbsProjectApi", tags = "WBS项目服务")
@RequestMapping(path = WbsProjectApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class WbsProjectController extends BaseEntityController<WbsProject, WbsProjectDto> implements WbsProjectApi {
    /**
     * WBS项目服务对象
     */
    @Autowired
    private WbsProjectService service;

    @Override
    public BaseEntityService<WbsProject> getService() {
        return service;
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<WbsProjectDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }

    /**
     * 获取WBS项目树（含冻结）
     */
    @Override
    public List<WbsProjectDto> getAllTree() {
        return convertToDtos(service.getAllTree());
    }

    /**
     * 获取未冻结的WBS项目树
     */
    @Override
    public List<WbsProjectDto> getUnfrozenTree() {
        return convertToDtos(service.getUnfrozenTree());
    }
}