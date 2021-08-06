package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.ResponseData;
import com.changhong.sei.core.utils.ResultDataUtil;
import com.changhong.sei.dms.general.api.PaymentInfoApi;
import com.changhong.sei.dms.general.dto.*;
import com.changhong.sei.dms.general.entity.PaymentInfo;
import com.changhong.sei.dms.general.service.BankService;
import com.changhong.sei.dms.general.service.PaymentInfoService;
import com.changhong.sei.util.EnumUtils;
import io.swagger.annotations.Api;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 支付信息(PaymentInfo)控制类
 *
 * @author sei
 * @since 2021-06-29 09:17:28
 */
@RestController
@Api(value = "PaymentInfoApi", tags = "支付信息服务")
@RequestMapping(path = PaymentInfoApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class PaymentInfoController extends BaseEntityController<PaymentInfo, PaymentInfoDto>
        implements PaymentInfoApi {
    /**
     * 支付信息服务对象
     */
    @Autowired
    private PaymentInfoService service;
    /**
     * 银行控制类
     */
    @Autowired
    private BankController bankController;
    @Autowired(required = false)
    private ModelMapper mapper;

    @Override
    public BaseEntityService<PaymentInfo> getService() {
        return service;
    }

    /**
     * 通过收款对象代码获取支付信息清单
     *
     * @param receiverType 收款对象类型
     * @param useScope     使用范围
     * @param receiverCode 收款对象代码
     * @return 支付信息清单
     */
    @Override
    public ResultData<List<PaymentInfoDto>> findByReceiverCode(ReceiverTypeEnum receiverType, PaymentInfoUseScopeEnum useScope, String receiverCode) {
        ResponseData<List<PaymentInfo>> responseData = service.findByReceiverCode(receiverType, useScope, receiverCode);
        return ResultDataUtil.convertFromResponseData(responseData, convertToDtos(responseData.getData()));
    }

    /**
     * 通过银行账号获取收款方信息(银行账号右匹配)
     *
     * @param bankAccountNumber 银行账号
     * @param receiverType      收款对象类型:H-员工，K-供应商，D-客户
     * @return 支付信息
     */
    @Override
    public ResultData<ReceiverInfoDto> findReceiverInfoByBankAccountNumber(String bankAccountNumber, ReceiverTypeEnum receiverType) {
        return ResultData.success(service.findReceiverInfoByBankAccountNumber(bankAccountNumber, receiverType));
    }

    /**
     * 获取指定代码的收款方默认支付信息
     *
     * @param receiverType 收款对象类型
     * @param receiverCode 收款对象代码
     * @return 支付信息清单
     */
    @Override
    public ResultData<PaymentInfoDto> findDefaultPaymentInfo(String receiverType, String receiverCode) {
        ReceiverTypeEnum typeEnum = EnumUtils.getEnum(ReceiverTypeEnum.class, receiverType);
        return ResultData.success(convertToDto(service.findDefaultPaymentInfo(typeEnum, receiverCode)));
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<PaymentInfoDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }

    /**
     * 将数据实体清单转换成DTO清单
     *
     * @param entities 数据实体清单
     * @return DTO清单
     */
    @Override
    public List<PaymentInfoDto> convertToDtos(List<PaymentInfo> entities) {
        if (Objects.isNull(entities)) {
            return null;
        }
        if (CollectionUtils.isEmpty(entities)) {
            return new ArrayList<>();
        }
        Map<String, BankDto> bankMap = new HashMap<>();
        List<String> bankIdList = entities.parallelStream().map(PaymentInfo::getBankId).collect(Collectors.toList());
        List<BankDto> bankList = bankController.findByIds(bankIdList);
        if (CollectionUtils.isNotEmpty(bankList)) {
            bankMap = bankList.parallelStream().collect(Collectors.toMap(BaseEntityDto::getId, i -> i, (v1, v2) -> v2));
        }
        Map<String, BankDto> finalBankMap = bankMap;
        return entities.stream().map(i -> convertToDto(i, finalBankMap)).collect(Collectors.toList());
    }


    /**
     * 将数据实体转换成DTO
     *
     * @param entity 业务实体
     * @return DTO
     */
    @Override
    public PaymentInfoDto convertToDto(PaymentInfo entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        ResultData<BankDto> bankDtoResult = bankController.findOne(entity.getBankId());
        Map<String, BankDto> bankMap = new HashMap<>();
        if (bankDtoResult.getSuccess() && Objects.nonNull(bankDtoResult.getData())) {
            BankDto bankDto = bankDtoResult.getData();
            bankMap.put(bankDto.getId(), bankDto);
        }
        return convertToDto(entity, bankMap);
    }


    /**
     * 将数据实体转换成DTO(含银行信息)
     *
     * @param entity 业务实体
     * @return DTO
     */
    private PaymentInfoDto convertToDto(PaymentInfo entity, Map<String, BankDto> bankMap) {
        if (Objects.isNull(entity)) {
            return null;
        }
        PaymentInfoDto result = mapper.map(entity, PaymentInfoDto.class);
        if (StringUtils.isNotBlank(entity.getBankId())
                && !bankMap.isEmpty() && bankMap.containsKey(entity.getBankId())) {
            BankDto bankDto = bankMap.get(entity.getBankId());
            result.setBankCode(bankDto.getCode());
            result.setBankName(bankDto.getName());
            result.setBankCategoryCode(bankDto.getBankCategoryCode());
            result.setBankCategoryName(bankDto.getBankCategoryName());
            result.setCountryCode(bankDto.getCountryCode());
            result.setCountryName(bankDto.getCountryName());
            result.setBankProvinceCode(bankDto.getBankProvinceCode());
            result.setBankProvinceName(bankDto.getBankProvinceName());
            result.setBankCityCode(bankDto.getBankCityCode());
            result.setBankCityName(bankDto.getBankCityName());
            result.setBankAreaCode(bankDto.getBankAreaCode());
            result.setBankAreaName(bankDto.getBankAreaName());
            result.setErpBankCode(bankDto.getErpBankCode());
        }
        return result;
    }
}