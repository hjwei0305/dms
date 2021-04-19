package com.changhong.sei.dms.general.service.excel.impl;

import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.common.excel.BaseExcelService;
import com.changhong.sei.dms.general.entity.WbsProject;
import com.changhong.sei.dms.general.service.excel.WbsProjectExcelService;
import com.changhong.sei.dms.general.service.excel.vo.WbsProjectVo;

/**
 * 实现功能:
 *
 * @author 冯华
 * @create 2021-04-19 17:35
 */
public class DefaultWbsProjectExcelService extends BaseExcelService<WbsProject, WbsProjectVo> implements WbsProjectExcelService {

    public DefaultWbsProjectExcelService(BaseEntityService<WbsProject> service) {
        super(service);
    }

}
