package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.dms.general.api.TaxRateTypeCodeApi;
import com.changhong.sei.dms.general.dto.TaxRateTypeCodeDto;
import com.changhong.sei.dms.general.entity.TaxRateTypeCode;
import com.changhong.sei.dms.general.service.TaxRateTypeCodeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 税收分类编码(TaxRateTypeCode)控制类
 *
 * @author sei
 * @since 2021-11-10 14:21:39
 */
@RestController
@Api(value = "TaxRateTypeCodeApi", tags = "税收分类编码服务")
@RequestMapping(path = TaxRateTypeCodeApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class TaxRateTypeCodeController extends BaseEntityController<TaxRateTypeCode, TaxRateTypeCodeDto> implements TaxRateTypeCodeApi {
    /**
     * 税收分类编码服务对象
     */
    @Autowired
    private TaxRateTypeCodeService service;

    @Override
    public BaseEntityService<TaxRateTypeCode> getService() {
        return service;
    }


    @Override
    public ResultData<PageResult<TaxRateTypeCodeDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }

    @Override
    public ResultData<List<TaxRateTypeCodeDto>> findAll() {
        return ResultData.success(convertToDtos(service.findAll()));
    }

    @Override
    public ResultData<List<TaxRateTypeCodeDto>> findAllUnfrozen() {
        return ResultData.success(convertToDtos(service.findAllUnfrozen()));
    }


    @Override
    public ResultData<List<TaxRateTypeCodeDto>> getRootNode() {
        OperateResultWithData<List<TaxRateTypeCode>> result = service.getRootNode();
        if(result.getSuccess()){
            return ResultData.success(convertToDtos(result.getData()));
        }
        return ResultData.fail(result.getMessage());
    }

    @Override
    public ResultData<List<TaxRateTypeCodeDto>> getNodeByPid(String pid) {
        OperateResultWithData<List<TaxRateTypeCode>> result = service.getNodeByPid(pid);
        if(result.getSuccess()){
            return ResultData.success(convertToDtos(result.getData()));
        }
        return ResultData.fail(result.getMessage());
    }


    @Override
    public ResultData<List<TaxRateTypeCodeDto>> getNodeByPrefix(String prefixCode) {
        OperateResultWithData<List<TaxRateTypeCode>> result = service.getNodeByPrefix(prefixCode);
        if(result.getSuccess()){
            return ResultData.success(convertToDtos(result.getData()));
        }
        return ResultData.fail(result.getMessage());
    }

}