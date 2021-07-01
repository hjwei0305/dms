package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.ResponseData;
import com.changhong.sei.core.utils.ResultDataUtil;
import com.changhong.sei.dms.general.api.CorpPaymentBankAccountApi;
import com.changhong.sei.dms.general.dto.CorpPaymentBankAccountDto;
import com.changhong.sei.dms.general.entity.Bank;
import com.changhong.sei.dms.general.entity.BankCategory;
import com.changhong.sei.dms.general.entity.CorpPaymentBankAccount;
import com.changhong.sei.dms.general.service.CorpPaymentBankAccountService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

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
        CorpPaymentBankAccountDto dto = mapper.map(entity, getDtoClass());
        if (Objects.nonNull(entity.getCurrency())) {
            dto.setCurrencyCode(entity.getCurrency().getCode());
            dto.setCurrencyName(entity.getCurrency().getName());
        }
        Bank bank = entity.getBank();
        if (Objects.nonNull(bank)) {
            dto.setBankCode(bank.getCode());
            dto.setBankName(bank.getName());
            BankCategory bankCategory = bank.getBankCategory();
            if (Objects.nonNull(bankCategory)) {
                dto.setBankCategoryCode(bankCategory.getCode());
                dto.setBankCategoryName(bankCategory.getName());
            }
        }
        return dto;
    }
}