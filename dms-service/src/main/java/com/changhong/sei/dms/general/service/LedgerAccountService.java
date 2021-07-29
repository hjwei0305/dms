package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResult;
import com.changhong.sei.dms.general.dao.LedgerAccountCorporationDao;
import com.changhong.sei.dms.general.dao.LedgerAccountDao;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import com.changhong.sei.dms.general.entity.CostCenter;
import com.changhong.sei.dms.general.entity.LedgerAccount;
import com.changhong.sei.dms.general.entity.LedgerAccountCorporation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 总帐科目(LedgerAccount)业务逻辑实现类
 *
 * @author sei
 * @since 2021-04-16 16:16:20
 */
@Service("ledgerAccountService")
public class LedgerAccountService extends BaseEntityService<LedgerAccount> {
    @Autowired
    private LedgerAccountDao dao;
    @Autowired
    private LedgerAccountCorporationDao ledgerAccountCorporationDao;

    @Override
    protected BaseEntityDao<LedgerAccount> getDao() {
        return dao;
    }


    /**
     * 删除数据前校验
     *
     * @param id 待删除数据对象主键
     */
    @Override
    protected OperateResult preDelete(String id) {
        boolean exists = ledgerAccountCorporationDao.isExistsByProperty("ledgerAccountId", id);
        if (exists) {
            return OperateResult.operationWarning("00022");
        }
        return OperateResult.operationSuccess("core_service_00028");
    }

    /**
     * 分页查询成本中心
     *
     * @param searchParam 查询参数
     * @return 分页查询结果
     */
    public PageResult<LedgerAccount> search(ErpCodeQuickSearchParam searchParam) {
        return dao.search(searchParam);
    }

}