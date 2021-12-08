package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResult;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.dms.general.dao.ImprestEmployeeCorporationDao;
import com.changhong.sei.dms.general.dao.ImprestEmployeeDao;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import com.changhong.sei.dms.general.entity.Customer;
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
    @Autowired
    private ImprestEmployeeCorporationDao imprestEmployeeCorporationDao;

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

    /**
     * 删除前检查是否能删除
     *
     * @param s 待删除的国家id
     * @return 操作结果
     */
    @Override
    protected OperateResult preDelete(String s) {
        OperateResult result = OperateResult.operationSuccess();
        if (imprestEmployeeCorporationDao.isExistsByProperty("imprestEmployeeId", s)) {
            //00010 = 该备用金员工已分配到公司，请先移除！
            result = OperateResult.operationFailure("00010");
        }
        return result;
    }
    /**
     * 分页查询备用金员工
     *
     * @param searchParam 查询参数
     * @return 分页查询结果
     */
    public PageResult<ImprestEmployee> search(ErpCodeQuickSearchParam searchParam) {
        return dao.search(searchParam);
    }
}