package com.changhong.sei.dms.general.dao;

import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import com.changhong.sei.dms.general.entity.ProfitCenter;

/**
 * 实现功能:
 *
 * @author 杨沄炜
 * @date 2021/08/02 8:50
 */
public interface ProfitCenterExtDao {
    /**
     * 分页查询客户主数据
     *
     * @param searchParam 查询参数
     * @return 客户主数据
     */
    PageResult<ProfitCenter> search(ErpCodeQuickSearchParam searchParam);
}
