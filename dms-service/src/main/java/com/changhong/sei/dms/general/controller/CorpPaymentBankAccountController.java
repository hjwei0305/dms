package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.ResponseData;
import com.changhong.sei.core.utils.ResultDataUtil;
import com.changhong.sei.dms.general.api.CorpPaymentBankAccountApi;
import com.changhong.sei.dms.general.dto.BankDto;
import com.changhong.sei.dms.general.dto.CorpPaymentBankAccountDto;
import com.changhong.sei.dms.general.dto.PaymentInfoDto;
import com.changhong.sei.dms.general.dto.ReceiverTypeEnum;
import com.changhong.sei.dms.general.entity.*;
import com.changhong.sei.dms.general.service.CorpPaymentBankAccountService;
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
 * 公司的付款银行账号信息(CorpPaymentBankAccount)控制类
 *
 * @author sei
 * @since 2021-07-01 16:10:13
 */
@RestController
@Api(value = "CorpPaymentBankAccountApi", tags = "公司的付款银行账号信息服务")
@RequestMapping(path = CorpPaymentBankAccountApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class CorpPaymentBankAccountController extends BaseEntityController<CorpPaymentBankAccount, CorpPaymentBankAccountDto> implements CorpPaymentBankAccountApi {
    /**
     * 公司的付款银行账号信息服务对象
     */
    @Autowired
    private CorpPaymentBankAccountService service;
    /**
     * 银行控制类
     */
    @Autowired
    private BankController bankController;
    @Autowired
    private ModelMapper mapper;

    @Override
    public BaseEntityService<CorpPaymentBankAccount> getService() {
        return service;
    }


    /**
     * 根据公司代码查询付款银行账号信息
     *
     * @param corporationCode 公司代码
     * @return 付款银行账号信息
     */
    @Override
    public ResultData<List<CorpPaymentBankAccountDto>> findByCorp(String corporationCode) {
        ResponseData<List<CorpPaymentBankAccount>> responseData = service.findByCorp(corporationCode);
        return ResultDataUtil.convertFromResponseData(responseData, convertToDtos(responseData.getData()));
    }

    /**
     * 根据公司代码和币种获取付款银行账号信息
     *
     * @param corporationCode 公司代码
     * @param currencyCode    币种
     * @return 科目映射付款方信息清单
     */
    @Override
    public ResultData<List<CorpPaymentBankAccountDto>> findByCorpAndCurrency(String corporationCode, String currencyCode) {
        ResponseData<List<CorpPaymentBankAccount>> responseData = service.findByCorpAndCurrency(corporationCode, currencyCode);
        return ResultDataUtil.convertFromResponseData(responseData, convertToDtos(responseData.getData()));
    }

    /**
     * 根据公司代码和币种获取默认的付款银行账号信息
     *
     * @param corporationCode 公司代码
     * @param currencyCode    币种
     * @return 付款方信息
     */
    @Override
    public ResultData<CorpPaymentBankAccountDto> findDefaultByCorpAndCurrency(String corporationCode, String currencyCode) {
        ResponseData<CorpPaymentBankAccount> responseData = service.findDefaultByCorpAndCurrency(corporationCode, currencyCode);
        return ResultDataUtil.convertFromResponseData(responseData, convertToDto(responseData.getData()));
    }

    /**
     * 根据公司代码和银行行别代码获取付款银行账号信息
     *
     * @param corporationCode  公司代码
     * @param bankCategoryCode 银行行别代码
     * @return 科目映射付款方信息清单
     */
    @Override
    public ResultData<List<CorpPaymentBankAccountDto>> findByCorpAndBankCategory(String corporationCode, String bankCategoryCode) {
        ResponseData<List<CorpPaymentBankAccount>> responseData = service.findByCorpAndBankCategory(corporationCode, bankCategoryCode);
        return ResultDataUtil.convertFromResponseData(responseData, convertToDtos(responseData.getData()));
    }

    /**
     * 设置默认
     *
     * @param id Id
     * @return 结果
     */
    @Override
    public ResultData<?> setAsDefault(String id) {
        ResponseData<?> responseData = service.setAsDefault(id);
        return ResultDataUtil.convertFromResponseData(responseData, null);
    }


    /**
     * 将数据实体清单转换成DTO清单
     *
     * @param entities 数据实体清单
     * @return DTO清单
     */
    @Override
    public List<CorpPaymentBankAccountDto> convertToDtos(List<CorpPaymentBankAccount> entities) {
        if (Objects.isNull(entities)) {
            return null;
        }
        if (CollectionUtils.isEmpty(entities)) {
            return new ArrayList<>();
        }
        Map<String, BankDto> bankMap = new HashMap<>();
        List<String> bankIdList = entities.parallelStream().map(CorpPaymentBankAccount::getBankId).collect(Collectors.toList());
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
    public CorpPaymentBankAccountDto convertToDto(CorpPaymentBankAccount entity) {
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
    private CorpPaymentBankAccountDto convertToDto(CorpPaymentBankAccount entity, Map<String, BankDto> bankMap) {
        if (Objects.isNull(entity)) {
            return null;
        }
        CorpPaymentBankAccountDto dto = mapper.map(entity, CorpPaymentBankAccountDto.class);
        if (StringUtils.isNotBlank(entity.getBankId())
                && !bankMap.isEmpty() && bankMap.containsKey(entity.getBankId())) {
            BankDto bankDto = bankMap.get(entity.getBankId());
            dto.setBankCode(bankDto.getCode());
            dto.setBankName(bankDto.getName());
            dto.setBankCategoryCode(bankDto.getBankCategoryCode());
            dto.setBankCategoryName(bankDto.getBankCategoryName());
            dto.setCountryCode(bankDto.getCountryCode());
            dto.setCountryName(bankDto.getCountryName());
            dto.setBankProvinceCode(bankDto.getBankProvinceCode());
            dto.setBankRegionProvinceCode(bankDto.getRegionProvinceCode());
            dto.setBankProvinceName(bankDto.getBankProvinceName());
            dto.setBankCityCode(bankDto.getBankCityCode());
            dto.setBankRegionCityCode(bankDto.getRegionCityCode());
            dto.setBankCityName(bankDto.getBankCityName());
            dto.setBankAreaCode(bankDto.getBankAreaCode());
            dto.setBankAreaName(bankDto.getBankAreaName());
            dto.setErpBankCode(bankDto.getErpBankCode());
        }
        return dto;
    }
}