package com.changhong.sei.dms.general.service.excel.impl;

import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.common.excel.BaseExcelService;
import com.changhong.sei.dms.general.entity.CashFlowCode;
import com.changhong.sei.dms.general.service.excel.CashFlowCodeExcelService;
import com.changhong.sei.dms.general.service.excel.vo.CashFlowCodeVo;

/**
 * 实现功能: 现金流代码导入导出服务
 *
 * @author 冯华
 * @create 2021-04-16 11:37
 */
public class DefaultCashFlowCodeExcelService extends BaseExcelService<CashFlowCode, CashFlowCodeVo> implements CashFlowCodeExcelService {

    public DefaultCashFlowCodeExcelService(BaseEntityService<CashFlowCode> service) {
        super(service);
    }

}
