package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResult;
import com.changhong.sei.dms.general.dao.CustomerCorporationDao;
import com.changhong.sei.dms.general.dao.CustomerDao;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import com.changhong.sei.dms.general.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 客户(Customer)业务逻辑实现类
 *
 * @author sei
 * @since 2021-05-06 13:05:15
 */
@Service("customerService")
public class CustomerService extends BaseEntityService<Customer> {
    @Autowired
    private CustomerDao dao;
    @Autowired
    private CustomerCorporationDao customerCorporationDao;

    @Override
    protected BaseEntityDao<Customer> getDao() {
        return dao;
    }

    /**
     * 删除数据保存数据之前额外操作回调方法 子类根据需要覆写添加逻辑即可
     *
     * @param id 待删除数据对象主键
     */
    @Override
    protected OperateResult preDelete(String id) {
        boolean exists = customerCorporationDao.isExistsByProperty("customerId", id);
        if (exists) {
            //00033 = 该数据已分配公司，请先移除公司！
            return OperateResult.operationFailure("00033");
        }
        return OperateResult.operationSuccess("core_service_00028");
    }


    /**
     * 根据代码查询客户
     *
     * @param code 客户代码
     * @return 客户
     */
    public Customer findByCode(String code) {
        return findByProperty("code", code);
    }

    /**
     * 分页查询客户主数据
     *
     * @param searchParam 查询参数
     * @return 分页查询结果
     */
    public PageResult<Customer> search(ErpCodeQuickSearchParam searchParam) {
        return dao.search(searchParam);
    }

    /**
     * 根据名称查询客户主数据
     *
     * @param name 名称
     * @return 客户主数据集合
     */
    public List<Customer> findByName(String name) {
        return findListByProperty("name", name);
    }
}