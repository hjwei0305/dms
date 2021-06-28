package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.api.TaxTypeApi;
import com.changhong.sei.dms.general.dto.TaxCategory;
import com.changhong.sei.dms.general.dto.TaxTypeDto;
import com.changhong.sei.dms.general.entity.TaxType;
import com.changhong.sei.dms.general.service.TaxTypeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 税分类（TaxType）控制类
 *
 * @author 杨沄炜
 * @since 2021/06/23 9:21
 */
@RestController
@Api(value = "TaxTypeApi", tags = "税类型(TaxType)服务")
@RequestMapping(path = TaxTypeApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class TaxTypeController extends BaseEntityController<TaxType, TaxTypeDto> implements TaxTypeApi {
    /**
     * 税分类(TaxType)服务对象
     */
    @Autowired
    private TaxTypeService service;

    @Override
    public BaseEntityService<TaxType> getService() {return service;}

    /**
     * 获取所有业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<TaxTypeDto>> findAll() {
        return ResultData.success(convertToDtos(service.findAll()));
    }

    /**
     * 获取所有未冻结的业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<TaxTypeDto>> findAllUnfrozen() {
        return ResultData.success(convertToDtos(service.findAllUnfrozen()));
    }

    /**
     * 根据税分类获取税类型清单
     *
     * @param taxCategory 税分类
     * @return 税类型清单
     */
    @Override
    public ResultData<List<TaxTypeDto>> findByTaxCategory(TaxCategory taxCategory) {
        return ResultData.success(convertToDtos(service.findByTaxCategory(taxCategory)));
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<TaxTypeDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }

    /**
     * 根据税码获取税类型
     *
     * @param code 税码
     * @return 税类型
     */
    @Override
    public ResultData<TaxTypeDto> findByCode(String code){
        return ResultData.success(convertToDto(service.findByCode(code)));
    }
}
