package com.changhong.sei.dms.management.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.management.dao.SemantemeTypeDao;
import com.changhong.sei.dms.management.entity.SemantemeType;
import org.springframework.stereotype.Service;

/**
 * 实现功能: 语义类型业务逻辑实现
 *
 * @author 王锦光 wangjg
 * @version 2020-03-21 22:01
 */
@Service
public class SemantemeTypeService extends BaseEntityService<SemantemeType> {
    private final SemantemeTypeDao dao;

    public SemantemeTypeService(SemantemeTypeDao dao) {
        this.dao = dao;
    }

    @Override
    protected BaseEntityDao<SemantemeType> getDao() {
        return dao;
    }
}
