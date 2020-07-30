package com.changhong.sei.mdms.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.mdms.api.DataModelApi;
import com.changhong.sei.mdms.dto.DataModelDto;
import com.changhong.sei.mdms.dto.DataModelFieldDto;
import com.changhong.sei.mdms.entity.DataModel;
import com.changhong.sei.mdms.entity.DataModelField;
import com.changhong.sei.mdms.service.DataModelService;
import io.swagger.annotations.Api;
import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 数据模型(DataModel)控制类
 *
 * @author sei
 * @since 2020-07-28 23:24:21
 */
@RestController
@Api(value = "DataModelApi", tags = "数据模型服务")
@RequestMapping(path = "dataModel", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DataModelController extends BaseEntityController<DataModel, DataModelDto> implements DataModelApi {
    /**
     * 数据模型服务对象
     */
    @Autowired
    private DataModelService service;

    @Override
    public BaseEntityService<DataModel> getService() {
        return service;
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<DataModelDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }

    /**
     * 根据数据模型id获取模型字段清单
     *
     * @param modelId 数据模型id
     * @return 返回自定的模型字段清单
     */
    @Override
    public ResultData<List<DataModelFieldDto>> getDataModelFields(String modelId) {
        List<DataModelFieldDto> result;
        List<DataModelField> fields = service.getDataModelFields(modelId);
        if (CollectionUtils.isNotEmpty(fields)) {
            ModelMapper mapper = getModelMapper();
            // 设置为严格匹配
            mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            result = fields.parallelStream().map(f -> mapper.map(f, DataModelFieldDto.class)).collect(Collectors.toList());
        } else {
            result = new ArrayList<>();
        }
        return ResultData.success(result);
    }

    /**
     * 添加默认审计字段
     *
     * @param modelId 数据模型id
     * @return 返回操作结果
     */
    @Override
    public ResultData<String> addAuditFields(String modelId) {
        return service.addAuditFields(modelId);
    }

    /**
     * 添加数据模型字段
     *
     * @param fieldDtos 数据模型字段dto
     * @return 返回操作结果
     */
    @Override
    public ResultData<String> saveModelFields(List<DataModelFieldDto> fieldDtos) {
        if (CollectionUtils.isNotEmpty(fieldDtos)) {
            ModelMapper mapper = getModelMapper();
            // 设置为严格匹配
            mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            List<DataModelField> modelFields = fieldDtos.parallelStream()
                    .map(f -> mapper.map(f, DataModelField.class)).collect(Collectors.toList());
            return service.saveModelFields(modelFields);
        }
        return ResultData.fail("请求参数不能为空.");
    }

    /**
     * 删除数据模型字段
     *
     * @param fieldIds 删除的数据模型字段id清单
     * @return 返回操作结果
     */
    @Override
    public ResultData<String> deleteModelFields(List<String> fieldIds) {
        return service.deleteModelFields(fieldIds);
    }
}