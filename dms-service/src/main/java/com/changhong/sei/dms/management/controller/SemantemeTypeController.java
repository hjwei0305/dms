package com.changhong.sei.dms.management.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.management.api.SemantemeTypeApi;
import com.changhong.sei.dms.management.dto.SemantemeTypeDto;
import com.changhong.sei.dms.management.entity.SemantemeType;
import com.changhong.sei.dms.management.service.SemantemeTypeService;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 实现功能: 语义表API服务实现
 *
 * @author 王锦光 wangjg
 * @version 2020-03-22 8:04
 */
@RestController
@Api(value = "SemantemeTypeApi", tags = "语义表API服务实现")
@RequestMapping(path = "semantemeType", produces = MediaType.APPLICATION_JSON_VALUE)
public class SemantemeTypeController extends BaseEntityController<SemantemeType, SemantemeTypeDto>
        implements SemantemeTypeApi {
    private final SemantemeTypeService service;

    public SemantemeTypeController(SemantemeTypeService service) {
        this.service = service;
    }

    @Override
    public BaseEntityService<SemantemeType> getService() {
        return service;
    }

    /**
     * 获取所有业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<SemantemeTypeDto>> findAll() {
        return ResultData.success(convertToDtos(service.findAll()));
    }

    /**
     * 获取所有未冻结的业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<SemantemeTypeDto>> findAllUnfrozen() {
        return ResultData.success(convertToDtos(service.findAllUnfrozen()));
    }
}
