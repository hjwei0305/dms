package com.changhong.sei.dms.management.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.dms.management.entity.Language;
import org.springframework.stereotype.Repository;

/**
 * 实现功能: 语言类型数据访问接口
 *
 * @author 王锦光 wangjg
 * @version 2020-03-21 21:54
 */
@Repository
public interface LanguageDao extends BaseEntityDao<Language> {

    /**
     * 通过代码获取语言类型
     * @param code 语言类型代码
     * @return 语言类型
     */
    Language findByCode(String code);
}
