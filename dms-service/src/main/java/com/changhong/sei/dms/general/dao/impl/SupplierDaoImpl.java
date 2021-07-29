package com.changhong.sei.dms.general.dao.impl;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.impl.BaseEntityDaoImpl;
import com.changhong.sei.core.dao.impl.PageResultUtil;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.entity.search.QuerySql;
import com.changhong.sei.dms.general.dao.SupplierExtDao;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import com.changhong.sei.dms.general.entity.Customer;
import com.changhong.sei.dms.general.entity.Supplier;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现功能: 供应商数据访问扩展接口实现
 *
 * @author 杨沄炜
 * @version 2021/06/23 16:14
 */
public class SupplierDaoImpl extends BaseEntityDaoImpl<Supplier>
        implements SupplierExtDao {
    /**
     * 构造函数
     *
     * @param entityManager 业务实体管理器
     */
    public SupplierDaoImpl(EntityManager entityManager) {
        super(Supplier.class, entityManager);
    }

    /**
     * 分页查询供应商主数据
     *
     * @param searchParam 查询参数
     * @return 供应商主数据
     */
    @Override
    public PageResult<Supplier> search(ErpCodeQuickSearchParam searchParam) {
        String select = "select cc.supplier";
        String fromAndWhere = "from SupplierCorporation cc " +
                "where cc.tenantCode=:tenantCode " +
                "and cc.erpCorporationCode = :erpCorporationCode ";
        Map<String, Object> sqlParams = new HashMap<>();
        String quickSearchValue = searchParam.getQuickSearchValue();
        sqlParams.put("tenantCode", ContextUtil.getTenantCode());
        sqlParams.put("erpCorporationCode", searchParam.getErpCode());
        if (!StringUtils.isBlank(quickSearchValue)) {
            fromAndWhere += "and (cc.supplier.code like :quickSearchValue " +
                    "or cc.supplier.name like :quickSearchValue) ";
            sqlParams.put("quickSearchValue", "%" + quickSearchValue + "%");
        }
        QuerySql querySql = new QuerySql(select, fromAndWhere);
        // 设置排序
        if (CollectionUtils.isEmpty(searchParam.getSortOrders())) {
            String orderBy = "order by cc.supplier.code ";
            querySql.setOrderBy(orderBy);
        }
        return PageResultUtil.getResult(entityManager, querySql, sqlParams, searchParam);
    }
}
