package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.api.CorporationProjectApi;
import com.changhong.sei.dms.general.dto.CorporationProjectDto;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import com.changhong.sei.dms.general.entity.CorporationProject;
import com.changhong.sei.dms.general.service.CorporationProjectService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公司项目(CorporationProject)控制类
 *
 * @author sei
 * @since 2021-07-31 16:02:42
 */
@RestController
@Api(value = "CorporationProjectApi", tags = "公司项目服务")
@RequestMapping(path = CorporationProjectApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class CorporationProjectController extends BaseEntityController<CorporationProject, CorporationProjectDto> implements CorporationProjectApi {
    /**
     * 公司项目服务对象
     */
    @Autowired
    private CorporationProjectService service;

    @Override
    public BaseEntityService<CorporationProject> getService() {
        return service;
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<CorporationProjectDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }
}