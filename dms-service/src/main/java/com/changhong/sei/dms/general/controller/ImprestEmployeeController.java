package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.dto.serach.SearchFilter;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResult;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.core.utils.ResultDataUtil;
import com.changhong.sei.dms.general.api.ImprestEmployeeApi;
import com.changhong.sei.dms.general.dto.ImprestEmployeeCorporationDto;
import com.changhong.sei.dms.general.dto.ImprestEmployeeDto;
import com.changhong.sei.dms.general.entity.ImprestEmployee;
import com.changhong.sei.dms.general.entity.ImprestEmployeeCorporation;
import com.changhong.sei.dms.general.service.ImprestEmployeeCorporationService;
import com.changhong.sei.dms.general.service.ImprestEmployeeService;
import io.swagger.annotations.Api;
import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 备用金员工(ERP)(ImprestEmployee)控制类
 *
 * @author sei
 * @since 2021-04-20 16:40:29
 */
@RestController
@Api(value = "ImprestEmployeeApi", tags = "备用金员工(ERP)服务")
@RequestMapping(path = ImprestEmployeeApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class ImprestEmployeeController extends BaseEntityController<ImprestEmployee, ImprestEmployeeDto> implements ImprestEmployeeApi {
    /**
     * 备用金员工(ERP)服务对象
     */
    @Autowired
    private ImprestEmployeeService service;
    /**
     * 备用金员工的公司信息服务对象
     */
    @Autowired
    private ImprestEmployeeCorporationService imprestEmployeeCorporationService;
    @Autowired
    private ModelMapper mapper;

    @Override
    public BaseEntityService<ImprestEmployee> getService() {
        return service;
    }


    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<ImprestEmployeeDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }


    /**
     * 获取备用金员工的公司信息
     *
     * @param imprestEmployeeId 备用金员工Id
     * @return 公司信息
     */
    @Override
    public ResultData<List<ImprestEmployeeCorporationDto>> getCorporationInfo(String imprestEmployeeId) {
        List<ImprestEmployeeCorporation> imprestEmployeeCorporationList = imprestEmployeeCorporationService.findByFilter(new SearchFilter("imprestEmployeeId", imprestEmployeeId));
        return ResultData.success(corporationInfoConvertToDtos(imprestEmployeeCorporationList));
    }

    /**
     * 保存备用金员工的公司信息
     *
     * @param dto 备用金员工的公司信息DTO
     * @return 操作结果
     */
    @Override
    public ResultData<ImprestEmployeeCorporationDto> saveCorporationInfo(@Valid ImprestEmployeeCorporationDto dto) {
        if (Objects.isNull(dto)) {
            // 输入的数据传输对象为空！
            return ResultData.fail(ContextUtil.getMessage("core_service_00002"));
        }
        ImprestEmployeeCorporation imprestEmployeeCorporation = corporationInfoConvertToEntity(dto);
        OperateResultWithData<ImprestEmployeeCorporation> saveResult = imprestEmployeeCorporationService.save(imprestEmployeeCorporation);
        if (saveResult.notSuccessful()) {
            return ResultData.fail(saveResult.getMessage());
        }
        // 数据转换 to DTO
        ImprestEmployeeCorporationDto resultData = corporationInfoConvertToDto(saveResult.getData());
        return ResultData.success(saveResult.getMessage(), resultData);
    }

    /**
     * 删除备用金员工的公司信息
     *
     * @param id 备用金员工的公司信息Id
     * @return 操作结果
     */
    @Override
    public ResultData<?> deleteCorporationInfo(String id) {
        OperateResult result = imprestEmployeeCorporationService.delete(id);
        return ResultDataUtil.convertFromOperateResult(result);
    }

    /**
     * 分页查询备用金员工的公司信息
     *
     * @param search 查询参数
     * @return 查询结果
     */
    @Override
    public ResultData<PageResult<ImprestEmployeeCorporationDto>> findCorporationInfoByPage(Search search) {
        return corporationInfoConvertToDtoPageResult(imprestEmployeeCorporationService.findByPage(search));
    }

    /**
     * 将备用金员工的公司信息清单转换成DTO清单
     *
     * @param entities 数据实体清单
     * @return DTO清单
     */
    private List<ImprestEmployeeCorporationDto> corporationInfoConvertToDtos(List<ImprestEmployeeCorporation> entities) {
        if (Objects.isNull(entities)) {
            return null;
        }
        if (CollectionUtils.isEmpty(entities)) {
            return new ArrayList<>();
        }
        return entities.stream().map(this::corporationInfoConvertToDto).collect(Collectors.toList());
    }


    /**
     * 将备用金员工的公司信息分页查询结果转换为返回结果
     *
     * @param pageResult 备用金员工的公司信息分页查询结果
     * @return 返回结果
     */
    private ResultData<PageResult<ImprestEmployeeCorporationDto>> corporationInfoConvertToDtoPageResult(PageResult<ImprestEmployeeCorporation> pageResult) {
        PageResult<ImprestEmployeeCorporationDto> result = new PageResult<>(pageResult);
        List<ImprestEmployeeCorporationDto> dtos = corporationInfoConvertToDtos(pageResult.getRows());
        result.setRows(dtos);
        return ResultData.success(result);
    }

    /**
     * 将备用金员工的公司信息转换成DTO
     *
     * @param entity 备用金员工的公司信息
     * @return DTO
     */
    private ImprestEmployeeCorporationDto corporationInfoConvertToDto(ImprestEmployeeCorporation entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        ImprestEmployeeCorporationDto result = new ImprestEmployeeCorporationDto();
        mapper.map(entity, result);
        return result;
    }

    /**
     * 将备用金员工的公司信息DTO转换成实体
     *
     * @param dto 备用金员工的公司信息DTO
     * @return 实体
     */
    private ImprestEmployeeCorporation corporationInfoConvertToEntity(ImprestEmployeeCorporationDto dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        ImprestEmployeeCorporation result = new ImprestEmployeeCorporation();
        mapper.map(dto, result);
        return result;
    }
}