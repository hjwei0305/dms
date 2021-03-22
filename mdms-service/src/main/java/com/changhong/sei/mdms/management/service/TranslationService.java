package com.changhong.sei.mdms.management.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResult;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.mdms.common.utils.StringClassNameUtil;
import com.changhong.sei.mdms.management.dao.SemantemeDao;
import com.changhong.sei.mdms.management.dao.SemantemeTypeDao;
import com.changhong.sei.mdms.management.dao.TranslationDao;
import com.changhong.sei.mdms.management.dto.TranslationParam;
import com.changhong.sei.mdms.management.dto.search.TranslationQuickQueryParam;
import com.changhong.sei.mdms.management.dto.trans.TransPropertyResult;
import com.changhong.sei.mdms.management.entity.Semanteme;
import com.changhong.sei.mdms.management.entity.SemantemeType;
import com.changhong.sei.mdms.management.entity.Translation;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 实现功能: 译文表业务逻辑实现
 *
 * @author 王锦光 wangjg
 * @version 2020-03-21 22:01
 */
@Service
@CacheConfig(cacheNames = "translation-cache")
public class TranslationService extends BaseEntityService<Translation> {
    private final TranslationDao dao;
    @Autowired
    private SemantemeDao semantemeDao;
    @Autowired
    private SemantemeTypeDao semantemeTypeDao;
    @Autowired
    private TranslationDao translationDao;

    public TranslationService(TranslationDao dao) {
        this.dao = dao;
    }

    @Override
    protected BaseEntityDao<Translation> getDao() {
        return dao;
    }

    /**
     * 数据保存操作
     *
     * @param entity 译文
     */
    @Override
    @CacheEvict(allEntries = true)
    public OperateResultWithData<Translation> save(Translation entity) {
        return super.save(entity);
    }

    /**
     * 主键删除
     *
     * @param s 主键
     * @return 返回操作结果对象
     */
    @Override
    @CacheEvict(allEntries = true)
    public OperateResult delete(String s) {
        return super.delete(s);
    }

    /**
     * 通过翻译请求获取翻译结果
     *
     * @param langCode     目标语言代码
     * @param className    业务实体类型全名
     * @param propertyName 业务实体属性名
     * @return 翻译结果
     */
    @Cacheable
    public List<TransPropertyResult> getTranslations(String langCode, String className, String propertyName) {
        List<TransPropertyResult> propertyResults = new LinkedList<>();
        // 获取译文
        List<Translation> translations = dao.findByPropertyName(langCode, className, propertyName);
        translations.forEach(t -> {
            TransPropertyResult propertyResult = new TransPropertyResult();
            propertyResult.setPropertyName(propertyName);
            propertyResult.setPropertyValue(t.getSemanteme().getPropertyValue());
            propertyResult.setTransValue(t.getTransValue());
            propertyResults.add(propertyResult);
        });
        return propertyResults;
    }

    /**
     * 查询指定语种和语义类型的译文
     *
     * @param queryParam 查询参数
     * @return 翻译结果
     */
    public PageResult<TransPropertyResult> findTranslationsByPage(TranslationQuickQueryParam queryParam) {
        // 获取语义查询结果
        PageResult<TransPropertyResult> pageResult = semantemeDao.findTranslationsByPage(queryParam);
        List<TransPropertyResult> transResults = pageResult.getRows();
        if (CollectionUtils.isEmpty(transResults)) {
            return pageResult;
        }
        // 获取翻译结果
        List<Translation> translations = dao.findBySemantemeType(queryParam.getLanguageId(), queryParam.getSemantemeTypeId());
        transResults.forEach(r -> {
            // 匹配语义
            Optional<Translation> translationOptional = translations.stream().filter(t -> StringUtils.equals(r.getPropertyValue(), t.getSemanteme().getPropertyValue())).findAny();
            translationOptional.ifPresent(translation -> r.setTransValue(translation.getTransValue()));
        });
        return pageResult;
    }

    /**
     * 保存不存在的语义和译文
     *
     * @param languageId       语言类型Id
     * @param className        业务实体类型全名
     * @param needTransResults 需要保存的翻译结果
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED, rollbackFor = Exception.class)
    @CacheEvict(allEntries = true)
    public void saveNeedTransResults(String languageId, String className, List<TransPropertyResult> needTransResults) {
        if (CollectionUtils.isEmpty(needTransResults)) {
            return;
        }
        // 创建语义类型
        List<SemantemeType> semantemeTypes = new LinkedList<>();
        List<String> propertyNames = needTransResults.stream().map(TransPropertyResult::getPropertyName).distinct().collect(Collectors.toList());
        propertyNames.forEach(propertyName -> {
            // 通过类型名和属性名获取语义类型
            SemantemeType semantemeType = semantemeTypeDao.findByClassNameAndPropertyName(className, propertyName);
            if (Objects.isNull(semantemeType)) {
                semantemeType = new SemantemeType();
                semantemeType.setClassName(className);
                semantemeType.setPropertyName(propertyName);
                semantemeType.setRemark(StringClassNameUtil.getRemark(className, propertyName));
                semantemeTypeDao.save(semantemeType);
            }
            semantemeTypes.add(semantemeType);
        });
        // 创建语义
        List<Semanteme> semantemes = new LinkedList<>();
        semantemeTypes.forEach(semantemeType -> {
            String semantemeTypeId = semantemeType.getId();
            // 限定语义类型循环处理
            List<TransPropertyResult> needSaveResults = needTransResults.stream()
                    .filter(s -> StringUtils.equals(s.getPropertyName(), semantemeType.getPropertyName()))
                    .collect(Collectors.toList());
            needSaveResults.forEach(s -> {
                // 通过语义类型和属性值获取语义
                Semanteme semanteme = semantemeDao.findBySemantemeTypeIdAndPropertyValue(semantemeTypeId, s.getPropertyValue());
                if (Objects.isNull(semanteme)) {
                    semanteme = new Semanteme();
                    semanteme.setSemantemeTypeId(semantemeTypeId);
                    semanteme.setPropertyValue(s.getPropertyValue());
                    semanteme.setSemantemeType(semantemeType);
                    semantemeDao.save(semanteme);
                }
                semantemes.add(semanteme);
            });
        });
        // 创建译文
        semantemes.forEach(semanteme -> {
            // 直接循环语义处理
            Optional<TransPropertyResult> needSaveOptional = needTransResults.stream()
                    .filter(s -> StringUtils.equals(s.getPropertyName(), semanteme.getSemantemeType().getPropertyName())
                            && StringUtils.equals(s.getPropertyValue(), semanteme.getPropertyValue()))
                    .findAny();
            if (needSaveOptional.isPresent()) {
                TransPropertyResult needSaveResult = needSaveOptional.get();
                // 如果翻译结果不为空，并且翻译结果不等于语义，则需要保存默认的翻译结果
                if (!StringUtils.equals(needSaveResult.getPropertyValue(), needSaveResult.getTransValue())
                        && StringUtils.isNotBlank(needSaveResult.getTransValue())) {
                    String semantemeId = semanteme.getId();
                    Translation translation = translationDao.findByLanguageIdAndSemantemeId(languageId, semantemeId);
                    if (Objects.isNull(translation)) {
                        translation = new Translation();
                        translation.setLanguageId(languageId);
                        translation.setSemantemeId(semantemeId);
                        translation.setTransValue(needSaveResult.getTransValue());
                        translationDao.save(translation);
                    }
                }
            }
        });
    }

    /**
     * 保存译文
     *
     * @param saveParam 保存参数
     * @return 操作结果
     */
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(allEntries = true)
    public OperateResultWithData<Translation> saveTranslation(TranslationParam saveParam) {
        // 获取语义
        Semanteme semanteme = semantemeDao.findBySemantemeTypeIdAndPropertyValue(saveParam.getSemantemeTypeId(), saveParam.getPropertyValue());
        if (Objects.isNull(semanteme)) {
            // 语义【{0}】不存在！
            return OperateResultWithData.operationFailure("00016", saveParam.getPropertyValue());
        }
        // 获取现有译文
        Translation translation = dao.findByLanguageIdAndSemantemeId(saveParam.getLanguageId(), semanteme.getId());
        if (Objects.isNull(translation)) {
            translation = new Translation();
            translation.setLanguageId(saveParam.getLanguageId());
            translation.setSemantemeId(semanteme.getId());
        }
        // 更新翻译结果
        translation.setTransValue(saveParam.getTransValue());
        return save(translation);
    }
}
