package com.changhong.sei.mdms.management.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.mdms.management.dto.DataDefinitionDto;
import com.changhong.sei.mdms.management.dto.DataStructureEnum;
import com.changhong.sei.mdms.management.dto.EntityDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-08-16 18:03
 */
public class DataConfigControllerTest extends BaseUnitTest {

    @Autowired
    private DataDefinitionController controller;

    @Test
    public void register() {
        DataDefinitionDto request = new DataDefinitionDto();
        request.setCode("dataModel");
        request.setName("数据模型");
        request.setDataStructure(DataStructureEnum.GENERAL);
        request.setCategoryId("master_data");
        request.setCategoryName("master_data");
        ResultData<String> resultData = controller.register(request);
        System.out.println(resultData);
    }

    @Test
    public void getConfigByTypeCode() {
        ResultData<List<DataDefinitionDto>> resultData = controller.getConfigByCategoryId("master_data");
        System.out.println(resultData);
    }

    @Test
    public void getAllMasterData() {
        ResultData<List<EntityDto>> resultData = controller.getAllMasterData();
        System.out.println(resultData);
    }

    @Test
    public void getPropertiesByCode() {
        ResultData<List<EntityDto.Property>> resultData = controller.getPropertiesByCode("123");
        System.out.println(resultData);
    }
}