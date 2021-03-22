package com.changhong.sei.dms.multilingual.sdk.client;

import com.changhong.sei.apitemplate.ApiTemplate;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.dms.multilingual.sdk.client.dto.TransPropertyResult;
import com.changhong.sei.dms.multilingual.sdk.client.dto.TranslateQuery;
import com.changhong.sei.dms.multilingual.sdk.client.dto.TranslateRequest;
import com.changhong.sei.dms.multilingual.sdk.client.dto.TranslateResponse;
import com.changhong.sei.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 实现功能: 调用译文API服务
 *
 * @author 王锦光 wangjg
 * @version 2020-03-23 11:19
 */
@Component
public class TranslationManager {
    @Autowired
    private ApiTemplate apiTemplate;
    private final String APP_CODE = "sei-commons-data";

    /**
     * 通过翻译请求获取翻译结果
     *
     * @param request 翻译请求
     * @return 翻译结果
     */
    public List<TransPropertyResult> translate(TranslateRequest request) {
        String path = "translation/translate";
        ResultData<TranslateResponse> resultData = apiTemplate.postByAppModuleCode(APP_CODE, path, new ParameterizedTypeReference<ResultData<TranslateResponse>>() {
        }, request);
        if (resultData.failed()) {
            throw new ServiceException("通过翻译请求获取翻译结果失败！" + resultData.getMessage());
        }
        TranslateResponse response = resultData.getData();
        if (Objects.isNull(response)) {
            throw new ServiceException("通过翻译请求获取翻译结果失败！返回的数据为空！");
        }
        return response.getTransPropertyResults();
    }

    /**
     * 调用SEI平台提供的多语言翻译服务
     *
     * @param query 翻译请求
     * @return 翻译结果
     */
    public Map<String, String> getTransResult(TranslateQuery query) {
        String path = "translation/getTransResult";
        ResultData<Map<String, String>> resultData = apiTemplate.postByAppModuleCode(APP_CODE, path, new ParameterizedTypeReference<ResultData<Map<String, String>>>() {
        }, query);
        if (resultData.failed()) {
            throw new ServiceException("调用SEI平台提供的多语言翻译服务失败！" + resultData.getMessage());
        }
        return resultData.getData();
    }
}
