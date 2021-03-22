package com.changhong.sei.dms.management.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnit5Test;
import com.changhong.sei.dms.management.dto.DataDefinitionDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2021-02-22 21:52
 */
class AppSubscriptionControllerTest extends BaseUnit5Test {

    @Autowired
    private AppSubscriptionController controller;

    @Test
    void saveApp() {
    }

    @Test
    void findByPage() {
    }

    @Test
    void getUnassignedChildren() {
        ResultData<List<DataDefinitionDto>> resultData = controller.getUnassignedChildren("测试1");
        System.out.println(resultData);
    }

    @Test
    void getDataFromAppCode() {
    }

    @Test
    void saveRelation() {
    }

    @Test
    void removeRelations() {
    }
}