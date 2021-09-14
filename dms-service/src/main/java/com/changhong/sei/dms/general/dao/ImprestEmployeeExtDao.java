package com.changhong.sei.dms.general.dao;

import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import com.changhong.sei.dms.general.entity.ImprestEmployee;

/**
 * 实现功能: 备用金员工数据访问扩展接口
 *
 * @author 王锦光 wangjg
 * @version 2021-06-09 14:53
 */
public interface ImprestEmployeeExtDao {
    /**
     * 分页查询备用金员工
     *
     * @param searchParam 查询参数
     * @return 备用金员工
     */
    PageResult<ImprestEmployee> search(ErpCodeQuickSearchParam searchParam);
}
