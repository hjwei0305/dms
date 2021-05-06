package com.changhong.sei.dms.general.service.excel.impl;

import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.common.excel.BaseExcelService;
import com.changhong.sei.dms.general.entity.Customer;
import com.changhong.sei.dms.general.entity.ImprestEmployee;
import com.changhong.sei.dms.general.service.excel.CustomerExcelService;
import com.changhong.sei.dms.general.service.excel.vo.CustomerVo;

/**
 * 实现功能:客户(Customer)导入导出服务
 *
 * @author 冯华
 * @create 2021-04-20 17:01
 */
public class DefaultCustomerExcelService extends BaseExcelService<Customer, CustomerVo> implements CustomerExcelService {

    public DefaultCustomerExcelService(BaseEntityService<Customer> service) {
        super(service);
    }

}
