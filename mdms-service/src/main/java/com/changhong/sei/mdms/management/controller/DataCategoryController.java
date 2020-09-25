package com.changhong.sei.mdms.management.controller;

import com.changhong.sei.core.controller.BaseTreeController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseTreeService;
import com.changhong.sei.mdms.management.api.DataCategoryApi;
import com.changhong.sei.mdms.management.dto.DataCategoryDto;
import com.changhong.sei.mdms.management.entity.DataCategory;
import com.changhong.sei.mdms.management.service.DataCategoryService;
import io.swagger.annotations.Api;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * 主数据分类(MasterDataType)控制类
 *
 * @author sei
 * @since 2020-08-13 22:47:06
 */
@RestController
@Api(value = "DataCategoryApi", tags = "主数据分类服务")
public class DataCategoryController extends BaseTreeController<DataCategory, DataCategoryDto> implements DataCategoryApi {
    /**
     * 主数据分类服务对象
     */
    @Autowired
    private DataCategoryService service;

    @Override
    public BaseTreeService<DataCategory> getService() {
        return service;
    }

    /**
     * 获取主数据分类的树
     *
     * @return 获取主数据分类的树
     */
    @Override
    public ResultData<List<DataCategoryDto>> getTypeTree() {
        List<DataCategoryDto> tree = new LinkedList<>();
        List<DataCategory> roots = service.getAllRootNode();
        if (CollectionUtils.isNotEmpty(roots)) {
            for (DataCategory root : roots) {
                DataCategory node = service.getTree(root.getId());
                tree.add(convertToDto(node));
            }
        }

        return ResultData.success(tree);
    }

    /**
     * 根据代码获取一个节点的树
     *
     * @param code 节点code
     * @return 节点树
     */
    @Override
    public ResultData<DataCategoryDto> getTreeByCode(String code) {
        ResultData<DataCategory> resultData = service.getTreeByCode(code);
        if (resultData.successful()) {
            return ResultData.success(convertToDto(resultData.getData()));
        }
        return ResultData.fail(resultData.getMessage());
    }
}