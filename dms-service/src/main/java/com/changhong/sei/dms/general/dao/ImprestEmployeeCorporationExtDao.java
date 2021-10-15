package com.changhong.sei.dms.general.dao;

import com.changhong.sei.dms.general.entity.ImprestEmployeeCorporation;

/**
 * 实现功能: 公司的备用金员工数据访问扩展接口
 *
 * @author 冯华
 * @create 2021-10-15 13:46
 */
public interface ImprestEmployeeCorporationExtDao {

    /**
     * 根据员工编号、ERP公司代码查询备用金员工的公司信息
     *
     * @param personnelCode      员工编号
     * @param erpCorporationCode ERP公司代码
     * @return 查询结果
     */
    ImprestEmployeeCorporation getCorpInfoByPersonnel(String personnelCode, String erpCorporationCode);

}
