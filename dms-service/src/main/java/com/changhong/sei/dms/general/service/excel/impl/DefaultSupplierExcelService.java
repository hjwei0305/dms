package com.changhong.sei.dms.general.service.excel.impl;

import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.common.excel.BaseExcelService;
import com.changhong.sei.dms.general.entity.Supplier;
import com.changhong.sei.dms.general.service.excel.SupplierExcelService;
import com.changhong.sei.dms.general.service.excel.vo.SupplierVo;

/**
 * 实现功能:供应商(Supplier)导入导出服务
 *
 * @author 冯华
 * @create 2021-04-20 17:01
 */
public class DefaultSupplierExcelService extends BaseExcelService<Supplier, SupplierVo> implements SupplierExcelService {

    public DefaultSupplierExcelService(BaseEntityService<Supplier> service) {
        super(service);
    }

}
