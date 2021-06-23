package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.TaxTypeDao;
import com.changhong.sei.dms.general.entity.TaxType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 税类型(TaxType)业务逻辑实现类
 *
 * @author 杨沄炜
 * @since 2021/06/23 8:30
 */
@Service("taxTypeService")
public class TaxTypeService extends BaseEntityService<TaxType>{
    @Autowired
    private TaxTypeDao dao;

    @Override
    protected BaseEntityDao<TaxType> getDao() { return dao; }
}