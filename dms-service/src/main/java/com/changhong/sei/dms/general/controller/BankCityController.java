package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.api.BankCityApi;
import com.changhong.sei.dms.general.dto.BankAreaDto;
import com.changhong.sei.dms.general.dto.BankCityDto;
import com.changhong.sei.dms.general.entity.BankArea;
import com.changhong.sei.dms.general.entity.BankCity;
import com.changhong.sei.dms.general.entity.Country;
import com.changhong.sei.dms.general.entity.Region;
import com.changhong.sei.dms.general.service.BankCityService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * 银行城市(BankCity)控制类
 *
 * @author sei
 * @since 2021-05-07 15:13:02
 */
@RestController
@Api(value = "BankCityApi", tags = "银行城市服务")
@RequestMapping(path = BankCityApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class BankCityController extends BaseEntityController<BankCity, BankCityDto> implements BankCityApi {
    /**
     * 银行城市服务对象
     */
    @Autowired
    private BankCityService service;
    @Autowired(required = false)
    private ModelMapper mapper;

    @Override
    public BaseEntityService<BankCity> getService() {
        return service;
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<BankCityDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }


    /**
     * 将数据实体转换成DTO
     *
     * @param entity 业务实体
     * @return DTO
     */
    @Override
    public BankCityDto convertToDto(BankCity entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        BankCityDto bankCityDto = mapper.map(entity, getDtoClass());
        if (Objects.nonNull(entity.getBankProvince())) {
            bankCityDto.setBankProvinceCode(entity.getBankProvince().getCode());
        }
        Region region = entity.getRegion();
        if (Objects.nonNull(region)) {
            bankCityDto.setRegionCode(region.getCode());
            bankCityDto.setRegionName(region.getName());
            Country country = region.getCountry();
            if (Objects.nonNull(country)) {
                bankCityDto.setCountryCode(country.getCode());
                bankCityDto.setCountryName(country.getName());
            }
        }
        return bankCityDto;
    }
}