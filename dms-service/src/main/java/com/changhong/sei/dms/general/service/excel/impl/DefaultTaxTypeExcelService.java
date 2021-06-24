package com.changhong.sei.dms.general.service.excel.impl;

import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.common.excel.BaseExcelService;
import com.changhong.sei.dms.general.entity.TaxType;
import com.changhong.sei.dms.general.service.excel.TaxTypeExcelService;
import com.changhong.sei.dms.general.service.excel.vo.TaxTypeVo;

/**
 * 实现功能:
 *
 * @author 杨沄炜
 * @date 2021/06/24 9:30
 */
public class DefaultTaxTypeExcelService extends BaseExcelService<TaxType, TaxTypeVo> implements TaxTypeExcelService {

    public DefaultTaxTypeExcelService(BaseEntityService<TaxType> service) { super(service); }
}
