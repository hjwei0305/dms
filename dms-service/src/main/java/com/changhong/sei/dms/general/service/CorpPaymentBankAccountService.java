package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.dto.serach.SearchFilter;
import com.changhong.sei.core.entity.ITenant;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.Validation;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.core.service.bo.ResponseData;
import com.changhong.sei.dms.general.dao.CorpPaymentBankAccountDao;
import com.changhong.sei.dms.general.dto.CorpPaymentBankAccountDto;
import com.changhong.sei.dms.general.entity.CorpPaymentBankAccount;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * 公司的付款银行账号信息(CorpPaymentBankAccount)业务逻辑实现类
 *
 * @author sei
 * @since 2021-07-01 16:10:12
 */
@Service("corpPaymentBankAccountService")
public class CorpPaymentBankAccountService extends BaseEntityService<CorpPaymentBankAccount> {
    @Autowired
    private CorpPaymentBankAccountDao dao;

    @Override
    protected BaseEntityDao<CorpPaymentBankAccount> getDao() {
        return dao;
    }


    /**
     * 数据保存操作
     */
    @Override
    public OperateResultWithData<CorpPaymentBankAccount> save(CorpPaymentBankAccount entity) {
        CorpPaymentBankAccount exist = findByProperty("bankAccountNumber", entity.getBankAccountNumber());
        if (Objects.nonNull(exist) && !Objects.equals(entity.getId(), exist.getId())) {
            //00032 = 该银行账号已存在，请检查！
            return OperateResultWithData.operationFailure("00032");
        }
        return super.save(entity);
    }

    /**
     * 根据公司代码查询付款银行账号信息
     *
     * @param corporationCode 公司代码
     * @return 付款银行账号信息
     */
    public ResponseData<List<CorpPaymentBankAccount>> findByCorp(String corporationCode) {
        List<CorpPaymentBankAccount> result = new ArrayList<>();
        if (StringUtils.isNotBlank(corporationCode)) {
            result = findListByProperty("corporationCode", corporationCode);
        }
        return ResponseData.operationSuccessWithData(result);
    }

    /**
     * 根据公司代码和币种获取付款银行账号信息
     *
     * @param corporationCode 公司代码
     * @param currencyCode    币种
     * @return 科目映射付款方信息清单
     */
    public ResponseData<List<CorpPaymentBankAccount>> findByCorpAndCurrency(String corporationCode, String currencyCode) {
        List<CorpPaymentBankAccount> result = new ArrayList<>();
        if (StringUtils.isNoneBlank(corporationCode, currencyCode)) {
            Search search = new Search();
            search.addFilter(new SearchFilter("corporationCode", corporationCode));
            search.addFilter(new SearchFilter("currency.code", currencyCode));
            result = findByFilters(search);
        }
        return ResponseData.operationSuccessWithData(result);
    }

    /**
     * 根据公司代码和币种获取默认的付款银行账号信息
     *
     * @param corporationCode 公司代码
     * @param currencyCode    币种
     * @return 付款方信息
     */
    public ResponseData<CorpPaymentBankAccount> findDefaultByCorpAndCurrency(String corporationCode, String currencyCode) {
        CorpPaymentBankAccount result = null;
        if (StringUtils.isNoneBlank(corporationCode, currencyCode)) {
            Search search = new Search();
            search.addFilter(new SearchFilter("corporationCode", corporationCode));
            search.addFilter(new SearchFilter("currency.code", currencyCode));
            List<CorpPaymentBankAccount> bankAccountList = findByFilters(search);
            if (CollectionUtils.isNotEmpty(bankAccountList)) {
                result = bankAccountList.parallelStream().filter(CorpPaymentBankAccount::getDefaultTag).findFirst().orElse(null);
                if (Objects.isNull(result)) {
                    result = bankAccountList.get(0);
                }
            }
        }
        return ResponseData.operationSuccessWithData(result);
    }

    /**
     * 根据公司代码和银行行别代码获取付款银行账号信息
     *
     * @param corporationCode  公司代码
     * @param bankCategoryCode 银行行别代码
     * @return 科目映射付款方信息清单
     */
    public ResponseData<List<CorpPaymentBankAccount>> findByCorpAndBankCategory(String corporationCode, String bankCategoryCode) {
        List<CorpPaymentBankAccount> result = new ArrayList<>();
        if (StringUtils.isNoneBlank(corporationCode, bankCategoryCode)) {
            Search search = new Search();
            search.addFilter(new SearchFilter("corporationCode", corporationCode));
            search.addFilter(new SearchFilter("bank.bankCategory.code", bankCategoryCode));
            result = findByFilters(search);
        }
        return ResponseData.operationSuccessWithData(result);
    }

    /**
     * 设置默认
     *
     * @param id Id
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseData<?> setAsDefault(String id) {
        CorpPaymentBankAccount paymentBankAccount = findOne(id);
        if (Objects.isNull(paymentBankAccount)) {
            // 00026 = 所选数据不存在，请检查！
            return ResponseData.operationFailure("00026");
        }
        Search search = new Search();
        search.addFilter(new SearchFilter("corporationCode", paymentBankAccount.getCorporationCode()));
        search.addFilter(new SearchFilter("currencyId", paymentBankAccount.getCurrencyId()));
        search.addFilter(new SearchFilter("defaultTag", Boolean.TRUE));
        search.addFilter(new SearchFilter("id", paymentBankAccount.getId(), SearchFilter.Operator.NE));
        CorpPaymentBankAccount defaultPaymentBankAccount = findOneByFilters(search);
        //更改默认：存在默认时，再次设置默认，去掉原数据默认标识
        if (Objects.nonNull(defaultPaymentBankAccount)) {
            defaultPaymentBankAccount.setDefaultTag(Boolean.FALSE);
            super.save(defaultPaymentBankAccount);
        }
        paymentBankAccount.setDefaultTag(Boolean.TRUE);
        return super.save(paymentBankAccount);
    }

    /**
     * 根据银行账号获取付款银行账号信息
     *
     * @param bankAccountNumber 银行账号
     * @return 付款方信息
     */
    public CorpPaymentBankAccount findByBankAccountNumber(String bankAccountNumber) {
        return dao.findByBankAccountNumber(bankAccountNumber, ContextUtil.getTenantCode());
    }
}