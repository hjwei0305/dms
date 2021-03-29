package com.changhong.sei.dms.general.service.excel.impl;

import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.common.excel.BaseExcelService;
import com.changhong.sei.dms.general.entity.Country;
import com.changhong.sei.dms.general.service.CountryService;
import com.changhong.sei.dms.general.service.excel.CountryExcelService;
import com.changhong.sei.dms.general.service.excel.vo.CountryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 实现功能：国家导入导出服务
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-10-12 00:35
 */
public class DefaultCountryExcelService extends BaseExcelService<Country, CountryVo> implements CountryExcelService {

    public DefaultCountryExcelService(BaseEntityService<Country> service) {
        super(service);
    }

}
