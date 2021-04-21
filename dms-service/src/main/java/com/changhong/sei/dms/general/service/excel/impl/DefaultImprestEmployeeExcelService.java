package com.changhong.sei.dms.general.service.excel.impl;

import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.common.excel.BaseExcelService;
import com.changhong.sei.dms.general.entity.ImprestEmployee;
import com.changhong.sei.dms.general.service.excel.ImprestEmployeeExcelService;
import com.changhong.sei.dms.general.service.excel.vo.ImprestEmployeeVo;

/**
 * 实现功能:备用金员工(ImprestEmployee)导入导出服务
 *
 * @author 冯华
 * @create 2021-04-20 17:01
 */
public class DefaultImprestEmployeeExcelService extends BaseExcelService<ImprestEmployee, ImprestEmployeeVo> implements ImprestEmployeeExcelService {

    public DefaultImprestEmployeeExcelService(BaseEntityService<ImprestEmployee> service) {
        super(service);
    }

}
