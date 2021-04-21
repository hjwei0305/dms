package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.dms.general.dao.ImprestEmployeeDao;
import com.changhong.sei.dms.general.entity.HrOrganization;
import com.changhong.sei.dms.general.entity.ImprestEmployee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


/**
 * 备用金员工(ERP)(ImprestEmployee)业务逻辑实现类
 *
 * @author sei
 * @since 2021-04-20 16:40:28
 */
@Service("imprestEmployeeService")
public class ImprestEmployeeService extends BaseEntityService<ImprestEmployee> {
    @Autowired
    private ImprestEmployeeDao dao;

    @Override
    protected BaseEntityDao<ImprestEmployee> getDao() {
        return dao;
    }


    /**
     * 覆写保存方法，增加保存前校验
     *
     * @param entity 待保存实体
     * @return 操作结果
     */
    @Override
    public OperateResultWithData<ImprestEmployee> save(ImprestEmployee entity) {
        if (StringUtils.isBlank(entity.getPersonnelCode()) && StringUtils.isBlank(entity.getIdCard())) {
            //00024=员工编号和身份证号不能同时为空，请检查！
            return OperateResultWithData.operationWarning("00024");
        }
        return super.save(entity);
    }

}