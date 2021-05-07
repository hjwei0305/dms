package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.api.BankAreaApi;
import com.changhong.sei.dms.general.dto.BankAreaDto;
import com.changhong.sei.dms.general.entity.BankArea;
import com.changhong.sei.dms.general.service.BankAreaService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * 银行地区(BankArea)控制类
 *
 * @author sei
 * @since 2021-05-07 15:55:11
 */
@RestController
@Api(value = "BankAreaApi", tags = "银行地区服务")
@RequestMapping(path = BankAreaApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class BankAreaController extends BaseEntityController<BankArea, BankAreaDto> implements BankAreaApi {
    /**
     * 银行地区服务对象
     */
    @Autowired
    private BankAreaService service;
    @Autowired(required = false)
    private ModelMapper mapper;

    @Override
    public BaseEntityService<BankArea> getService() {
        return service;
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<BankAreaDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }

    /**
     * 将数据实体转换成DTO
     *
     * @param entity 业务实体
     * @return DTO
     */
    @Override
    public BankAreaDto convertToDto(BankArea entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        return mapper.map(entity, getDtoClass());
    }
}