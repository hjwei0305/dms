package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.dms.general.dao.ExchangeRateDao;
import com.changhong.sei.dms.general.entity.ExchangeRate;
import com.changhong.sei.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
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

}