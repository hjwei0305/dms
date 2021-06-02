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
import com.changhong.sei.dms.general.api.SupplierApi;
import com.changhong.sei.dms.general.dto.SupplierCorporationDto;
import com.changhong.sei.dms.general.dto.SupplierCorporationDto;
import com.changhong.sei.dms.general.dto.SupplierDto;
import com.changhong.sei.dms.general.entity.SupplierCorporation;
import com.changhong.sei.dms.general.entity.Supplier;
import com.changhong.sei.dms.general.service.SupplierCorporationService;
import com.changhong.sei.dms.general.service.SupplierCorporationService;
import com.changhong.sei.dms.general.service.SupplierService;
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
 * 供应商(Supplier)控制类
 *
 * @author sei
 * @since 2021-05-06 14:07:31
 */
@RestController
@Api(value = "SupplierApi", tags = "供应商服务")
@RequestMapping(path = SupplierApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class SupplierController extends BaseEntityController<Supplier, SupplierDto> implements SupplierApi {
    /**
     * 供应商服务对象
     */
    @Autowired
    private SupplierService service;
    /**
     * 供应商的公司信息服务对象
     */
    @Autowired
    private SupplierCorporationService supplierCorporationService;
    @Autowired
    private ModelMapper mapper;

    @Override
    public BaseEntityService<Supplier> getService() {
        return service;
    }

    /**
     * 获取供应商的公司信息
     *
     * @param supplierId 供应商Id
     * @return 公司信息
     */
    @Override
    public ResultData<List<SupplierCorporationDto>> getCorporationInfo(String supplierId) {
        List<SupplierCorporation> supplierCorporationList = supplierCorporationService.getCorporationInfo(supplierId);
        return ResultData.success(corporationInfoConvertToDtos(supplierCorporationList));
    }

    /**
     * 保存供应商的公司信息
     *
     * @param dto 供应商的公司信息DTO
     * @return 操作结果
     */
    @Override
    public ResultData<SupplierCorporationDto> saveCorporationInfo(@Valid SupplierCorporationDto dto) {
        if (Objects.isNull(dto)) {
            // 输入的数据传输对象为空！
            return ResultData.fail(ContextUtil.getMessage("core_service_00002"));
        }
        SupplierCorporation supplierCorporation = corporationInfoConvertToEntity(dto);
        OperateResultWithData<SupplierCorporation> saveResult = supplierCorporationService.save(supplierCorporation);
        if (saveResult.notSuccessful()) {
            return ResultData.fail(saveResult.getMessage());
        }
        // 数据转换 to DTO
        SupplierCorporationDto resultData = corporationInfoConvertToDto(saveResult.getData());
        return ResultData.success(saveResult.getMessage(), resultData);
    }

    /**
     * 删除供应商的公司信息
     *
     * @param id 供应商的公司信息Id
     * @return 操作结果
     */
    @Override
    public ResultData<?> deleteCorporationInfo(String id) {
        OperateResult result = supplierCorporationService.delete(id);
        return ResultDataUtil.convertFromOperateResult(result);
    }

    /**
     * 分页查询供应商的公司信息
     *
     * @param search 查询参数
     * @return 查询结果
     */
    @Override
    public ResultData<PageResult<SupplierCorporationDto>> findCorporationInfoByPage(Search search) {
        return corporationInfoConvertToDtoPageResult(supplierCorporationService.findByPage(search));
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<SupplierDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }

    /**
     * 根据代码查询供应商
     *
     * @param code 供应商代码
     * @return 供应商
     */
    @Override
    public ResultData<SupplierDto> findByCode(String code) {
        return ResultData.success(convertToDto(service.findByCode(code)));
    }

    /**
     * 将供应商的公司信息清单转换成DTO清单
     *
     * @param entities 数据实体清单
     * @return DTO清单
     */
    private List<SupplierCorporationDto> corporationInfoConvertToDtos(List<SupplierCorporation> entities) {
        if (Objects.isNull(entities)) {
            return null;
        }
        if (CollectionUtils.isEmpty(entities)) {
            return new ArrayList<>();
        }
        return entities.stream().map(this::corporationInfoConvertToDto).collect(Collectors.toList());
    }


    /**
     * 将供应商的公司信息分页查询结果转换为返回结果
     *
     * @param pageResult 供应商的公司信息分页查询结果
     * @return 返回结果
     */
    private ResultData<PageResult<SupplierCorporationDto>> corporationInfoConvertToDtoPageResult(PageResult<SupplierCorporation> pageResult) {
        PageResult<SupplierCorporationDto> result = new PageResult<>(pageResult);
        List<SupplierCorporationDto> dtos = corporationInfoConvertToDtos(pageResult.getRows());
        result.setRows(dtos);
        return ResultData.success(result);
    }

    /**
     * 将供应商的公司信息转换成DTO
     *
     * @param entity 供应商的公司信息
     * @return DTO
     */
    private SupplierCorporationDto corporationInfoConvertToDto(SupplierCorporation entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        SupplierCorporationDto result = new SupplierCorporationDto();
        mapper.map(entity, result);
        return result;
    }

    /**
     * 将供应商的公司信息DTO转换成实体
     *
     * @param dto 供应商的公司信息DTO
     * @return 实体
     */
    private SupplierCorporation corporationInfoConvertToEntity(SupplierCorporationDto dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        SupplierCorporation result = new SupplierCorporation();
        mapper.map(dto, result);
        return result;
    }
}