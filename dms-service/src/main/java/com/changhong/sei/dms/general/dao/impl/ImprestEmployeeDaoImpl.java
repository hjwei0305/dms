package com.changhong.sei.dms.general.dao.impl;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.impl.BaseEntityDaoImpl;
import com.changhong.sei.core.dao.impl.PageResultUtil;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.entity.search.QuerySql;
import com.changhong.sei.dms.general.dao.ImprestEmployeeExtDao;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import com.changhong.sei.dms.general.entity.ImprestEmployee;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现功能: 备用金员工数据访问扩展接口实现
 *
 * @author 王锦光 wangjg
 * @version 2021-06-09 14:58
 */
public class ImprestEmployeeDaoImpl extends BaseEntityDaoImpl<ImprestEmployee>
        implements ImprestEmployeeExtDao {
    /**
     * 构造函数
     *
     * @param entityManager 业务实体管理器
     */
    public ImprestEmployeeDaoImpl(EntityManager entityManager) {
        super(ImprestEmployee.class, entityManager);
    }

    /**
     * 分页查询备用金员工
     *
     * @param searchParam 查询参数
     * @return 备用金员工
     */
    @Override
    public PageResult<ImprestEmployee> search(ErpCodeQuickSearchParam searchParam) {
        String select = "select ic.imprestEmployee";
        String fromAndWhere = "from ImprestEmployeeCorporation ic " +
                "where ic.tenantCode=:tenantCode " +
                "and ic.erpCorporationCode = :erpCorporationCode  ";
        Map<String, Object> sqlParams = new HashMap<>();
        String quickSearchValue = searchParam.getQuickSearchValue();
        sqlParams.put("tenantCode", ContextUtil.getTenantCode());
        sqlParams.put("erpCorporationCode", searchParam.getErpCode());
        // 限制关键字：代码，名称
        if (!StringUtils.isBlank(quickSearchValue)) {
            fromAndWhere += "and (ic.imprestEmployee.code like :quickSearchValue " +
                    "or ic.imprestEmployee.name like :quickSearchValue) ";
            sqlParams.put("quickSearchValue", "%" + quickSearchValue + "%");
        }
        QuerySql querySql = new QuerySql(select, fromAndWhere);
        // 设置排序
        if (CollectionUtils.isEmpty(searchParam.getSortOrders())) {
            String orderBy = "order by ic.imprestEmployee.code ";
            querySql.setOrderBy(orderBy);
        }
        return PageResultUtil.getResult(entityManager, querySql, sqlParams, searchParam);
    }
}
