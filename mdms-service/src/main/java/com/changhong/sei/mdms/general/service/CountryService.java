package com.changhong.sei.mdms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.mdms.general.dao.CountryDao;
import com.changhong.sei.mdms.general.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 国家(Country)业务逻辑实现类
 *
 * @author sei
 * @since 2020-08-17 14:02:42
 */
@Service("countryService")
public class CountryService extends BaseEntityService<Country> {
    @Autowired
    private CountryDao dao;

    @Override
    protected BaseEntityDao<Country> getDao() {
        return dao;
    }

}