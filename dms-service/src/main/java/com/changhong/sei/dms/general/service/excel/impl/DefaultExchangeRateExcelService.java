package com.changhong.sei.dms.general.service.excel.impl;

import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.common.excel.BaseExcelService;
import com.changhong.sei.dms.general.entity.CashFlowCode;
import com.changhong.sei.dms.general.entity.ExchangeRate;
import com.changhong.sei.dms.general.service.excel.CashFlowCodeExcelService;
import com.changhong.sei.dms.general.service.excel.ExchangeRateExcelService;
import com.changhong.sei.dms.general.service.excel.vo.CashFlowCodeVo;
import com.changhong.sei.dms.general.service.excel.vo.ExchangeRateVo;

/**
 * 实现功能: 汇率导入导出服务
 *
 * @author 冯华
 * @create 2021-04-16 11:37
 */
public class DefaultExchangeRateExcelService extends BaseExcelService<ExchangeRate, ExchangeRateVo> implements ExchangeRateExcelService {

    public DefaultExchangeRateExcelService(BaseEntityService<ExchangeRate> service) {
        super(service);
    }

}
