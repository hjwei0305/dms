package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.BankProvincesDao;
import com.changhong.sei.dms.general.entity.BankCity;
import com.changhong.sei.dms.general.entity.BankProvinces;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


/**
 * 银行省区(BankProvinces)业务逻辑实现类
 *
 * @author sei
 * @since 2021-05-07 14:34:39
 */
@Service("bankProvincesService")
public class BankProvincesService extends BaseEntityService<BankProvinces> {
    @Autowired
    private BankProvincesDao dao;

    @Override
    protected BaseEntityDao<BankProvinces> getDao() {
        return dao;
    }



    /**
     * 基于动态组合条件对象和分页(含排序)对象查询数据集合
     */
    @Override
    public PageResult<BankProvinces> findByPage(Search searchConfig) {
        Collection<String> quickSearchProperties = searchConfig.getQuickSearchProperties();
        if (CollectionUtils.isNotEmpty(quickSearchProperties) && quickSearchProperties.contains("regionName")) {
            quickSearchProperties.remove("regionName");
            quickSearchProperties.add("region.name");
        }
        return getDao().findByPage(searchConfig);
    }
}