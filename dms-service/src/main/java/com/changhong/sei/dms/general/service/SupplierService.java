package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResult;
import com.changhong.sei.dms.general.dao.CustomerCorporationDao;
import com.changhong.sei.dms.general.dao.SupplierCorporationDao;
import com.changhong.sei.dms.general.dao.SupplierDao;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import com.changhong.sei.dms.general.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 供应商(Supplier)业务逻辑实现类
 *
 * @author sei
 * @since 2021-05-06 14:07:30
 */
@Service("supplierService")
public class SupplierService extends BaseEntityService<Supplier> {
    @Autowired
    private SupplierDao dao;
    @Autowired
    private SupplierCorporationDao supplierCorporationDao;

    @Override
    protected BaseEntityDao<Supplier> getDao() {
        return dao;
    }


    /**
     * 删除数据保存数据之前额外操作回调方法 子类根据需要覆写添加逻辑即可
     *
     * @param id 待删除数据对象主键
     */
    @Override
    protected OperateResult preDelete(String id) {
        boolean exists = supplierCorporationDao.isExistsByProperty("supplierId", id);
        if (exists) {
            //00033 = 该数据已分配公司，请先移除公司！
            return OperateResult.operationFailure("00033");
        }
        return OperateResult.operationSuccess("core_service_00028");
    }


    /**
     * 根据代码查询供应商
     *
     * @param code 供应商代码
     * @return 供应商
     */
    public Supplier findByCode(String code) {
        return findByProperty("code", code);
    }

    /**
     * 分页查询供应商主数据
     *
     * @param searchParam 查询参数
     * @return 分页查询结果
     */
    public PageResult<Supplier> search(ErpCodeQuickSearchParam searchParam) {
        return dao.search(searchParam);
    }

    /**
     * 根据名称查询客户主数据
     *
     * @param name 名称
     * @return 客户主数据集合
     */
    public List<Supplier> findByName(String name) {
        return findListByProperty("name", name);
    }
}