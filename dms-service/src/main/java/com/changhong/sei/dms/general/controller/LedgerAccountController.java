package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.dto.serach.SearchFilter;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResult;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.core.utils.ResultDataUtil;
import com.changhong.sei.dms.general.api.LedgerAccountApi;
import com.changhong.sei.dms.general.dto.LedgerAccountCorporationDto;
import com.changhong.sei.dms.general.dto.LedgerAccountDto;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import com.changhong.sei.dms.general.entity.LedgerAccount;
import com.changhong.sei.dms.general.entity.LedgerAccountCorporation;
import com.changhong.sei.dms.general.service.LedgerAccountCorporationService;
import com.changhong.sei.dms.general.service.LedgerAccountService;
import io.swagger.annotations.Api;
import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 总帐科目(LedgerAccount)控制类
 *
 * @author sei
 * @since 2021-04-16 16:16:21
 */
@RestController
@Api(value = "LedgerAccountApi", tags = "总帐科目服务")
@RequestMapping(path = LedgerAccountApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class LedgerAccountController extends BaseEntityController<LedgerAccount, LedgerAccountDto> implements LedgerAccountApi {
    /**
     * 总帐科目服务对象
     */
    @Autowired
    private LedgerAccountService service;
    /**
     * 总帐科目的公司信息服务对象
     */
    @Autowired
    private LedgerAccountCorporationService ledgerAccountCorporationService;

    @Override
    public BaseEntityService<LedgerAccount> getService() {
        return service;
    }

    /**
     * Entity与DTO的转换器
     */
    protected static final ModelMapper dtoModelMapper;

    // 初始化静态属性
    static {
        // 初始化Entity与DTO的转换器
        dtoModelMapper = new ModelMapper();
        // 设置为严格匹配
        dtoModelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * 快速查询公司的总账科目
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<LedgerAccountDto>> search(ErpCodeQuickSearchParam search) {
        return convertToDtoPageResult(service.search(search));
    }

    /**
     * 获取科目的公司信息
     *
     * @param ledgerAccountId 科目Id
     * @return 公司信息
     */
    @Override
    public ResultData<List<LedgerAccountCorporationDto>> getCorporationInfo(String ledgerAccountId) {
        List<LedgerAccountCorporation> ledgerAccountCorporationList = ledgerAccountCorporationService.findByFilter(new SearchFilter("ledgerAccountId", ledgerAccountId));
        return ResultData.success(corporationInfoConvertToDtos(ledgerAccountCorporationList));
    }

    /**
     * 保存科目的公司信息
     *
     * @param dto 科目的公司信息DTO
     * @return 操作结果
     */
    @Override
    public ResultData<LedgerAccountCorporationDto> saveCorporationInfo(@Valid LedgerAccountCorporationDto dto) {
        if (Objects.isNull(dto)) {
            // 输入的数据传输对象为空！
            return ResultData.fail(ContextUtil.getMessage("core_service_00002"));
        }
        LedgerAccountCorporation ledgerAccountCorporation = corporationInfoConvertToEntity(dto);
        OperateResultWithData<LedgerAccountCorporation> saveResult = ledgerAccountCorporationService.save(ledgerAccountCorporation);
        if (saveResult.notSuccessful()) {
            return ResultData.fail(saveResult.getMessage());
        }
        // 数据转换 to DTO
        LedgerAccountCorporationDto resultData = corporationInfoConvertToDto(saveResult.getData());
        return ResultData.success(saveResult.getMessage(), resultData);
    }

    /**
     * 删除科目的公司信息
     *
     * @param id 科目的公司信息Id
     * @return 操作结果
     */
    @Override
    public ResultData<?> deleteCorporationInfo(String id) {
        OperateResult result = ledgerAccountCorporationService.delete(id);
        return ResultDataUtil.convertFromOperateResult(result);
    }

    /**
     * 分页查询科目的公司信息
     *
     * @param search 查询参数
     * @return 查询结果
     */
    @Override
    public ResultData<PageResult<LedgerAccountCorporationDto>> findCorporationInfoByPage(Search search) {
        return corporationInfoConvertToDtoPageResult(ledgerAccountCorporationService.findByPage(search));
    }

    /**
     * 根据代码查询总账科目
     *
     * @param code 代码
     * @return 总账科目
     */
    @Override
    public ResultData<LedgerAccountDto> findByCode(String code) {
        return ResultData.success(convertToDto(service.findByCode(code)));
    }

    /**
     * 将科目的公司信息清单转换成DTO清单
     *
     * @param entities 数据实体清单
     * @return DTO清单
     */
    private List<LedgerAccountCorporationDto> corporationInfoConvertToDtos(List<LedgerAccountCorporation> entities) {
        if (Objects.isNull(entities)) {
            return null;
        }
        if (CollectionUtils.isEmpty(entities)) {
            return new ArrayList<>();
        }
        return entities.stream().map(this::corporationInfoConvertToDto).collect(Collectors.toList());
    }


    /**
     * 将科目的公司信息分页查询结果转换为返回结果
     *
     * @param pageResult 科目的公司信息分页查询结果
     * @return 返回结果
     */
    public ResultData<PageResult<LedgerAccountCorporationDto>> corporationInfoConvertToDtoPageResult(PageResult<LedgerAccountCorporation> pageResult) {
        PageResult<LedgerAccountCorporationDto> result = new PageResult<>(pageResult);
        List<LedgerAccountCorporationDto> dtos = corporationInfoConvertToDtos(pageResult.getRows());
        result.setRows(dtos);
        return ResultData.success(result);
    }

    /**
     * 将科目的公司信息转换成DTO
     *
     * @param entity 科目的公司信息
     * @return DTO
     */
    private LedgerAccountCorporationDto corporationInfoConvertToDto(LedgerAccountCorporation entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        LedgerAccountCorporationDto result = new LedgerAccountCorporationDto();
        dtoModelMapper.map(entity, result);
        return result;
    }

    /**
     * 将科目的公司信息DTO转换成实体
     *
     * @param dto 科目的公司信息DTO
     * @return 实体
     */
    private LedgerAccountCorporation corporationInfoConvertToEntity(LedgerAccountCorporationDto dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        LedgerAccountCorporation result = new LedgerAccountCorporation();
        dtoModelMapper.map(dto, result);
        return result;
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<LedgerAccountDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }
}