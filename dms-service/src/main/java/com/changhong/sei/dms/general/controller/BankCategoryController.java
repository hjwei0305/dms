package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.api.BankCategoryApi;
import com.changhong.sei.dms.general.dto.BankCategoryDto;
import com.changhong.sei.dms.general.entity.BankCategory;
import com.changhong.sei.dms.general.service.BankCategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 银行类别(BankCategory)控制类
 *
 * @author sei
 * @since 2021-05-07 11:28:57
 */
@RestController
@Api(value = "BankCategoryApi", tags = "银行类别服务")
@RequestMapping(path = BankCategoryApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class BankCategoryController extends BaseEntityController<BankCategory, BankCategoryDto> implements BankCategoryApi {
    /**
     * 银行类别服务对象
     */
    @Autowired
    private BankCategoryService service;

    @Override
    public BaseEntityService<BankCategory> getService() {
        return service;
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<BankCategoryDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }
}