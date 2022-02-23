package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnit5Test;
import com.changhong.sei.core.util.JsonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @desc：
 * @author：zhaohz
 * @date：2022/2/17 17:17
 */
public class CurrencyControllerTest extends BaseUnit5Test {

    @Autowired
    private CurrencyController controller;

    @Test
    void findByCode() {
        String code = "CNY";
        ResultData<?> resultData = controller.findByCode(code);
        System.out.println(JsonUtils.toJson(resultData));
        Assertions.assertTrue(resultData.successful());
    }
}