package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.api.TaxRateApi;
import com.changhong.sei.dms.general.dto.TaxRateDto;
import com.changhong.sei.dms.general.entity.TaxRate;
import com.changhong.sei.dms.general.service.TaxRateService;
import com.changhong.sei.util.ArithUtils;
import io.swagger.annotations.Api;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 刘松林
 * @Contact: songlin.liu@changhong.com
 * @Date: 2020/3/12 15:57
 * @Description: 税率
 */
@RestController
@Api(value = "taxRate", tags = "税率API服务实现")
@RequestMapping(path = "taxRate", produces = MediaType.APPLICATION_JSON_VALUE)
public class TaxRateController extends BaseEntityController<TaxRate, TaxRateDto> implements TaxRateApi {
    @Autowired
    private TaxRateService service;

    @Override
    public BaseEntityService<TaxRate> getService() {
        return service;
    }

    /**
     * 获取所有业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<TaxRateDto>> findAll() {
        return ResultData.success(convertToDtos(service.findAll()));
    }

    /**
     * 获取所有未冻结的业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<TaxRateDto>> findAllUnfrozen() {
        return ResultData.success(convertToDtos(service.findAllUnfrozen()));
    }

    /**
     * 自定义设置Entity转换为DTO的转换器
     */
    @Override
    protected void customConvertToDtoMapper() {
        // 创建自定义映射规则
        PropertyMap<TaxRate, TaxRateDto> propertyMap = new PropertyMap<TaxRate, TaxRateDto>() {
            @Override
            protected void configure() {
                //创建自定义转换规则
                Converter<Double, Double> toRate = new AbstractConverter<Double, Double>() {
                    protected Double convert(Double source) {
                        // 将小数税率转换为百分比(4位小数)
                        return ArithUtils.round(ArithUtils.mul(source, 100), 4);
                    }
                };
                using(toRate).map(source.getTaxRate(), destination.getTaxRate());
            }
        };
        // 添加映射器
        dtoModelMapper.addMappings(propertyMap);
    }

    /**
     * 自定义设置DTO转换为Entity的转换器
     */
    @Override
    protected void customerConvertToEntityMapper() {
        // 创建自定义映射规则
        PropertyMap<TaxRateDto, TaxRate> propertyMap = new PropertyMap<TaxRateDto, TaxRate>() {
            @Override
            protected void configure() {
                //创建自定义转换规则
                Converter<Double, Double> toDouble = new AbstractConverter<Double, Double>() {
                    protected Double convert(Double source) {
                        // 将百分比转换为小数税率(保留6位小数)
                        return ArithUtils.round(ArithUtils.div(source, 100), 6);
                    }
                };
                using(toDouble).map(source.getTaxRate(), destination.getTaxRate());
            }
        };
        // 添加映射器
        entityModelMapper.addMappings(propertyMap);
    }
}
