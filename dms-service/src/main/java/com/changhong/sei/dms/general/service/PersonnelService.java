package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.PersonnelDao;
import com.changhong.sei.dms.general.dto.PersonnelDto;
import com.changhong.sei.dms.general.entity.Personnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 公司员工(ERP)(Personnel)业务逻辑实现类
 *
 * @author sei
 * @since 2021-04-19 10:18:19
 */
@Service("personnelService")
public class PersonnelService extends BaseEntityService<Personnel> {
    @Autowired
    private PersonnelDao dao;

    @Override
    protected BaseEntityDao<Personnel> getDao() {
        return dao;
    }


    /**
     * 根据员工编号获取员工
     *
     * @param code 员工编号
     * @return 员工
     */
    public Personnel findByCode(String code) {
        return findByProperty("code", code);
    }

}