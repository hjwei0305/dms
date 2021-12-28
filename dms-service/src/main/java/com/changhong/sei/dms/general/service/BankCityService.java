package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.BankCityDao;
import com.changhong.sei.dms.general.entity.BankArea;
import com.changhong.sei.dms.general.entity.BankCity;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


/**
 * 银行城市(BankCity)业务逻辑实现类
 *
 * @author sei
 * @since 2021-05-07 15:13:01
 */
@Service("bankCityService")
public class BankCityService extends BaseEntityService<BankCity> {
    @Autowired
    private BankCityDao dao;

    @Override
    protected BaseEntityDao<BankCity> getDao() {
        return dao;
    }



    /**
     * 基于动态组合条件对象和分页(含排序)对象查询数据集合
     */
    @Override
    public PageResult<BankCity> findByPage(Search searchConfig) {
        Collection<String> quickSearchProperties = searchConfig.getQuickSearchProperties();
        if (CollectionUtils.isNotEmpty(quickSearchProperties) && quickSearchProperties.contains("regionName")) {
            quickSearchProperties.remove("regionName");
            quickSearchProperties.add("region.name");
        }
        return getDao().findByPage(searchConfig);
    }

}