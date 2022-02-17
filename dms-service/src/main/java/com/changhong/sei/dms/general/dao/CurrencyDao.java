package com.changhong.sei.dms.general.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.dms.general.entity.Currency;
import org.springframework.stereotype.Repository;

/**
 * 币种(Currency)数据库访问类
 *
 * @author sei
 * @since 2020-08-17 14:02:46
 */
@Repository
public interface CurrencyDao extends BaseEntityDao<Currency> {
    /**
     * 获取一个币种
     * @param code 代码
     * @return 币种
     */
    Currency findFirstByCode(String code);
}