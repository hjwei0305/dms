package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.BankDao;
import com.changhong.sei.dms.general.entity.Bank;
import com.changhong.sei.dms.general.entity.BankProvinces;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


/**
 * 银行(Bank)业务逻辑实现类
 *
 * @author sei
 * @since 2021-06-25 11:10:33
 */
@Service("bankService")
public class BankService extends BaseEntityService<Bank> {
    @Autowired
    private BankDao dao;

    @Override
    protected BaseEntityDao<Bank> getDao() {
        return dao;
    }


    /**
     * 基于动态组合条件对象和分页(含排序)对象查询数据集合
     */
    @Override
    public PageResult<Bank> findByPage(Search searchConfig) {
        Collection<String> quickSearchProperties = searchConfig.getQuickSearchProperties();
        if (CollectionUtils.isNotEmpty(quickSearchProperties) && quickSearchProperties.contains("regionName")) {
            quickSearchProperties.remove("bankAreaName");
            quickSearchProperties.add("bankArea.name");
        }
        return getDao().findByPage(searchConfig);
    }


    /**
     * 获取一个银行
     *
     * @param code 代码
     * @return 银行
     */
    public Bank findByCode(String code) {
        return dao.findFirstByCode(code);
    }
}