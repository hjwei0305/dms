package com.changhong.sei.dms.management.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.management.dao.SemantemeDao;
import com.changhong.sei.dms.management.entity.Semanteme;
import org.springframework.stereotype.Service;

/**
 * 实现功能: 语义表业务逻辑实现
 *
 * @author 王锦光 wangjg
 * @version 2020-03-21 22:01
 */
@Service
public class SemantemeService extends BaseEntityService<Semanteme> {
    private final SemantemeDao dao;

    public SemantemeService(SemantemeDao dao) {
        this.dao = dao;
    }

    @Override
    protected BaseEntityDao<Semanteme> getDao() {
        return dao;
    }
}
