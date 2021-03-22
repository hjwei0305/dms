package com.changhong.sei.dms.management.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.management.dao.LanguageDao;
import com.changhong.sei.dms.management.entity.Language;
import org.springframework.stereotype.Service;

/**
 * 实现功能: 语言类型业务逻辑实现
 *
 * @author 王锦光 wangjg
 * @version 2020-03-21 22:01
 */
@Service
public class LanguageService extends BaseEntityService<Language> {
    private final LanguageDao dao;

    public LanguageService(LanguageDao dao) {
        this.dao = dao;
    }

    @Override
    protected BaseEntityDao<Language> getDao() {
        return dao;
    }

    /**
     * 通过代码获取语言类型
     *
     * @param code 语言类型代码
     * @return 语言类型
     */
    public Language findByCode(String code) {
        return dao.findByCode(code);
    }
}
