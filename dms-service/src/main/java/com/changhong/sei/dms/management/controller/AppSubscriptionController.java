package com.changhong.sei.dms.management.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.dto.serach.SearchFilter;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.dms.management.api.AppSubscriptionApi;
import com.changhong.sei.dms.management.dto.AppDto;
import com.changhong.sei.dms.management.dto.DataDefinitionDto;
import com.changhong.sei.dms.management.dto.SubscriptionDto;
import com.changhong.sei.dms.management.entity.App;
import com.changhong.sei.dms.management.entity.DataDefinition;
import com.changhong.sei.dms.management.entity.Subscription;
import com.changhong.sei.dms.management.service.AppService;
import com.changhong.sei.dms.management.service.DataDefinitionService;
import com.changhong.sei.dms.management.service.SubscriptionService;
import io.swagger.annotations.Api;
import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2021-02-22 11:09
 */
@RestController
@Api(value = "AppSubscriptionApi", tags = "应用数据订阅服务")
@RequestMapping(path = "appSubscription", produces = MediaType.APPLICATION_JSON_VALUE)
public class AppSubscriptionController implements AppSubscriptionApi {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AppService appService;
    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private DataDefinitionService dataDefinitionService;

    /**
     * 保存应用服务
     *
     * @param dto app DTO
     * @return 操作结果
     */
    @Override
    public ResultData<AppDto> saveApp(AppDto dto) {
        App app = modelMapper.map(dto, App.class);
        OperateResultWithData<App> result = appService.save(app);
        if (result.successful()) {
            return ResultData.success(modelMapper.map(result.getData(), AppDto.class));
        } else {
            return ResultData.fail(result.getMessage());
        }
    }

    /**
     * 分页查询应用服务
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<AppDto>> findByPage(Search search) {
        PageResult<App> pageResult = appService.findByPage(search);
        if (pageResult.getTotal() > 0) {
            PageResult<AppDto> dtoPageResult = new PageResult<>(pageResult);
            List<App> appList = pageResult.getRows();
            List<AppDto> appDtoList = appList.stream().map(a -> modelMapper.map(a, AppDto.class)).collect(Collectors.toList());
            dtoPageResult.setRows(appDtoList);
            return ResultData.success(dtoPageResult);
        } else {
            return ResultData.success(new PageResult<>());
        }
    }

    /**
     * 获取未分配的数据清单
     *
     * @param appCode appCode
     * @return 子实体清单
     */
    @Override
    public ResultData<List<DataDefinitionDto>> getUnassignedChildren(String appCode) {
        List<DataDefinitionDto> dtoList;
        List<DataDefinition> definitionList;
        List<Subscription> list = subscriptionService.findListByProperty(Subscription.FIELD_APP_CODE, appCode);
        if (CollectionUtils.isNotEmpty(list)) {
            Set<String> codeSet = list.stream().map(Subscription::getDataCode).collect(Collectors.toSet());

            Search search = Search.createSearch();
            search.addFilter(new SearchFilter(DataDefinition.CODE_FIELD, codeSet, SearchFilter.Operator.NOTIN));
            definitionList = dataDefinitionService.findByFilters(search);
        } else {
            definitionList = dataDefinitionService.findAllUnfrozen();
        }

        dtoList = definitionList.stream().map(s -> modelMapper.map(s, DataDefinitionDto.class)).collect(Collectors.toList());
        return ResultData.success(dtoList);
    }

    /**
     * 通过appCode获取订阅数据清单
     *
     * @param appCode appCode
     * @return 订阅数据清单
     */
    @Override
    public ResultData<List<SubscriptionDto>> getDataFromAppCode(String appCode) {
        List<SubscriptionDto> dtoList;
        List<Subscription> list = subscriptionService.findListByProperty(Subscription.FIELD_APP_CODE, appCode);
        if (CollectionUtils.isNotEmpty(list)) {
            dtoList = list.stream().map(s -> modelMapper.map(s, SubscriptionDto.class)).collect(Collectors.toList());
        } else {
            dtoList = new ArrayList<>();
        }
        return ResultData.success(dtoList);
    }

    /**
     * 通过dataCode获取应用订阅清单
     *
     * @param dataCode dataCode
     * @return 订阅数据清单
     */
    @Override
    public ResultData<List<SubscriptionDto>> getAppFromDataCode(String dataCode) {
        List<SubscriptionDto> dtoList;
        List<Subscription> list = subscriptionService.findListByProperty(Subscription.FIELD_DATA_CODE, dataCode);
        if (CollectionUtils.isNotEmpty(list)) {
            dtoList = list.stream().map(s -> modelMapper.map(s, SubscriptionDto.class)).collect(Collectors.toList());
        } else {
            dtoList = new ArrayList<>();
        }
        return ResultData.success(dtoList);
    }

    /**
     * 保存应用与数据订阅关系
     *
     * @param subscriptionDto 分配关系参数
     * @return 操作结果
     */
    @Override
    public ResultData<SubscriptionDto> saveRelation(SubscriptionDto subscriptionDto) {
        Subscription app = modelMapper.map(subscriptionDto, Subscription.class);
        OperateResultWithData<Subscription> result = subscriptionService.save(app);
        if (result.successful()) {
            return ResultData.success(modelMapper.map(result.getData(), SubscriptionDto.class));
        } else {
            return ResultData.fail(result.getMessage());
        }
    }

    /**
     * 移除分配关系
     *
     * @param subscriptionIds 分配关系参数
     * @return 操作结果
     */
    @Override
    public ResultData<Void> removeRelations(Set<String> subscriptionIds) {
        try {
            subscriptionService.delete(subscriptionIds);
            return ResultData.success();
        } catch (Exception e) {
            return ResultData.fail(e.getMessage());
        }
    }
}
