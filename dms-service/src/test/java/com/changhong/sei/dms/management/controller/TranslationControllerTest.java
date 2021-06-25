package com.changhong.sei.dms.management.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnit5Test;
import com.changhong.sei.core.util.JsonUtils;
import com.changhong.sei.dms.management.dto.trans.TranslateRequest;
import com.changhong.sei.dms.management.dto.trans.TranslateResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 实现功能:
 *
 * @author 王锦光 wangjg
 * @version 2021-06-25 11:01
 */
class TranslationControllerTest extends BaseUnit5Test {
    @Autowired
    private TranslationController controller;

    @Test
    public void translate() throws Exception{
        String json = "{\"className\":\"com.changhong.sei.dms.general.dto.DataDictValue\",\"propertyNames\":[\"dataName\"],\"langCode\":\"en_US\",\"propertyValues\":[{\"propertyName\":\"dataName\",\"propertyValue\":\"身份证\"},{\"propertyName\":\"dataName\",\"propertyValue\":\"护照\"},{\"propertyName\":\"dataName\",\"propertyValue\":\"驾驶证\"}]}\n";
        TranslateRequest request = JsonUtils.fromJson(json, TranslateRequest.class);
        ResultData<TranslateResponse> resultData = controller.translate(request);
        System.out.println(JsonUtils.toJson(resultData));
        Thread.sleep(60*1000);
        Assertions.assertTrue(resultData.successful());
    }
}