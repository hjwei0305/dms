package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.ProfitCenterDao;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import com.changhong.sei.dms.general.entity.Customer;
import com.changhong.sei.dms.general.entity.ProfitCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 利润中心(ProfitCenter)业务逻辑实现类
 *
 * @author sei
 * @since 2021-07-30 14:57:52
 */
@Service("profitCenterService")
public class ProfitCenterService extends BaseEntityService<ProfitCenter> {
    @Autowired
    private ProfitCenterDao dao;

    @Override
    protected BaseEntityDao<ProfitCenter> getDao() {
        return dao;
    }

    /**
     * 根据代码查询
     *
     * @param code 代码
     * @return 利润中心
     */
    public ProfitCenter findByCode(String code) {
        return findByProperty("code", code);
    }

    /**
     * 分页查询利润中心
     *
     * @param searchParam 查询参数
     * @return 分页查询结果
     */
    public PageResult<ProfitCenter> search(ErpCodeQuickSearchParam searchParam) {return dao.search(searchParam);}
}