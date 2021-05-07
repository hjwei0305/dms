package com.changhong.sei.dms.general.service.excel.impl;

import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.common.excel.BaseExcelService;
import com.changhong.sei.dms.general.entity.BankCategory;
import com.changhong.sei.dms.general.entity.BankProvinces;
import com.changhong.sei.dms.general.service.excel.BankCategoryExcelService;
import com.changhong.sei.dms.general.service.excel.BankProvincesExcelService;
import com.changhong.sei.dms.general.service.excel.vo.BankCategoryVo;
import com.changhong.sei.dms.general.service.excel.vo.BankProvincesVo;

/**
 * 实现功能: 银行省区(BankProvinces)导入导出服务
 *
 * @author 冯华
 * @create 2021-04-16 11:37
 */
public class DefaultBankProvincesExcelService extends BaseExcelService<BankProvinces, BankProvincesVo> implements BankProvincesExcelService {

    public DefaultBankProvincesExcelService(BaseEntityService<BankProvinces> service) {
        super(service);
    }

}
