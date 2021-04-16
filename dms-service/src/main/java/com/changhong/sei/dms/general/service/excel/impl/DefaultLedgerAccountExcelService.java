package com.changhong.sei.dms.general.service.excel.impl;

import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.common.excel.BaseExcelService;
import com.changhong.sei.dms.general.entity.LedgerAccount;
import com.changhong.sei.dms.general.service.excel.LedgerAccountExcelService;
import com.changhong.sei.dms.general.service.excel.vo.LedgerAccountVo;

/**
 * 实现功能: 总帐科目(LedgerAccount)导入导出服务
 *
 * @author 冯华
 * @create 2021-04-16 16:23
 */
public class DefaultLedgerAccountExcelService extends BaseExcelService<LedgerAccount, LedgerAccountVo> implements LedgerAccountExcelService {

    public DefaultLedgerAccountExcelService(BaseEntityService<LedgerAccount> service) {
        super(service);
    }

}
