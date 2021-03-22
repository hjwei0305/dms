package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.TaxRateDao;
import com.changhong.sei.dms.general.entity.TaxRate;
import org.springframework.stereotype.Service;

/**
 * @Author: 刘松林
 * @Contact: songlin.liu@changhong.com
 * @Date: 2020/3/12 15:55
 * @Description:
 */
@Service
public class TaxRateService extends BaseEntityService<TaxRate> {

    private TaxRateDao taxRateDao;

    public TaxRateService(TaxRateDao taxRateDao){
        this.taxRateDao = taxRateDao;
    }

    @Override
    protected BaseEntityDao<TaxRate> getDao() {
        return this.taxRateDao;
    }
}
