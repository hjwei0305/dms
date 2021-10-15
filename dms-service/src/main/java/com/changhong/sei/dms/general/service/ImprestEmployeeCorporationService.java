package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.ImprestEmployeeCorporationDao;
import com.changhong.sei.dms.general.dto.ImprestEmployeeCorporationDto;
import com.changhong.sei.dms.general.entity.ImprestEmployeeCorporation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 公司的备用金员工(ERP)(ImprestEmployeeCorporation)业务逻辑实现类
 *
 * @author sei
 * @since 2021-04-20 17:06:39
 */
@Service("imprestEmployeeCorporationService")
public class ImprestEmployeeCorporationService extends BaseEntityService<ImprestEmployeeCorporation> {
    @Autowired
    private ImprestEmployeeCorporationDao dao;

    @Override
    protected BaseEntityDao<ImprestEmployeeCorporation> getDao() {
        return dao;
    }


    /**
     * 根据员工编号、ERP公司代码查询备用金员工的公司信息
     *
     * @param personnelCode      员工编号
     * @param erpCorporationCode ERP公司代码
     * @return 查询结果
     */
    public ImprestEmployeeCorporation getCorpInfoByPersonnel(String personnelCode, String erpCorporationCode) {
        return dao.getCorpInfoByPersonnel(personnelCode, erpCorporationCode);
    }
}