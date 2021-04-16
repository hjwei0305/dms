package com.changhong.sei.dms.general.service.excel.impl;

import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.common.excel.BaseExcelService;
import com.changhong.sei.dms.general.entity.CostCenter;
import com.changhong.sei.dms.general.service.excel.CostCenterExcelService;
import com.changhong.sei.dms.general.service.excel.vo.CostCenterVo;

/**
 * 实现功能: 成本中心导入导出服务
 *
 * @author 冯华
 * @create 2021-04-16 11:42
 */
public class DefaultCostCenterExcelService extends BaseExcelService<CostCenter, CostCenterVo> implements CostCenterExcelService {

    public DefaultCostCenterExcelService(BaseEntityService<CostCenter> service) {
        super(service);
    }

}
