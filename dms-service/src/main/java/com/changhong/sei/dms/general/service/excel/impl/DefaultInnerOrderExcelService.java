package com.changhong.sei.dms.general.service.excel.impl;

import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.common.excel.BaseExcelService;
import com.changhong.sei.dms.general.entity.InnerOrder;
import com.changhong.sei.dms.general.service.excel.InnerOrderExcelService;
import com.changhong.sei.dms.general.service.excel.vo.InnerOrderVo;

/**
 * 实现功能: 内部订单导入导出服务
 *
 * @author 冯华
 * @create 2021-04-16 14:47
 */
public class DefaultInnerOrderExcelService extends BaseExcelService<InnerOrder, InnerOrderVo> implements InnerOrderExcelService {

    public DefaultInnerOrderExcelService(BaseEntityService<InnerOrder> service) {
        super(service);
    }

}