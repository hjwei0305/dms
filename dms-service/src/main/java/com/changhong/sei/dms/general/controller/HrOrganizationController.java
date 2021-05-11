package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.dms.general.api.HrOrganizationApi;
import com.changhong.sei.dms.general.dto.HrOrganizationDto;
import com.changhong.sei.dms.general.entity.HrOrganization;
import com.changhong.sei.dms.general.service.HrOrganizationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * HR组织机构(ERP)(HrOrganization)控制类
 *
 * @author sei
 * @since 2021-04-19 14:59:05
 */
@RestController
@Api(value = "HrOrganizationApi", tags = "HR组织机构(ERP)服务")
@RequestMapping(path = HrOrganizationApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class HrOrganizationController extends BaseEntityController<HrOrganization, HrOrganizationDto> implements HrOrganizationApi {
    /**
     * HR组织机构(ERP)服务对象
     */
    @Autowired
    private HrOrganizationService service;

    @Override
    public BaseEntityService<HrOrganization> getService() {
        return service;
    }


    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<HrOrganizationDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }

    /**
     * 获取所有HR组织机构树
     *
     * @return HR组织机构树形对象集合
     */
    @Override
    public ResultData<List<HrOrganizationDto>> getMultipleRoots() {
        return service.getTree(Boolean.TRUE);
    }

    /**
     * 获取HR组织机构树（未冻结的）
     */
    @Override
    public ResultData<List<HrOrganizationDto>> getUnfrozenTree() {
        return service.getTree(Boolean.FALSE);
    }

    /**
     * 添加映射关系
     *
     * @param id             HR组织机构Id
     * @param organizationId 组织机构Id
     * @return 操作结果
     */
    @Override
    public ResultData<HrOrganizationDto> insertRelation(String id, String organizationId) {
        OperateResultWithData<HrOrganization> result = service.insertRelation(id, organizationId);
        if (result.notSuccessful()) {
            return ResultData.fail(result.getMessage());
        }
        // 数据转换 to DTO
        HrOrganizationDto resultData = convertToDto(result.getData());
        return ResultData.success(result.getMessage(), resultData);
    }

    /**
     * 移除映射关系
     *
     * @param id HR组织机构Id
     * @return 操作结果
     */
    @Override
    public ResultData<HrOrganizationDto> removeRelation(String id) {
        OperateResultWithData<HrOrganization> result = service.removeRelation(id);
        if (result.notSuccessful()) {
            return ResultData.fail(result.getMessage());
        }
        // 数据转换 to DTO
        HrOrganizationDto resultData = convertToDto(result.getData());
        return ResultData.success(result.getMessage(), resultData);
    }

    /**
     * 根据HR组织机构代码获取HR组织机构
     *
     * @param code
     */
    @Override
    public ResultData<HrOrganizationDto> findByCode(String code) {
        return ResultData.success(convertToDto(service.findByCode(code)));
    }
}