package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.utils.ResultDataUtil;
import com.changhong.sei.dms.general.api.PersonnelApi;
import com.changhong.sei.dms.general.dto.CashFlowCodeDto;
import com.changhong.sei.dms.general.dto.PersonnelDto;
import com.changhong.sei.dms.general.dto.WorkingStatusEnum;
import com.changhong.sei.dms.general.entity.Personnel;
import com.changhong.sei.dms.general.service.PersonnelService;
import com.changhong.sei.dms.management.dto.ConfigTypeEnum;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 公司员工(ERP)(Personnel)控制类
 *
 * @author sei
 * @since 2021-04-19 10:18:20
 */
@RestController
@Api(value = "PersonnelApi", tags = "公司员工(ERP)服务")
@RequestMapping(path = PersonnelApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonnelController extends BaseEntityController<Personnel, PersonnelDto> implements PersonnelApi {
    /**
     * 公司员工(ERP)服务对象
     */
    @Autowired
    private PersonnelService service;

    @Override
    public BaseEntityService<Personnel> getService() {
        return service;
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<PersonnelDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }

    /**
     * 获取在职状态
     */
    @Override
    public ResultData<Map<String, String>> getWorkingStatus() {
        return ResultDataUtil.getEnumMap(WorkingStatusEnum.class);
    }

    /**
     * 根据员工编号获取员工
     *
     * @param code 员工编号
     * @return 员工
     */
    @Override
    public ResultData<PersonnelDto> findByCode(String code) {
        return ResultData.success(convertToDto(service.findByCode(code)));
    }

}