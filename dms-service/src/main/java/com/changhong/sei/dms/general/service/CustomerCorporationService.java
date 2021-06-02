package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.SearchFilter;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.CustomerCorporationDao;
import com.changhong.sei.dms.general.dto.CustomerCorporationDto;
import com.changhong.sei.dms.general.entity.CustomerCorporation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 客户的公司视图(CustomerCorporation)业务逻辑实现类
 *
 * @author sei
 * @since 2021-05-06 13:38:05
 */
@Service("customerCorporationService")
public class CustomerCorporationService extends BaseEntityService<CustomerCorporation> {
    @Autowired
    private CustomerCorporationDao dao;

    @Override
    protected BaseEntityDao<CustomerCorporation> getDao() {
        return dao;
    }


    /**
     * 获取客户的公司信息
     *
     * @param customerId 客户Id
     * @return 公司信息
     */
    public List<CustomerCorporation> getCorporationInfo(String customerId) {
        return findByFilter(new SearchFilter("customerId", customerId));
    }

}