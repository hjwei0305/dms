package com.changhong.sei.dms.general.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.dms.general.dto.TaxCategory;
import com.changhong.sei.dms.general.entity.TaxType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 税类型(TaxType)数据库访问类
 *
 * @author 杨沄炜
 * @since 2021/06/22 9:02
 */
@Repository
public interface TaxTypeDao extends BaseEntityDao<TaxType> {

    /**
     * 根据税分类获取税类型清单
     *
     * @param taxCategory 税分类
     * @param tenantCode 租户代码
     * @return 税类型清单
     */
    @Query("select type from TaxType type where type.taxCategory=?1 and type.tenantCode=?2 order by type.rank")
    List<TaxType> findByTaxCategory(TaxCategory taxCategory, String tenantCode);

    /**
     * 根据税码获取税类型
     *
     * @param code 税码
     * @param tenantCode 租户代码
     * @return 税类型
     */
    TaxType findByCodeAndTenantCode(String code, String tenantCode);
}
