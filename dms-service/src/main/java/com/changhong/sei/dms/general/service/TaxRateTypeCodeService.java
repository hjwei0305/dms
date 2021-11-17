package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.dms.general.dao.TaxRateTypeCodeDao;
import com.changhong.sei.dms.general.entity.TaxRateTypeCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 税收分类编码(TaxRateTypeCode)业务逻辑实现类
 *
 * @author sei
 * @since 2021-11-10 14:21:39
 */
@Service
public class TaxRateTypeCodeService extends BaseEntityService<TaxRateTypeCode> {
    @Autowired
    private TaxRateTypeCodeDao dao;

    @Override
    protected BaseEntityDao<TaxRateTypeCode> getDao() {
        return dao;
    }

    public TaxRateTypeCode findCodeBySPBMAndBB(String spbm, String bb) {
        return dao.findCodeBySPBMAndBB(spbm, bb);
    }

    public OperateResultWithData<List<TaxRateTypeCode>> getRootNode() {
        List<TaxRateTypeCode> nodes = dao.getRootNode();
        return OperateResultWithData.operationSuccessWithData(nodes);
    }

    public OperateResultWithData<List<TaxRateTypeCode>> getNodeByPid(String pid) {
        List<TaxRateTypeCode> nodes = dao.getNodeByPid(pid);
        return OperateResultWithData.operationSuccessWithData(nodes);
    }

    public OperateResultWithData<List<TaxRateTypeCode>> getNodeByPrefix(String prefixCode) {
        List<TaxRateTypeCode> nodes = dao.getNodeByPrefix(prefixCode);
        return OperateResultWithData.operationSuccessWithData(nodes);
    }

}