package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.SupplierDao;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import com.changhong.sei.dms.general.entity.Customer;
import com.changhong.sei.dms.general.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 供应商(Supplier)业务逻辑实现类
 *
 * @author sei
 * @since 2021-05-06 14:07:30
 */
@Service("supplierService")
public class SupplierService extends BaseEntityService<Supplier> {
    @Autowired
    private SupplierDao dao;

    @Override
    protected BaseEntityDao<Supplier> getDao() {
        return dao;
    }


    /**
     * 根据代码查询供应商
     *
     * @param code 供应商代码
     * @return 供应商
     */
    public Supplier findByCode(String code) {
        return findByProperty("code", code);
    }

    /**
     * 分页查询供应商主数据
     *
     * @param searchParam 查询参数
     * @return 分页查询结果
     */
    public PageResult<Supplier> search(ErpCodeQuickSearchParam searchParam) {
        return dao.search(searchParam);
    }
}