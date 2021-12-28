package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.dto.serach.SearchFilter;
import com.changhong.sei.core.dto.serach.SearchOrder;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.core.service.bo.ResponseData;
import com.changhong.sei.dms.general.dao.ExchangeRateDao;
import com.changhong.sei.dms.general.entity.ExchangeRate;
import com.changhong.sei.util.DateUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


/**
 * 汇率(ExchangeRate)业务逻辑实现类
 *
 * @author sei
 * @since 2021-05-06 17:04:03
 */
@Service("exchangeRateService")
public class ExchangeRateService extends BaseEntityService<ExchangeRate> {
    @Autowired
    private ExchangeRateDao dao;

    @Override
    protected BaseEntityDao<ExchangeRate> getDao() {
        return dao;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public OperateResultWithData<ExchangeRate> save(ExchangeRate entity) {
        //代码：汇率类型、起始日期、货币（从）、货币（到）
        String code = String.format("%s%s%s%s", entity.getRateType(),
                DateUtils.formatDate(entity.getStartDate(), DateUtils.DEFAULT_DATE_FORMAT),
                entity.getFromCurrency(), entity.getToCurrency());
        ExchangeRate exist = findFirstByProperty("code", code);
        if (Objects.nonNull(exist) && !Objects.equals(exist.getId(), entity.getId())) {
            //00025 = 已存在相同记录，请检查！
            return OperateResultWithData.operationFailure("00025");
        }
        entity.setCode(code);
        return super.save(entity);
    }


    /**
     * 根据两个货币之间的汇率(有效期内)
     *
     * @param fromCurrency 货币（从）
     * @param toCurrency   货币（到）
     */
    public ResponseData<ExchangeRate> getValidExchangeRate(String fromCurrency, String toCurrency) {
        if (StringUtils.isBlank(fromCurrency) || StringUtils.isBlank(toCurrency)) {
            //来源币种或目标币种不能为空，请检查！
            return ResponseData.operationFailure(ContextUtil.getMessage("00054"));
        }
        Search search = Search.createSearch();
        search.addFilter(new SearchFilter("fromCurrency", fromCurrency));
        search.addFilter(new SearchFilter("toCurrency", toCurrency));
        search.addFilter(new SearchFilter("startDate", DateUtils.getCurrentDate(), SearchFilter.Operator.LE));
        search.addSortOrder(new SearchOrder("startDate", SearchOrder.Direction.DESC));
        ExchangeRate exchangeRate = findFirstByFilters(search);
        return ResponseData.operationSuccessWithData(exchangeRate);
    }

}