package com.changhong.sei.dms.general.service.excel.impl;

import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.common.excel.BaseExcelService;
import com.changhong.sei.dms.general.entity.BankCity;
import com.changhong.sei.dms.general.service.excel.BankCityExcelService;
import com.changhong.sei.dms.general.service.excel.vo.BankCityVo;

/**
 * 实现功能: 银行城市(BankCity)导入导出服务
 *
 * @author 冯华
 * @create 2021-04-16 11:37
 */
public class DefaultBankCityExcelService extends BaseExcelService<BankCity, BankCityVo> implements BankCityExcelService {

    public DefaultBankCityExcelService(BaseEntityService<BankCity> service) {
        super(service);
    }

}
