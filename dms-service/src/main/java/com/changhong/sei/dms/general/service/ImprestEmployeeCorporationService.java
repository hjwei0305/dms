package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.ImprestEmployeeCorporationDao;
import com.changhong.sei.dms.general.entity.ImprestEmployeeCorporation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 公司的备用金员工(ERP)(ImprestEmployeeCorporation)业务逻辑实现类
 *
 * @author sei
 * @since 2021-04-20 17:06:39
 */
@Service("imprestEmployeeCorporationService")
public class ImprestEmployeeCorporationService extends BaseEntityService<ImprestEmployeeCorporation> {
    @Autowired
    private ImprestEmployeeCorporationDao dao;

    @Override
    protected BaseEntityDao<ImprestEmployeeCorporation> getDao() {
        return dao;
    }

}