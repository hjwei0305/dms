package com.changhong.sei.mdms.management.controller;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.dto.serach.SearchFilter;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.core.utils.ResultDataUtil;
import com.changhong.sei.mdms.management.api.DataDefinitionApi;
import com.changhong.sei.mdms.management.dto.ConfigTypeEnum;
import com.changhong.sei.mdms.management.dto.DataDefinitionDto;
import com.changhong.sei.mdms.management.dto.DataStructureEnum;
import com.changhong.sei.mdms.management.dto.EntityDto;
import com.changhong.sei.mdms.management.entity.DataConfig;
import com.changhong.sei.mdms.management.entity.DataDefinition;
import com.changhong.sei.mdms.management.service.DataDefinitionService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 主数据定义(DataDefinition)控制类
 *
 * @author sei
 * @since 2020-08-13 22:47:17
 */
@RestController
public class DataDefinitionController extends BaseEntityController<DataDefinition, DataDefinitionDto> implements DataDefinitionApi {
    /**
     * 主数据UI配置服务对象
     */
    @Autowired
    private DataDefinitionService service;

    @Override
    public BaseEntityService<DataDefinition> getService() {
        return service;
    }

    /**
     * 获取支持的数据结构
     */
    @Override
    public ResultData<Map<String, String>> getDataStructure() {
        return ResultDataUtil.getEnumMap(DataStructureEnum.class);
    }

    /**
     * 获取支持的配置类型
     */
    @Override
    public ResultData<Map<String, String>> getConfigType() {
        return ResultDataUtil.getEnumMap(ConfigTypeEnum.class);
    }

    /**
     * 主数据注册
     *
     * @param request 主数据注册请求
     * @return 操作结果
     */
    @Override
    public ResultData<String> register(DataDefinitionDto request) {
        DataDefinition config = getModelMapper().map(request, DataDefinition.class);
        OperateResultWithData<DataDefinition> result = service.save(config);
        if (result.successful()) {
            return ResultData.success(result.getMessage());
        } else {
            return ResultData.fail(result.getMessage());
        }
    }

    /**
     * 冻结数据
     *
     * @param id id
     * @return 操作结果
     */
    @Override
    public ResultData<String> frozen(String id) {
        return service.doFrozen(id, Boolean.TRUE);
    }

    /**
     * 解冻数据
     *
     * @param id id
     * @return 操作结果
     */
    @Override
    public ResultData<String> unfrozen(String id) {
        return service.doFrozen(id, Boolean.FALSE);
    }

    /**
     * 分页查询注册的主数据
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<DataDefinitionDto>> getRegisterDataByPage(Search search) {
        PageResult<DataDefinition> pageResult = service.findByPage(search);
        PageResult<DataDefinitionDto> result = new PageResult<>(pageResult);
        if (pageResult.getRecords() > 0) {
            List<DataDefinition> list = pageResult.getRows();
            if (Objects.nonNull(list)) {
                ModelMapper modelMapper = getModelMapper();
                List<DataDefinitionDto> dtos = list.stream()
                        .map(o -> modelMapper.map(o, DataDefinitionDto.class)).collect(Collectors.toList());
                result.setRows(dtos);
            }
        }
        return ResultData.success(result);
    }

    /**
     * 获取指定主数据分类获取注册的主数据
     *
     * @param typeCode 分类代码
     * @return 返回注册的主数据
     */
    @Override
    public ResultData<List<DataDefinitionDto>> getRegisterDataByCategoryId(String typeCode) {
        Search search = Search.createSearch();
        search.addFilter(new SearchFilter(DataConfig.TYPE_CODE, typeCode));
        List<DataDefinition> list = service.findByFilters(search);
        if (Objects.isNull(list)) {
            list = new ArrayList<>();
        }
        ModelMapper modelMapper = getModelMapper();
        return ResultData.success(list.stream().map(o -> modelMapper.map(o, DataDefinitionDto.class)).collect(Collectors.toList()));
    }

    /**
     * 获取指定主数据的UI配置
     *
     * @param typeCode 主数据分类代码
     * @return 返回指定主数据的UI配置
     */
    @Override
    public ResultData<List<DataDefinitionDto>> getConfigByCategoryId(String typeCode) {
        Search search = Search.createSearch();
        search.addFilter(new SearchFilter(DataDefinition.TYPE_CODE, typeCode));
        search.addFilter(new SearchFilter(DataDefinition.FROZEN, Boolean.FALSE));
        List<DataDefinition> list = service.findByFilters(search);
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
    public ResultData<DataDefinitionDto> getConfigByCode(String code) {
        DataDefinition config = service.findByProperty(DataDefinition.TYPE_CODE, code);
        if (Objects.isNull(config)) {
            // 未找到[{0}]的主数据UI配置.
            return ResultData.fail(ContextUtil.getMessage("00018", code));
        } else {
            return ResultData.success(convertToDto(config));
        }
    }

    /**
     * 获取当前所有注册数据
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
    public ResultData<List<EntityDto.Property>> getPropertiesByCode(String code) {
        return service.getPropertiesByCode(code);
    }

}