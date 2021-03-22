package com.changhong.sei.dms.management.service.client;//package com.changhong.sei.commondata.service.client;
//
//import com.changhong.sei.commondata.dto.trans.TransPropertyResult;
//import com.changhong.sei.commondata.service.client.dto.TransContent;
//import com.changhong.sei.commondata.service.client.dto.TransResult;
//import com.changhong.sei.commondata.service.utils.StringListUtil;
//import com.changhong.sei.core.log.LogUtil;
//import com.changhong.sei.core.util.JsonUtils;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
///**
// * 实现功能: 百度翻译服务调用
// *
// * @author 王锦光 wangjg
// * @version 2020-03-18 8:58
// */
//@Component
//public class BaiDuTransManager {
//    @Value("${baidu.trans-api.host}")
//    private String apiHost;
//    @Value("${baidu.trans-api.appid}")
//    private String appid;
//    @Value("${baidu.trans-api.security-key}")
//    private String securityKey;
//    /**
//     * 单次最大翻译量
//     */
//    private final int MAX_LINE = 100;
//
//    /**
//     * 单次翻译
//     * @param queries 需要翻译的语句清单
//     * @param from 语种（从）
//     * @param to 语种（到）
//     * @return 翻译结果
//     */
//    private Map<String, String> getTransResultOnce(List<String> queries, String from, String to) {
//        Map<String, String> result = new LinkedHashMap<>();
//        // 用换行符拼接请求
//        StringBuilder queryBuilder = new StringBuilder();
//        for (String query : queries) {
//            if (queryBuilder.length() == 0) {
//                queryBuilder.append(query);
//            } else {
//                queryBuilder.append("\n").append(query);
//            }
//            result.put(query, query);
//        }
//        String json = null;
//        try {
//            Map<String, String> params = buildParams(queryBuilder.toString(), from, to);
//            json = HttpGet.get(apiHost, params);
//            TransResult transResult = JsonUtils.fromJson(json, TransResult.class);
//            List<TransContent> contents = transResult.getTrans_result();
//            contents.forEach(transContent -> {
//                result.put(transContent.getSrc(), transContent.getDst());
//            });
//        } catch (Exception e) {
//            LogUtil.error("百度翻译异常！"+json, e);
//        }
//        return result;
//    }
//
//    /**
//     * 翻译
//     * @param queries 需要翻译的语句清单
//     * @param from 语种（从）
//     * @param to 语种（到）
//     * @return 翻译结果
//     */
//    public Map<String, String> getTransResult(List<String> queries, String from, String to) {
//        List<List<String>> querySet = StringListUtil.getList(MAX_LINE, queries);
//        Map<String, String> result = new LinkedHashMap<>();
//        for (List<String> query : querySet) {
//            if (result.size() > 0) {
//                // 两次调用之间间隔1秒
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            Map<String, String> onceResult = getTransResultOnce(query, from, to);
//            onceResult.forEach(result::put);
//        }
//        return result;
//    }
//
//    /**
//     * 百度翻译
//     * @param needTransResults 需要翻译的内容
//     * @param from 源语言
//     * @param to 目标语言
//     */
//    public void baiduTrans(List<TransPropertyResult> needTransResults, String from, String to) {
//        List<String> queries = needTransResults.stream().map(TransPropertyResult::getPropertyValue).collect(Collectors.toList());
//        Map<String, String> transResult = getTransResult(queries, from, to);
//        needTransResults.forEach( r-> r.setTransValue(transResult.get(r.getPropertyValue())));
//    }
//
//    /**
//     * 生成GET参数
//     * @param query 需要翻译的语句
//     * @param from 语种（从）
//     * @param to 语种（到）
//     * @return 请求的参数
//    */
//    private Map<String, String> buildParams(String query, String from, String to) {
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("q", query);
//        params.put("from", from);
//        params.put("to", to);
//        params.put("appid", appid);
//        // 随机数
//        String salt = String.valueOf(System.currentTimeMillis());
//        params.put("salt", salt);
//        // 签名
//        String src = appid + query + salt + securityKey; // 加密前的原文
//        params.put("sign", MD5.md5(src));
//        return params;
//    }
//}
