package com.changhong.sei.dms.general.dao.impl;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.impl.BaseEntityDaoImpl;
import com.changhong.sei.core.dao.impl.PageResultUtil;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.entity.search.QuerySql;
import com.changhong.sei.dms.general.dao.ProfitCenterExtDao;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import com.changhong.sei.dms.general.entity.CostCenter;
import com.changhong.sei.dms.general.entity.ProfitCenter;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现功能:
 *
 * @author 杨沄炜
 * @date 2021/08/03 9:30 a.m.
 */
public class ProfitCenterDaoImpl extends BaseEntityDaoImpl<ProfitCenter> implements ProfitCenterExtDao {

    /**
     * 构造函数
     *
     * @param entityManager 业务实体管理器
     */
    public ProfitCenterDaoImpl(EntityManager entityManager) { super(ProfitCenter.class, entityManager); }

    /**
     * 分页查询客户主数据
     *
     * @param searchParam 查询参数
     * @return 客户主数据
     */
    @Override
    public PageResult<ProfitCenter> search(ErpCodeQuickSearchParam searchParam) {
        String select = "select cc";
        String fromAndWhere = "from ProfitCenter cc " +
                "where cc.tenantCode=:tenantCode " +
                "and cc.erpCorporationCode = :erpCorporationCode  ";
        Map<String, Object> sqlParams = new HashMap<>();
        String quickSearchValue = searchParam.getQuickSearchValue();
        sqlParams.put("tenantCode", ContextUtil.getTenantCode());
        sqlParams.put("erpCorporationCode", searchParam.getErpCode());
        // 限制关键字：代码，名称
        if (!StringUtils.isBlank(quickSearchValue)) {
            fromAndWhere += "and (cc.code like :quickSearchValue " +
                    "or cc.name like :quickSearchValue) ";
            sqlParams.put("quickSearchValue", "%" + quickSearchValue + "%");
        }
        QuerySql querySql = new QuerySql(select, fromAndWhere);
        // 设置排序
        if (CollectionUtils.isEmpty(searchParam.getSortOrders())) {
            String orderBy = "order by cc.code ";
            querySql.setOrderBy(orderBy);
        }
        return PageResultUtil.getResult(entityManager, querySql, sqlParams, searchParam);

    }
}
