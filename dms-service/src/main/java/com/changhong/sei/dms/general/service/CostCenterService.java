package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.CostCenterDao;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import com.changhong.sei.dms.general.entity.CostCenter;
import com.changhong.sei.dms.general.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 成本中心(CostCenter)业务逻辑实现类
 *
 * @author sei
 * @since 2021-04-16 11:17:13
 */
@Service("costCenterService")
public class CostCenterService extends BaseEntityService<CostCenter> {
    @Autowired
    private CostCenterDao dao;

    @Override
    protected BaseEntityDao<CostCenter> getDao() {
        return dao;
    }

    /**
     * 分页查询成本中心
     *
     * @param searchParam 查询参数
     * @return 分页查询结果
     */
    public PageResult<CostCenter> search(ErpCodeQuickSearchParam searchParam) {
        return dao.search(searchParam, ContextUtil.getTenantCode());
    }
}