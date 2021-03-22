package com.changhong.sei.mdms.management.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.log.LogUtil;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.utils.ResultDataUtil;
import com.changhong.sei.mdms.management.api.TranslationApi;
import com.changhong.sei.mdms.management.dto.LanguageDto;
import com.changhong.sei.mdms.management.dto.TranslationDto;
import com.changhong.sei.mdms.management.dto.TranslationParam;
import com.changhong.sei.mdms.management.dto.search.TranslationQuickQueryParam;
import com.changhong.sei.mdms.management.dto.trans.*;
import com.changhong.sei.mdms.management.entity.Language;
import com.changhong.sei.mdms.management.entity.Translation;
import com.changhong.sei.mdms.management.service.LanguageService;
import com.changhong.sei.mdms.management.service.TranslationService;
import com.changhong.sei.mdms.management.service.client.TencentTransManager;
import com.changhong.sei.utils.AsyncRunUtil;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;

/**
 * 实现功能: 译文表API服务实现
 *
 * @author 王锦光 wangjg
 * @version 2020-03-22 8:04
 */
@RestController
@Api(value = "TranslationApi", tags = "译文表API服务实现")
@RequestMapping(path = "translation", produces = MediaType.APPLICATION_JSON_VALUE)
public class TranslationController extends BaseEntityController<Translation, TranslationDto>
        implements TranslationApi {
    private final TranslationService service;
    @Autowired
    private TencentTransManager transManager;
    @Autowired
    private LanguageService languageService;
    @Autowired
    private AsyncRunUtil asyncRunUtil;
    /**
     * 默认的翻译基础语言代码
     */
    private final String FROM_LANG = StringUtils.left(LanguageDto.DEFAULT_LANG, 2);

    public TranslationController(TranslationService service) {
        this.service = service;
    }

    @Override
    public BaseEntityService<Translation> getService() {
        return service;
    }

    /**
     * 自定义设置Entity转换为DTO的转换器
     */
    @Override
    protected void customConvertToDtoMapper() {
        // 创建自定义映射规则
        PropertyMap<Translation, TranslationDto> propertyMap = new PropertyMap<Translation, TranslationDto>() {
            @Override
            protected void configure() {
                // 使用自定义转换规则
                map().setLanguageId(source.getLanguageId());
                map().setSemantemeId(source.getSemantemeId());
            }
        };
        // 添加映射器
        dtoModelMapper.addMappings(propertyMap);
    }

    /**
     * 通过翻译请求获取翻译结果
     *
     * @param request 翻译请求
     * @return 翻译结果
     */
    @Override
    public ResultData<TranslateResponse> translate(@Valid TranslateRequest request) {
        TranslateResponse response = new TranslateResponse();
        String langCode = request.getLangCode();
        // 获取语言类型
        Language language = languageService.findByCode(langCode);
        if (Objects.isNull(language)) {
            // 语言代码【{0}】在系统中没有维护！
            return ResultDataUtil.fail("00015", langCode);
        }
        String className = request.getClassName();
        List<String> propertyNames = request.getPropertyNames();
        // 获取已经存在的翻译结果
        List<TransPropertyResult> transPropertyResults = new LinkedList<>();
        propertyNames.forEach(propertyName -> {
            List<TransPropertyResult> transResults = service.getTranslations(langCode, className, propertyName);
            transPropertyResults.addAll(transResults);
        });
        // 定义返回的翻译结果
        List<TransPropertyResult> transReturnResults = new LinkedList<>();
        // 定义需要保存的语义和译文
        List<TransPropertyResult> needTransResults = new LinkedList<>();
        // 匹配翻译请求的属性
        List<TransPropertyValue> propertyValues = request.getPropertyValues();
        propertyValues.forEach(v -> {
            Optional<TransPropertyResult> transResult = transPropertyResults.stream().filter(t -> StringUtils.equals(v.getPropertyName(), t.getPropertyName())
                    && StringUtils.equals(v.getPropertyValue(), t.getPropertyValue())).findAny();
            if (transResult.isPresent()) {
                transReturnResults.add(transResult.get());
            } else {
                TransPropertyResult needTransResult = new TransPropertyResult();
                needTransResult.setPropertyName(v.getPropertyName());
                needTransResult.setPropertyValue(v.getPropertyValue());
                transReturnResults.add(needTransResult);
                needTransResults.add(needTransResult);
            }
        });
        // 调用翻译API执行默认翻译
        transManager.translate(needTransResults, FROM_LANG, language.getBaseCode());
        response.setTransPropertyResults(transReturnResults);
        // 异步保存不存在的语义和译文
        asyncRunUtil.runAsync(() -> {
            try {
                service.saveNeedTransResults(language.getId(), className, needTransResults);
            } catch (Exception e) {
                LogUtil.error("保存不存在的语义和译文时发生异常！", e);
            }
        });
        return ResultData.success(response);
    }

    /**
     * 查询指定语种和语义类型的译文
     *
     * @param queryParam 查询参数
     * @return 翻译结果
     */
    @Override
    public ResultData<PageResult<TransPropertyResult>> findTranslationsByPage(@Valid TranslationQuickQueryParam queryParam) {
        return ResultData.success(service.findTranslationsByPage(queryParam));
    }

    /**
     * 保存译文
     *
     * @param saveParam 保存参数
     * @return 操作结果
     */
    @Override
    public ResultData<?> saveTranslation(@Valid TranslationParam saveParam) {
        return ResultDataUtil.convertFromOperateResult(service.saveTranslation(saveParam), null);
    }

    /**
     * 通过业务实体属性名获取翻译结果
     *
     * @param langCode     目标语言代码
     * @param className    业务实体类型全名
     * @param propertyName 业务实体属性名
     * @return 翻译结果
     */
    @Override
    public List<TransPropertyResult> getTranslations(String langCode, String className, String propertyName) {
        return service.getTranslations(langCode, className, propertyName);
    }

    /**
     * 翻译
     *
     * @param query 翻译请求
     * @return 翻译结果
     */
    @Override
    public ResultData<Map<String, String>> getTransResult(TranslateQuery query) {
        Map<String, String> data = transManager.getTransResult(query.getQueries(), FROM_LANG, query.getTo());
        return ResultData.success(data);
    }
}
