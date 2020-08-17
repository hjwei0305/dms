package com.changhong.sei.mdms.management.controller;

import com.changhong.sei.core.controller.BaseTreeController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseTreeService;
import com.changhong.sei.mdms.management.api.MasterDataTypeApi;
import com.changhong.sei.mdms.management.dto.MasterDataTypeDto;
import com.changhong.sei.mdms.management.entity.MasterDataType;
import com.changhong.sei.mdms.management.service.MasterDataTypeService;
import io.swagger.annotations.Api;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
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
@Api(value = "MasterDataTypeApi", tags = "主数据分类服务")
@RequestMapping(path = "masterDataType", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MasterDataTypeController extends BaseTreeController<MasterDataType, MasterDataTypeDto> implements MasterDataTypeApi {
    /**
     * 主数据分类服务对象
     */
    @Autowired
    private MasterDataTypeService service;

    @Override
    public BaseTreeService<MasterDataType> getService() {
        return service;
    }

    /**
     * 获取主数据分类的树
     *
     * @return 获取主数据分类的树
     */
    @Override
    public ResultData<List<MasterDataTypeDto>> getTypeTree() {
        List<MasterDataTypeDto> tree = new LinkedList<>();
        List<MasterDataType> roots = service.getAllRootNode();
        if (CollectionUtils.isNotEmpty(roots)) {
            for (MasterDataType root : roots) {
                MasterDataType node = service.getTree(root.getId());
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
    public ResultData<MasterDataTypeDto> getTreeByCode(String code) {
        ResultData<MasterDataType> resultData = service.getTreeByCode(code);
        if (resultData.successful()) {
            return ResultData.success(convertToDto(resultData.getData()));
        }
        return ResultData.fail(resultData.getMessage());
    }
}