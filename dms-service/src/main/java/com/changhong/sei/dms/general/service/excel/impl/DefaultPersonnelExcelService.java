package com.changhong.sei.dms.general.service.excel.impl;

import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.common.excel.BaseExcelService;
import com.changhong.sei.dms.general.entity.Personnel;
import com.changhong.sei.dms.general.service.excel.PersonnelExcelService;
import com.changhong.sei.dms.general.service.excel.vo.PersonnelVo;

/**
 * 实现功能:
 *
 * @author 冯华
 * @create 2021-04-19 13:36
 */
public class DefaultPersonnelExcelService extends BaseExcelService<Personnel, PersonnelVo> implements PersonnelExcelService {

    public DefaultPersonnelExcelService(BaseEntityService<Personnel> service) {
        super(service);
    }

}