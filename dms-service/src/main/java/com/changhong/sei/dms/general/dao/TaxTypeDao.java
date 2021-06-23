package com.changhong.sei.dms.general.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.dms.general.dto.TaxCategory;
import com.changhong.sei.dms.general.entity.TaxType;
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
     * @return 税类型清单
     */
    List<TaxType> findByTaxCategory(TaxCategory taxCategory);
}
