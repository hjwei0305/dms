package com.changhong.sei.dms.management.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.dms.management.entity.Semanteme;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 实现功能: 语义表数据访问接口
 *
 * @author 王锦光 wangjg
 * @version 2020-03-21 21:54
 */
@Repository
public interface SemantemeDao extends BaseEntityDao<Semanteme>, SemantemeExtDao {
    /**
     * 通过语义类型和属性值获取语义
     * @param semantemeTypeId 语义类型Id
     * @param propertyValue 属性值
     * @return 语义
     */
    Semanteme findBySemantemeTypeIdAndPropertyValue(String semantemeTypeId, String propertyValue);

    /**
     * 通过关键值获取一个语义
     * @param className 全类名
     * @param propertyName 属性名
     * @param propertyValue 属性值
     * @return 语义
     */
    @Query("select s from Semanteme s where s.semantemeType.className=:className " +
            "and s.semantemeType.propertyName=:propertyName " +
            "and s.propertyValue=:propertyValue")
    Semanteme findByKey(@Param("className") String className,
                        @Param("propertyName") String propertyName,
                        @Param("propertyValue") String propertyValue);
}
