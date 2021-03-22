package com.changhong.sei.mdms.management.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.mdms.management.entity.SemantemeType;
import org.springframework.stereotype.Repository;

/**
 * 实现功能: 语义类型数据访问接口
 *
 * @author 王锦光 wangjg
 * @version 2020-03-21 21:54
 */
@Repository
public interface SemantemeTypeDao extends BaseEntityDao<SemantemeType> {
    /**
     * 通过类名和属性名获取语义类型
     * @param className 类名
     * @param propertyName 属性名
     * @return 语义类型
     */
    SemantemeType findByClassNameAndPropertyName(String className, String propertyName);
}
