package com.changhong.sei.dms.general.service.excel.impl;

import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.common.excel.BaseExcelService;
import com.changhong.sei.dms.general.entity.Currency;
import com.changhong.sei.dms.general.service.CurrencyService;
import com.changhong.sei.dms.general.service.excel.CurrencyExcelService;
import com.changhong.sei.dms.general.service.excel.vo.CurrencyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 实现功能：币种导入导出服务
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-10-12 00:35
 */
public class DefaultCurrencyExcelService extends BaseExcelService<Currency, CurrencyVo> implements CurrencyExcelService {

    public DefaultCurrencyExcelService(BaseEntityService<Currency> service) {
        super(service);
    }

}
