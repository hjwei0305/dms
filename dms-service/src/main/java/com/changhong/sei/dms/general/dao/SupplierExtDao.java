package com.changhong.sei.dms.general.dao;

import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import com.changhong.sei.dms.general.entity.Supplier;

/**
 * 实现功能: 供应商数据访问扩展接口
 *
 * @author 杨沄炜
 * @version 2021/06/23 16:13
 */
public interface SupplierExtDao {
    /**
     * 分页查询供应商主数据
     *
     * @param searchParam 查询参数
     * @param tenantCode 租户代码
     * @return 供应商主数据
     */
    PageResult<Supplier> search(ErpCodeQuickSearchParam searchParam, String tenantCode);
}
