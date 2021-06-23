package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.test.BaseUnit5Test;
import com.changhong.sei.core.util.JsonUtils;
import com.changhong.sei.dms.general.dto.TaxCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 实现功能：
 *
 * @author 杨沄炜
 * @version 1.0.00  2021/06/23 10:01
 */
class TaxTypeControllerTest extends BaseUnit5Test {

    @Autowired
    private TaxTypeController controller;

    @Test
    void findAll() {
        ResultData<?> resultData = controller.findAll();
        System.out.println(JsonUtils.toJson(resultData));
        Assertions.assertTrue(resultData.successful());
    }

    @Test
    void findByTaxCategory(){
        ResultData<?> resultData = controller.findByTaxCategory(TaxCategory.OUTPUT);
        System.out.println(JsonUtils.toJson(resultData));
        Assertions.assertTrue(resultData.successful());
    }

    @Test
    void findByPage(){
        Search search = new Search();
        ResultData<?> resultData = controller.findByPage(search);
        System.out.println(JsonUtils.toJson(resultData));
        Assertions.assertTrue(resultData.successful());
    }
}