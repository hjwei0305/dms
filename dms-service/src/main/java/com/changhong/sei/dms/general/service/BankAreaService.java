package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.dto.serach.SearchFilter;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.BankAreaDao;
import com.changhong.sei.dms.general.entity.BankArea;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;


/**
 * 银行地区(BankArea)业务逻辑实现类
 *
 * @author sei
 * @since 2021-05-07 15:55:10
 */
@Service("bankAreaService")
public class BankAreaService extends BaseEntityService<BankArea> {
    @Autowired
    private BankAreaDao dao;

    @Override
    protected BaseEntityDao<BankArea> getDao() {
        return dao;
    }


    /**
     * 基于动态组合条件对象和分页(含排序)对象查询数据集合
     */
    @Override
    public PageResult<BankArea> findByPage(Search searchConfig) {
        Collection<String> quickSearchProperties = searchConfig.getQuickSearchProperties();
        if (CollectionUtils.isNotEmpty(quickSearchProperties) && quickSearchProperties.contains("regionName")) {
            quickSearchProperties.remove("regionName");
            quickSearchProperties.add("region.name");
        }
        return getDao().findByPage(searchConfig);
    }
}