package com.changhong.sei.dms.general.dao.impl;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.impl.BaseEntityDaoImpl;
import com.changhong.sei.core.dao.impl.PageResultUtil;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.entity.search.QuerySql;
import com.changhong.sei.dms.general.dao.CustomerExtDao;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import com.changhong.sei.dms.general.entity.Customer;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现功能: 客户数据访问扩展接口实现
 *
 * @author 王锦光 wangjg
 * @version 2021-06-09 14:58
 */
public class CustomerDaoImpl extends BaseEntityDaoImpl<Customer>
        implements CustomerExtDao {
    /**
     * 构造函数
     *
     * @param entityManager 业务实体管理器
     */
    public CustomerDaoImpl(EntityManager entityManager) {
        super(Customer.class, entityManager);
    }

    /**
     * 分页查询客户主数据
     *
     * @param searchParam 查询参数
     * @return 客户主数据
     */
    @Override
    public PageResult<Customer> search(ErpCodeQuickSearchParam searchParam) {
        String select = "select cc.customer";
        String fromAndWhere = "from CustomerCorporation cc " +
                "where cc.tenantCode=:tenantCode " +
                "and cc.erpCorporationCode = :erpCorporationCode  ";
        Map<String, Object> sqlParams = new HashMap<>();
        String quickSearchValue = searchParam.getQuickSearchValue();
        sqlParams.put("tenantCode", ContextUtil.getTenantCode());
        sqlParams.put("erpCorporationCode", searchParam.getErpCode());
        // 限制关键字：代码，名称
        if (!StringUtils.isBlank(quickSearchValue)) {
            fromAndWhere += "and (cc.customer.code like :quickSearchValue " +
                    "or cc.customer.name like :quickSearchValue) ";
            sqlParams.put("quickSearchValue", "%" + quickSearchValue + "%");
        }
        QuerySql querySql = new QuerySql(select, fromAndWhere);
        // 设置排序
        if (CollectionUtils.isEmpty(searchParam.getSortOrders())) {
            String orderBy = "order by cc.customer.code ";
            querySql.setOrderBy(orderBy);
        }
        return PageResultUtil.getResult(entityManager, querySql, sqlParams, searchParam);
    }
}
