package com.changhong.sei.dms.management.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.dms.management.entity.Translation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 实现功能: 译文表数据访问接口
 *
 * @author 王锦光 wangjg
 * @version 2020-03-21 21:54
 */
@Repository
public interface TranslationDao extends BaseEntityDao<Translation> {

    /**
     * 通过翻译请求获取翻译结果
     *
     * @param className    业务实体类型全名
     * @param propertyName 业务实体属性名
     * @param langCode     目标语言代码
     * @return 译文
     */
    @Query("select t from Translation t where t.language.code=:langCode and t.semanteme.semantemeType.className=:className and t.semanteme.semantemeType.propertyName=:propertyName")
    List<Translation> findByPropertyName(@Param("langCode") String langCode,
                                         @Param("className") String className,
                                         @Param("propertyName") String propertyName);

    /**
     * 通过语种和语义类型获取翻译结果
     *
     * @param languageId      语种Id
     * @param semantemeTypeId 语义类型Id
     * @return 翻译结果
     */
    @Query("select t from Translation t where t.languageId=:languageId and t.semanteme.semantemeTypeId=:semantemeTypeId")
    List<Translation> findBySemantemeType(@Param("languageId") String languageId,
                                          @Param("semantemeTypeId") String semantemeTypeId);

    /**
     * 通过语种和语义获取译文
     *
     * @param languageId  语种Id
     * @param semantemeId 语义Id
     * @return 译文
     */
    Translation findByLanguageIdAndSemantemeId(String languageId, String semantemeId);
}
