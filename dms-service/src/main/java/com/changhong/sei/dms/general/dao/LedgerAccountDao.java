package com.changhong.sei.dms.general.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.dms.general.entity.LedgerAccount;
import org.springframework.stereotype.Repository;

/**
 * 总帐科目(LedgerAccount)数据库访问类
 *
 * @author sei
 * @since 2021-04-16 16:16:20
 */
@Repository
public interface LedgerAccountDao extends BaseEntityDao<LedgerAccount>,LedgerAccountExtDao {

}