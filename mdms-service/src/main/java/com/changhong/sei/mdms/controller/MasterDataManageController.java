package com.changhong.sei.mdms.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.mdms.api.MasterDataManageApi;
import com.changhong.sei.mdms.dto.ColumnDto;
import com.changhong.sei.mdms.dto.TableDto;
import com.changhong.sei.mdms.service.MasterDataManageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-08-14 14:03
 */
@RestController
@Api(value = "MasterDataManageApi", tags = "主数据管理服务")
@RequestMapping(path = "masterData", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MasterDataManageController implements MasterDataManageApi {

    @Autowired
    private MasterDataManageService service;

    /**
     * 获取当前数据库所有的表
     */
    @Override
    public ResultData<List<TableDto>> getAllMasterData() {
        return service.getAllMasterData();
    }

    /**
     * 获取指定表字段信息
     *
     * @param code 主数据代码
     * @return 返回指定表字段清单
     */
    @Override
    public ResultData<List<ColumnDto>> getPropertiesByCode(String code) {
        return service.getPropertiesByCode(code);
    }
}
