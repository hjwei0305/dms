package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnit5Test;
import com.changhong.sei.core.util.JsonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 实现功能:
 *
 * @author 王锦光 wangjg
 * @version 2021-10-26 15:52
 */
class BankControllerTest extends BaseUnit5Test {
    @Autowired
    private BankController controller;

    @Test
    void findByCode() {
        String code = "103461049831";
        ResultData<?> resultData = controller.findByCode(code);
        System.out.println(JsonUtils.toJson(resultData));
        Assertions.assertTrue(resultData.successful());
    }
}