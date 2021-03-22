package com.changhong.sei.mdms.management.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.mdms.management.dto.TranslationDto;
import com.changhong.sei.mdms.management.dto.TranslationParam;
import com.changhong.sei.mdms.management.dto.search.TranslationQuickQueryParam;
import com.changhong.sei.mdms.management.dto.trans.TransPropertyResult;
import com.changhong.sei.mdms.management.dto.trans.TranslateQuery;
import com.changhong.sei.mdms.management.dto.trans.TranslateRequest;
import com.changhong.sei.mdms.management.dto.trans.TranslateResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 实现功能: 译文表API接口
 *
 * @author 王锦光 wangjg
 * @version 2020-03-22 8:00
 */
@FeignClient(name = "sei-commons-data", path = "translation")
public interface TranslationApi extends BaseEntityApi<TranslationDto> {
    /**
     * 通过翻译请求获取翻译结果
     * @param request 翻译请求
     * @return 翻译结果
     */
    @PostMapping(path = "translate", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "通过翻译请求获取翻译结果", notes = "对输入的业务实体属性值清单进行翻译，并返回翻译结果")
    ResultData<TranslateResponse> translate(@RequestBody @Valid TranslateRequest request);

    /**
     * 查询指定语种和语义类型的译文
     * @param queryParam 查询参数
     * @return 翻译结果
     */
    @PostMapping(path = "findTranslationsByPage", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "查询指定语种和语义类型的译文", notes = "通过外国语种Id和语义类型Id获取翻译结果的分页查询")
    ResultData<PageResult<TransPropertyResult>> findTranslationsByPage(@RequestBody @Valid TranslationQuickQueryParam queryParam);

    /**
     * 保存译文
     * @param saveParam 保存参数
     * @return 操作结果
     */
    @PostMapping(path = "saveTranslation", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "保存译文", notes = "输入译文参数保存一个翻译结果")
    ResultData<?> saveTranslation(@RequestBody @Valid TranslationParam saveParam);

    /**
     * 通过业务实体属性名获取翻译结果
     *
     * @param langCode     目标语言代码
     * @param className    业务实体类型全名
     * @param propertyName 业务实体属性名
     * @return 翻译结果
     */
    @GetMapping(path = "getTranslations")
    @ApiOperation(value = "通过业务实体属性名获取翻译结果", notes = "通过业务实体全类名和属性名获取指定语言代码的翻译结果")
    List<TransPropertyResult> getTranslations(@RequestParam("langCode") String langCode,
                                              @RequestParam("className") String className,
                                              @RequestParam("propertyName") String propertyName);

    /**
     * 翻译
     * @param query 翻译请求
     * @return 翻译结果
     */
    @PostMapping(path = "getTransResult", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "翻译", notes = "SEI平台提供的多语言翻译服务")
    ResultData<Map<String, String>> getTransResult(@RequestBody TranslateQuery query);
}
