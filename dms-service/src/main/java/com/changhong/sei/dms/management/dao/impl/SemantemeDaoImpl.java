package com.changhong.sei.dms.management.dao.impl;

import com.changhong.sei.core.dao.impl.BaseEntityDaoImpl;
import com.changhong.sei.core.dao.impl.PageResultUtil;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.entity.search.QuerySql;
import com.changhong.sei.dms.management.dao.SemantemeExtDao;
import com.changhong.sei.dms.management.dto.search.TranslationQuickQueryParam;
import com.changhong.sei.dms.management.dto.trans.TransPropertyResult;
import com.changhong.sei.dms.management.entity.Semanteme;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现功能: 语义表数据访问扩展接口实现
 *
 * @author 王锦光 wangjg
 * @version 2020-03-24 9:53
 */
public class SemantemeDaoImpl extends BaseEntityDaoImpl<Semanteme> implements SemantemeExtDao {
    /**
     * 构造函数
     *
     * @param entityManager 业务实体管理器
     */
    public SemantemeDaoImpl(EntityManager entityManager) {
        super(Semanteme.class, entityManager);
    }

    /**
     * 查询指定语种和语义类型的语义
     *
     * @param queryParam 查询参数
     * @return 语义qingdan
     */
    @Override
    public PageResult<TransPropertyResult> findTranslationsByPage(TranslationQuickQueryParam queryParam) {
        String select = "select new com.changhong.sei.commondata.dto.trans.TransPropertyResult(t.propertyName, s.propertyValue) ";
        String fromAndWhere = "from Semanteme s inner join SemantemeType t " +
                "on s.semantemeTypeId = t.id " +
                "where t.id=:semantemeTypeId ";
        Map<String, Object> sqlParams = new HashMap<>();
        String quickSearchValue = queryParam.getQuickSearchValue();
        sqlParams.put("semantemeTypeId", queryParam.getSemantemeTypeId());
        // 限制关键字
        if (!StringUtils.isBlank(quickSearchValue)) {
            fromAndWhere = fromAndWhere + "and (s.propertyValue like :quickSearchValue) ";
            sqlParams.put("quickSearchValue", "%" + quickSearchValue + "%");
        }
        QuerySql querySql = new QuerySql(select, fromAndWhere);
        // 排序
        querySql.setOrderBy("order by s.propertyValue");
        return PageResultUtil.getResult(entityManager, querySql, sqlParams, queryParam);
    }
}
