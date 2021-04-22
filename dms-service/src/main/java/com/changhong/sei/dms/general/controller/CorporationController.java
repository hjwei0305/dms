package com.changhong.sei.dms.general.controller;


import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.api.CorporationApi;
import com.changhong.sei.dms.general.dto.CorporationDto;
import com.changhong.sei.dms.general.entity.Corporation;
import com.changhong.sei.dms.general.service.CorporationService;
import com.changhong.sei.dms.general.service.cust.CorporationServiceCust;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 实现功能: 公司API服务实现
 *
 * @author 王锦光 wangjg
 * @version 2020-01-26 16:26
 */
@RestController
@Api(value = "CorporationApi", tags = "公司API服务")
@RequestMapping(path = "corporation", produces = MediaType.APPLICATION_JSON_VALUE)
public class CorporationController extends BaseEntityController<Corporation, CorporationDto>
        implements CorporationApi {
    @Autowired
    private CorporationService service;
    // 注入扩展业务逻辑
    @Autowired
    private CorporationServiceCust serviceCust;

    /**
     * 将数据实体转换成DTO
     *
     * @param entity 业务实体
     * @return DTO
     */
    @Override
    public CorporationDto convertToDto(Corporation entity) {
        CorporationDto dto = super.convertToDto(entity);
        if (Objects.isNull(dto)) {
            return null;
        }
        // 自定义扩展实体转DTO属性赋值
        serviceCust.customEntityToDto(entity, dto);
        return dto;
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<CorporationDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }

    /**
     * 根据公司代码查询公司
     *
     * @param code 公司代码
     * @return 公司
     */
    @Override
    public ResultData<CorporationDto> findByCode(String code) {
        Corporation corporation = service.findByCode(code);
        return ResultData.success(convertToDto(corporation));
    }

    /**
     * 根据ERP公司代码查询公司
     *
     * @param erpCode ERP公司代码
     * @return 公司
     */
    @Override
    public ResultData<List<CorporationDto>> findByErpCode(String erpCode) {
        List<Corporation> corporations = service.findByErpCode(erpCode);
        List<CorporationDto> dtos = corporations.stream().map(this::convertToDto).collect(Collectors.toList());
        return ResultData.success(dtos);
    }

    @Override
    public BaseEntityService<Corporation> getService() {
        return service;
    }

    /**
     * 获取所有业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<CorporationDto>> findAll() {
        return ResultData.success(convertToDtos(service.findAll()));
    }

    /**
     * 获取所有未冻结的业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<CorporationDto>> findAllUnfrozen() {
        return ResultData.success(convertToDtos(service.findAllUnfrozen()));
    }
}
