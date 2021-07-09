package com.changhong.sei.dms.general.dao;

import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import com.changhong.sei.dms.general.entity.CostCenter;

/**
 * 实现功能: 成本中心数据访问扩展接口
 *
 * @author 王锦光 wangjg
 * @version 2021-06-09 14:53
 */
public interface CostCenterExtDao {
    /**
     * 分页查询客户主数据
     *
     * @param searchParam 查询参数
     * @param tenantCode 租户代码
     * @return 客户主数据
     */
    PageResult<CostCenter> search(ErpCodeQuickSearchParam searchParam, String tenantCode);
}
