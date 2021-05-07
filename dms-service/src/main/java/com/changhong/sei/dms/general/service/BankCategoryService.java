package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.BankCategoryDao;
import com.changhong.sei.dms.general.entity.BankCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 银行类别(BankCategory)业务逻辑实现类
 *
 * @author sei
 * @since 2021-05-07 11:28:56
 */
@Service("bankCategoryService")
public class BankCategoryService extends BaseEntityService<BankCategory> {
    @Autowired
    private BankCategoryDao dao;

    @Override
    protected BaseEntityDao<BankCategory> getDao() {
        return dao;
    }

}