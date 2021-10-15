package com.changhong.sei.dms.general.dao.impl;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.impl.BaseEntityDaoImpl;
import com.changhong.sei.dms.general.dao.ImprestEmployeeCorporationExtDao;
import com.changhong.sei.dms.general.entity.ImprestEmployeeCorporation;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实现功能:  公司的备用金员工数据访问扩展接口实现
 *
 * @author 冯华
 * @create 2021-10-15 13:49
 */
public class ImprestEmployeeCorporationDaoImpl extends BaseEntityDaoImpl<ImprestEmployeeCorporation>
        implements ImprestEmployeeCorporationExtDao {
    /**
     * 构造函数
     *
     * @param entityManager 业务实体管理器
     */
    public ImprestEmployeeCorporationDaoImpl(EntityManager entityManager) {
        super(ImprestEmployeeCorporation.class, entityManager);
    }

    /**
     * 根据员工编号、ERP公司代码查询备用金员工的公司信息
     *
     * @param personnelCode      员工编号
     * @param erpCorporationCode ERP公司代码
     * @return 查询结果
     */
    @Override
    public ImprestEmployeeCorporation getCorpInfoByPersonnel(String personnelCode, String erpCorporationCode) {
        String sql = "SELECT c FROM ImprestEmployeeCorporation c " +
                "WHERE  c.tenantCode = :tenantCode " +
                "AND c.erpCorporationCode = :erpCorporationCode " +
                "AND c.imprestEmployeeId IN (SELECT id  FROM ImprestEmployee i WHERE  i.personnelCode = :personnelCode)";
        Map<String, Object> sqlParams = new HashMap<>();
        sqlParams.put("tenantCode", ContextUtil.getTenantCode());
        sqlParams.put("erpCorporationCode", erpCorporationCode);
        sqlParams.put("personnelCode", personnelCode);

        Query query = entityManager.createQuery(sql);
        // 处理查询参数
        if (!sqlParams.isEmpty()) {
            sqlParams.forEach(query::setParameter);
        }
        query.setMaxResults(1);
        List queryResult = query.getResultList();
        if (CollectionUtils.isEmpty(queryResult)) {
            return null;
        }
        return (ImprestEmployeeCorporation) queryResult.get(0);
    }
}
