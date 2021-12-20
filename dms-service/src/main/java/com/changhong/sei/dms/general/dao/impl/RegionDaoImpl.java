package com.changhong.sei.dms.general.dao.impl;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.impl.BaseEntityDaoImpl;
import com.changhong.sei.core.dao.impl.PageResultUtil;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.SearchFilter;
import com.changhong.sei.core.entity.search.QuerySql;
import com.changhong.sei.dms.general.dao.RegionExtDao;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import com.changhong.sei.dms.general.dto.search.MobileRegionParam;
import com.changhong.sei.dms.general.entity.ImprestEmployeeCorporation;
import com.changhong.sei.dms.general.entity.ProfitCenter;
import com.changhong.sei.dms.general.entity.Region;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实现功能:
 *
 * @author 杨沄炜
 * @date 2021/08/03 9:30 a.m.
 */
public class RegionDaoImpl extends BaseEntityDaoImpl<Region> implements RegionExtDao {

    /**
     * 构造函数
     *
     * @param entityManager 业务实体管理器
     */
    public RegionDaoImpl(EntityManager entityManager) {
        super(Region.class, entityManager);
    }

    /**
     * 查询行政区域
     *
     * @param param     查询参数
     * @param countryId 国家Id
     * @return 行政区域清单
     */
    @Override
    public List<Region> getRegionByInitials(MobileRegionParam param, String countryId) {
        String sql = "SELECT r  FROM Region r   " +
                "where  r.countryId = :countryId  AND ( r.nodeLevel > :nodeLevel OR ( r.nodeLevel= :nodeLevel AND r.name LIKE '%市' ) )";
        Map<String, Object> sqlParams = new HashMap<>();
        sqlParams.put("countryId", countryId);
        sqlParams.put("nodeLevel", 1);
        if (StringUtils.isNotBlank(param.getInitials())) {
            sql = sql + " AND r.shortName LIKE :shortName ";
            sqlParams.put("shortName", param.getInitials().toUpperCase() + "%");
        }
        if (StringUtils.isNotBlank(param.getNameSearchValue())) {
            sql = sql + " AND r.name LIKE :name ";
            sqlParams.put("name", "%" + param.getNameSearchValue() + "%");
        }
        Query query = entityManager.createQuery(sql);
        // 处理查询参数
        if (!sqlParams.isEmpty()) {
            sqlParams.forEach(query::setParameter);
        }
        query.setMaxResults(Integer.MAX_VALUE);
        List<Region> queryResult = query.getResultList();
        if (CollectionUtils.isEmpty(queryResult)) {
            return new ArrayList<>();
        }
        return queryResult;
    }
}
