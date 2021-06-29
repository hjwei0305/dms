package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.dto.serach.SearchFilter;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.Validation;
import com.changhong.sei.dms.general.api.BankApi;
import com.changhong.sei.dms.general.dto.BankDto;
import com.changhong.sei.dms.general.entity.*;
import com.changhong.sei.dms.general.service.BankService;
import io.swagger.annotations.Api;
import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 银行(Bank)控制类
 *
 * @author sei
 * @since 2021-06-25 11:10:34
 */
@RestController
@Api(value = "BankApi", tags = "银行服务")
@RequestMapping(path = BankApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class BankController extends BaseEntityController<Bank, BankDto> implements BankApi {
    /**
     * 银行服务对象
     */
    @Autowired
    private BankService service;
    @Autowired(required = false)
    private ModelMapper mapper;

    @Override
    public BaseEntityService<Bank> getService() {
        return service;
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<BankDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }

    /**
     * 基于主键集合查询集合数据对象
     *
     * @param ids 主键集合
     */
    public List<BankDto> findByIds(List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return new ArrayList<>();
        }
        List<Bank> bankList = service.findByFilter(new SearchFilter("id", ids, SearchFilter.Operator.IN));
        if (CollectionUtils.isEmpty(bankList)) {
            return new ArrayList<>();
        }
        return bankList.parallelStream().map(this::convertToDto).collect(Collectors.toList());
    }


    /**
     * 将数据实体转换成DTO
     *
     * @param entity 业务实体
     * @return DTO
     */
    @Override
    public BankDto convertToDto(Bank entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        BankDto dto = mapper.map(entity, getDtoClass());
        if (Objects.nonNull(entity.getBankCategory())) {
            dto.setBankCategoryCode(entity.getBankCategory().getCode());
            dto.setBankCategoryName(entity.getBankCategory().getName());
        }
        BankArea bankArea = entity.getBankArea();
        if (Objects.nonNull(bankArea)) {
            dto.setBankAreaCode(bankArea.getCode());
            if (Objects.nonNull(bankArea.getRegion())) {
                dto.setBankAreaName(bankArea.getRegion().getName());
            }
            BankCity bankCity = bankArea.getBankCity();
            if (Objects.nonNull(bankCity)) {
                dto.setBankCityCode(bankCity.getCode());
                if (Objects.nonNull(bankCity.getRegion())) {
                    dto.setBankCityName(bankCity.getRegion().getName());
                }
                BankProvinces bankProvince = bankCity.getBankProvince();
                if (Objects.nonNull(bankProvince)) {
                    dto.setBankProvinceCode(bankProvince.getCode());
                    Region region = bankProvince.getRegion();
                    if (Objects.nonNull(region)) {
                        dto.setBankProvinceName(region.getName());
                        if (Objects.nonNull(region.getCountry())) {
                            dto.setCountryCode(region.getCountry().getCode());
                            dto.setCountryName(region.getCountry().getName());
                        }

                    }
                }
            }
        }
        return dto;
    }
}