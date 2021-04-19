package com.changhong.sei.dms.general.service.excel.impl;

import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.common.excel.BaseExcelService;
import com.changhong.sei.dms.general.entity.HrOrganization;
import com.changhong.sei.dms.general.service.excel.HrOrganizationExcelService;
import com.changhong.sei.dms.general.service.excel.vo.HrOrganizationVo;

/**
 * 实现功能:
 *
 * @author 冯华
 * @create 2021-04-19 15:30
 */
public class DefaultHrOrganizationExcelService extends BaseExcelService<HrOrganization, HrOrganizationVo> implements HrOrganizationExcelService {

    public DefaultHrOrganizationExcelService(BaseEntityService<HrOrganization> service) {
        super(service);
    }

}
