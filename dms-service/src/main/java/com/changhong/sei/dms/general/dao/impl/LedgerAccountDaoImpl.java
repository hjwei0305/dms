package com.changhong.sei.dms.general.dao.impl;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.impl.BaseEntityDaoImpl;
import com.changhong.sei.core.dao.impl.PageResultUtil;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.entity.search.QuerySql;
import com.changhong.sei.dms.general.dao.CustomerExtDao;
import com.changhong.sei.dms.general.dao.LedgerAccountExtDao;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import com.changhong.sei.dms.general.entity.CostCenter;
import com.changhong.sei.dms.general.entity.Customer;
import com.changhong.sei.dms.general.entity.LedgerAccount;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现功能: 总账科目访问扩展接口实现
 *
 * @author 冯华
 * @create 2021-07-29 9:23
 */
public class LedgerAccountDaoImpl extends BaseEntityDaoImpl<LedgerAccount>
        implements LedgerAccountExtDao {

    /**
     * 构造函数
     *
     * @param entityManager 业务实体管理器
     */
    public LedgerAccountDaoImpl(EntityManager entityManager) {
        super(LedgerAccount.class, entityManager);
    }

    /**
     * 分页查询总帐科目主数据
     *
     * @param searchParam 查询参数
     * @return 总帐科目主数据
     */
    @Override
    public PageResult<LedgerAccount> search(ErpCodeQuickSearchParam searchParam) {
        String select = "select cc.ledgerAccount ";
        String fromAndWhere = "from LedgerAccountCorporation cc " +
                "where cc.tenantCode =:tenantCode  " +
                "AND cc.frozen = FALSE " +
                "AND cc.erpCorporationCode = :erpCorporationCode ";
        Map<String, Object> sqlParams = new HashMap<>();
        String quickSearchValue = searchParam.getQuickSearchValue();
        sqlParams.put("tenantCode", ContextUtil.getTenantCode());
        sqlParams.put("erpCorporationCode", searchParam.getErpCode());
        if (!StringUtils.isBlank(quickSearchValue)) {
            fromAndWhere += "AND (cc.ledgerAccount.code LIKE :quickSearchValue " +
                    "or cc.ledgerAccount.name LIKE :quickSearchValue) ";
            sqlParams.put("quickSearchValue", "%" + quickSearchValue + "%");
        }
        QuerySql querySql = new QuerySql(select, fromAndWhere);
        // 设置排序
        if (CollectionUtils.isEmpty(searchParam.getSortOrders())) {
            String orderBy = "ORDER BY cc.ledgerAccount.code ";
            querySql.setOrderBy(orderBy);
        }
        return PageResultUtil.getResult(entityManager, querySql, sqlParams, searchParam);
    }
}
