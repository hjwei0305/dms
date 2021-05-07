package com.changhong.sei.dms.general.service.excel.impl;

import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.common.excel.BaseExcelService;
import com.changhong.sei.dms.general.entity.BankCategory;
import com.changhong.sei.dms.general.service.excel.BankCategoryExcelService;
import com.changhong.sei.dms.general.service.excel.vo.BankCategoryVo;

/**
 * 实现功能: 银行类别(BankCategory)导入导出服务
 *
 * @author 冯华
 * @create 2021-04-16 11:37
 */
public class DefaultBankCategoryExcelService extends BaseExcelService<BankCategory, BankCategoryVo> implements BankCategoryExcelService {

    public DefaultBankCategoryExcelService(BaseEntityService<BankCategory> service) {
        super(service);
    }

}
