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
import com.changhong.sei.dms.general.api.CustomerApi;
import com.changhong.sei.dms.general.dto.CustomerCorporationDto;
import com.changhong.sei.dms.general.dto.CustomerDto;
import com.changhong.sei.dms.general.dto.ImprestEmployeeCorporationDto;
import com.changhong.sei.dms.general.entity.Customer;
import com.changhong.sei.dms.general.entity.CustomerCorporation;
import com.changhong.sei.dms.general.entity.ImprestEmployeeCorporation;
import com.changhong.sei.dms.general.service.CustomerCorporationService;
import com.changhong.sei.dms.general.service.CustomerService;
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
 * 客户(Customer)控制类
 *
 * @author sei
 * @since 2021-05-06 13:05:16
 */
@RestController
@Api(value = "CustomerApi", tags = "客户服务")
@RequestMapping(path = CustomerApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController extends BaseEntityController<Customer, CustomerDto> implements CustomerApi {
    /**
     * 客户服务对象
     */
    @Autowired
    private CustomerService service;
    /**
     * 客户的公司信息服务对象
     */
    @Autowired
    private CustomerCorporationService customerCorporationService;
    @Autowired
    private ModelMapper mapper;

    @Override
    public BaseEntityService<Customer> getService() {
        return service;
    }

    /**
     * 获取客户的公司信息
     *
     * @param customerId 客户Id
     * @return 公司信息
     */
    @Override
    public ResultData<List<CustomerCorporationDto>> getCorporationInfo(String customerId) {
        List<CustomerCorporation> customerCorporationList = customerCorporationService.getCorporationInfo(customerId);
        return ResultData.success(corporationInfoConvertToDtos(customerCorporationList));
    }

    /**
     * 保存客户的公司信息
     *
     * @param dto 客户的公司信息DTO
     * @return 操作结果
     */
    @Override
    public ResultData<CustomerCorporationDto> saveCorporationInfo(@Valid CustomerCorporationDto dto) {
        if (Objects.isNull(dto)) {
            // 输入的数据传输对象为空！
            return ResultData.fail(ContextUtil.getMessage("core_service_00002"));
        }
        CustomerCorporation customerCorporation = corporationInfoConvertToEntity(dto);
        OperateResultWithData<CustomerCorporation> saveResult = customerCorporationService.save(customerCorporation);
        if (saveResult.notSuccessful()) {
            return ResultData.fail(saveResult.getMessage());
        }
        // 数据转换 to DTO
        CustomerCorporationDto resultData = corporationInfoConvertToDto(saveResult.getData());
        return ResultData.success(saveResult.getMessage(), resultData);
    }

    /**
     * 删除客户的公司信息
     *
     * @param id 客户的公司信息Id
     * @return 操作结果
     */
    @Override
    public ResultData<?> deleteCorporationInfo(String id) {
        OperateResult result = customerCorporationService.delete(id);
        return ResultDataUtil.convertFromOperateResult(result);
    }

    /**
     * 分页查询客户的公司信息
     *
     * @param search 查询参数
     * @return 查询结果
     */
    @Override
    public ResultData<PageResult<CustomerCorporationDto>> findCorporationInfoByPage(Search search) {
        return corporationInfoConvertToDtoPageResult(customerCorporationService.findByPage(search));
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<CustomerDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }

    /**
     * 根据代码查询客户
     *
     * @param code 客户代码
     * @return 客户
     */
    @Override
    public ResultData<CustomerDto> findByCode(String code) {
        return ResultData.success(convertToDto(service.findByCode(code)));
    }

    /**
     * 将客户的公司信息清单转换成DTO清单
     *
     * @param entities 数据实体清单
     * @return DTO清单
     */
    private List<CustomerCorporationDto> corporationInfoConvertToDtos(List<CustomerCorporation> entities) {
        if (Objects.isNull(entities)) {
            return null;
        }
        if (CollectionUtils.isEmpty(entities)) {
            return new ArrayList<>();
        }
        return entities.stream().map(this::corporationInfoConvertToDto).collect(Collectors.toList());
    }


    /**
     * 将客户的公司信息分页查询结果转换为返回结果
     *
     * @param pageResult 客户的公司信息分页查询结果
     * @return 返回结果
     */
    private ResultData<PageResult<CustomerCorporationDto>> corporationInfoConvertToDtoPageResult(PageResult<CustomerCorporation> pageResult) {
        PageResult<CustomerCorporationDto> result = new PageResult<>(pageResult);
        List<CustomerCorporationDto> dtos = corporationInfoConvertToDtos(pageResult.getRows());
        result.setRows(dtos);
        return ResultData.success(result);
    }

    /**
     * 将客户的公司信息转换成DTO
     *
     * @param entity 客户的公司信息
     * @return DTO
     */
    private CustomerCorporationDto corporationInfoConvertToDto(CustomerCorporation entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        CustomerCorporationDto result = new CustomerCorporationDto();
        mapper.map(entity, result);
        return result;
    }

    /**
     * 将客户的公司信息DTO转换成实体
     *
     * @param dto 客户的公司信息DTO
     * @return 实体
     */
    private CustomerCorporation corporationInfoConvertToEntity(CustomerCorporationDto dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        CustomerCorporation result = new CustomerCorporation();
        mapper.map(dto, result);
        return result;
    }
}