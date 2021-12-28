package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.api.ProfitCenterApi;
import com.changhong.sei.dms.general.dto.ProfitCenterDto;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import com.changhong.sei.dms.general.entity.ProfitCenter;
import com.changhong.sei.dms.general.service.ProfitCenterService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 利润中心(ProfitCenter)控制类
 *
 * @author sei
 * @since 2021-07-30 14:57:53
 */
@RestController
@Api(value = "ProfitCenterApi", tags = "利润中心服务")
@RequestMapping(path = ProfitCenterApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfitCenterController extends BaseEntityController<ProfitCenter, ProfitCenterDto> implements ProfitCenterApi {
    /**
     * 利润中心服务对象
     */
    @Autowired
    private ProfitCenterService service;

    @Override
    public BaseEntityService<ProfitCenter> getService() {
        return service;
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<ProfitCenterDto>> findByPage(Search search){
        return convertToDtoPageResult(service.findByPage(search));
    }

    /**
     * 根据代码查询利润中心
     *
     * @param code 代码
     * @return 利润中心
     */
    @Override
    public ResultData<ProfitCenterDto> findByCode(String code) {
        return ResultData.success(convertToDto(service.findByCode(code)));
    }

    /**
     * 分页查询利润中心
     *
     * @param searchParam 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<ProfitCenterDto>> search(ErpCodeQuickSearchParam searchParam) {
        return convertToDtoPageResult(service.search(searchParam));
    }
}