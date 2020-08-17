package com.changhong.sei.mdms.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.dto.serach.SearchFilter;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.mdms.api.MasterDataUiConfigApi;
import com.changhong.sei.mdms.dto.CodeNameDto;
import com.changhong.sei.mdms.dto.EntityDto;
import com.changhong.sei.mdms.dto.MasterDataRegisterDto;
import com.changhong.sei.mdms.dto.MasterDataUiConfigDto;
import com.changhong.sei.mdms.entity.MasterDataUiConfig;
import com.changhong.sei.mdms.service.MasterDataUiConfigService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 主数据UI配置(MasterDataUiConfig)控制类
 *
 * @author sei
 * @since 2020-08-13 22:47:17
 */
@RestController
@Api(value = "MasterDataUiConfigApi", tags = "主数据UI配置服务")
@RequestMapping(path = "masterDataUiConfig", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MasterDataUiConfigController extends BaseEntityController<MasterDataUiConfig, MasterDataUiConfigDto> implements MasterDataUiConfigApi {
    /**
     * 主数据UI配置服务对象
     */
    @Autowired
    private MasterDataUiConfigService service;

    @Override
    public BaseEntityService<MasterDataUiConfig> getService() {
        return service;
    }

    /**
     * 主数据注册
     *
     * @param request 主数据注册请求
     * @return 操作结果
     */
    @Override
    public ResultData<String> register(MasterDataRegisterDto request) {
        MasterDataUiConfig config = getModelMapper().map(request, MasterDataUiConfig.class);
        OperateResultWithData<MasterDataUiConfig> result = service.save(config);
        if (result.successful()) {
            return ResultData.success(result.getMessage());
        } else {
            return ResultData.fail(result.getMessage());
        }
    }

    /**
     * 取消主数据注册
     *
     * @param id 取消主数据注册请求id
     * @return 操作结果
     */
    @Override
    public ResultData<String> unregister(String id) {
        return service.unregister(id);
    }

    /**
     * 获取指定主数据分类获取注册的主数据
     *
     * @param typeCode 分类代码
     * @return 返回注册的主数据
     */
    @Override
    public ResultData<List<MasterDataRegisterDto>> getRegisterDataByTypeCode(String typeCode) {
        Search search = Search.createSearch();
        search.addFilter(new SearchFilter(MasterDataUiConfig.TYPE_CODE, typeCode));
        List<MasterDataUiConfig> list = service.findByFilters(search);
        if (Objects.isNull(list)) {
            list = new ArrayList<>();
        }
        ModelMapper modelMapper = getModelMapper();
        return ResultData.success(list.stream().map(o -> modelMapper.map(o, MasterDataRegisterDto.class)).collect(Collectors.toList()));
    }

    /**
     * 获取指定主数据的UI配置
     *
     * @param typeCode 主数据分类代码
     * @return 返回指定主数据的UI配置
     */
    @Override
    public ResultData<List<MasterDataUiConfigDto>> getConfigByTypeCode(String typeCode) {
        Search search = Search.createSearch();
        search.addFilter(new SearchFilter(MasterDataUiConfig.TYPE_CODE, typeCode));
        search.addFilter(new SearchFilter(MasterDataUiConfig.FROZEN, Boolean.FALSE));
        List<MasterDataUiConfig> list = service.findByFilters(search);
        if (Objects.isNull(list)) {
            list = new ArrayList<>();
        }
        return ResultData.success(convertToDtos(list));
    }

    /**
     * 获取指定主数据的UI配置
     *
     * @param code 代码
     * @return 返回指定主数据的UI配置
     */
    @Override
    public ResultData<MasterDataUiConfigDto> getConfigByCode(String code) {
        MasterDataUiConfig config = service.findByProperty(MasterDataUiConfig.TYPE_CODE, code);
        if (Objects.isNull(config)) {
            return ResultData.fail("未找到[" + code + "]的主数据UI配置.");
        } else {
            return ResultData.success(convertToDto(config));
        }
    }

    /**
     * 获取当前数据库所有的表
     */
    @Override
    public ResultData<List<EntityDto>> getAllMasterData() {
        return service.getAllMasterDataEntities();
    }

    /**
     * 获取指定表字段信息
     *
     * @param code 主数据代码
     * @return 返回指定表字段清单
     */
    @Override
    public ResultData<List<CodeNameDto>> getPropertiesByCode(String code) {
        return service.getPropertiesByCode(code);
    }

}