package com.changhong.sei.dms.management.service.client;

import com.changhong.sei.core.log.LogUtil;
import com.changhong.sei.core.util.JsonUtils;
import com.changhong.sei.dms.common.utils.StringListUtil;
import com.changhong.sei.dms.management.dto.trans.TransPropertyResult;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.tmt.v20180321.TmtClient;
import com.tencentcloudapi.tmt.v20180321.models.TextTranslateBatchRequest;
import com.tencentcloudapi.tmt.v20180321.models.TextTranslateBatchResponse;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 实现功能: 腾讯翻译服务调用
 *
 * @author 王锦光 wangjg
 * @version 2020-04-20 14:52
 */
@Component
public class TencentTransManager {
    /**
     * 单次最大翻译量
     */
    private final int MAX_LINE = 100;

    /**
     * 单次翻译
     * @param queries 需要翻译的语句清单
     * @param from 语种（从）
     * @param to 语种（到）
     * @return 翻译结果
     */
    private Map<String, String> getTransResultOnce(List<String> queries, String from, String to) {
        Map<String, String> result = new LinkedHashMap<>();
        try{
            Credential cred = new Credential("AKIDCAwSlnhAVTHuHUp960CgusStT0a0LVs0", "tVyMZZJoIekZlhfMn8mBKEsaDZeYsxmR");
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("tmt.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            TmtClient client = new TmtClient(cred, "ap-chengdu", clientProfile);
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("SourceTextList", queries);
            params.put("Source", from);
            params.put("Target", to);
            params.put("ProjectId", 0);
            TextTranslateBatchRequest req = TextTranslateBatchRequest.fromJsonString(JsonUtils.toJson(params), TextTranslateBatchRequest.class);
            TextTranslateBatchResponse resp = client.TextTranslateBatch(req);
            for (int i = 0; i < queries.size(); i++) {
                result.put(queries.get(i), resp.getTargetTextList()[i]);
            }
        } catch (TencentCloudSDKException e) {
            LogUtil.error("腾讯翻译异常！", e);
        }
        return result;
    }

    /**
     * 翻译
     * @param queries 需要翻译的语句清单
     * @param from 语种（从）
     * @param to 语种（到）
     * @return 翻译结果
     */
    public Map<String, String> getTransResult(List<String> queries, String from, String to) {
        List<List<String>> querySet = StringListUtil.getList(MAX_LINE, queries);
        Map<String, String> result = new LinkedHashMap<>();
        for (List<String> query : querySet) {
            if (result.size() > 0) {
                // 两次调用之间间隔1秒
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Map<String, String> onceResult = getTransResultOnce(query, from, to);
            onceResult.forEach(result::put);
        }
        return result;
    }

    /**
     * 腾讯翻译
     * @param needTransResults 需要翻译的内容
     * @param from 源语言
     * @param to 目标语言
     */
    public void translate(List<TransPropertyResult> needTransResults, String from, String to) {
        List<String> queries = needTransResults.stream().map(TransPropertyResult::getPropertyValue).collect(Collectors.toList());
        Map<String, String> transResult = getTransResult(queries, from, to);
        needTransResults.forEach( r-> r.setTransValue(transResult.get(r.getPropertyValue())));
    }
}
