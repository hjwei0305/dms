package com.changhong.sei.mdms.management.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.dto.serach.SearchFilter;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.core.utils.ResultDataUtil;
import com.changhong.sei.mdms.management.api.DataDefinitionApi;
import com.changhong.sei.mdms.management.dto.*;
import com.changhong.sei.mdms.management.entity.DataConfig;
import com.changhong.sei.mdms.management.entity.DataDefinition;
import com.changhong.sei.mdms.management.service.DataDefinitionService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
@Api(value = "DataDefinitionApi", tags = "主数据定义服务")
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
     * @param categoryId 分类代码
     * @return 返回注册的主数据
     */
    @Override
    public ResultData<List<DataDefinitionDto>> getRegisterDataByCategoryId(String categoryId, Boolean frozen) {
        Search search = Search.createSearch();
        search.addFilter(new SearchFilter(DataDefinition.CATEGORY_ID, categoryId));
        if (Objects.nonNull(frozen)) {
            search.addFilter(new SearchFilter(DataDefinition.FROZEN, frozen));
        }
        List<DataDefinition> list = service.findByFilters(search);
        if (Objects.isNull(list)) {
            list = new ArrayList<>();
        }
        ModelMapper modelMapper = getModelMapper();
        return ResultData.success(list.stream().map(o -> modelMapper.map(o, DataDefinitionDto.class)).collect(Collectors.toList()));
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

    /**
     * 获取指定主数据的UI配置
     *
     * @param id 代码
     * @return 返回指定主数据的UI配置
     */
    @Override
    public ResultData<Map<String, String>> getConfigById(String id) {
        return service.getConfigById(id);
    }

    /**
     * 保存主数据的UI配置
     *
     * @param configDto ui配置
     * @return 返回保存结果
     */
    @Override
    public ResultData<String> saveConfig(@Valid DataConfigDto configDto) {
        DataConfig config = getModelMapper().map(configDto, DataConfig.class);
        return service.saveConfig(config);
    }
}