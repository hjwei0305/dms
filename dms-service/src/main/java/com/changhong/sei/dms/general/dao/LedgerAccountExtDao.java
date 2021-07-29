package com.changhong.sei.dms.general.dao;

import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import com.changhong.sei.dms.general.entity.LedgerAccount;

/**
 * 实现功能: 总帐科目访问扩展接口
 *
 * @author 冯华
 * @create 2021-07-29 9:15
 */
public interface LedgerAccountExtDao {
    /**
     * 分页查询总帐科目主数据
     *
     * @param searchParam 查询参数
     * @return 总帐科目主数据
     */
    PageResult<LedgerAccount> search(ErpCodeQuickSearchParam searchParam);
}
