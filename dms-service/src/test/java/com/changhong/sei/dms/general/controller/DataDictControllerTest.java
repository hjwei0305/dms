package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnit5Test;
import com.changhong.sei.core.util.JsonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 实现功能:
 *
 * @author 王锦光 wangjg
 * @version 2021-06-25 19:11
 */
class DataDictControllerTest extends BaseUnit5Test {
    @Autowired
    private DataDictController controller;

    @Test
    void getCanUseDataDictValues() throws Exception{
        String dictCode = "PUB-List-Sort";
        ResultData<?> resultData = controller.getCanUseDataDictValues(dictCode);
        System.out.println(JsonUtils.toJson(resultData));
        Assertions.assertTrue(resultData.successful());
        Thread.sleep(10*1000);
    }
}