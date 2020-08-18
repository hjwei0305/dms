package com.changhong.sei.mdms.management.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.mdms.management.dto.EntityDto;
import com.changhong.sei.mdms.management.dto.MasterDataRegisterDto;
import com.changhong.sei.mdms.management.dto.MasterDataUiConfigDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-08-16 18:03
 */
public class MasterDataUiConfigControllerTest extends BaseUnitTest {

    @Autowired
    private MasterDataUiConfigController controller;

    @Test
    public void register() {
        MasterDataRegisterDto request = new MasterDataRegisterDto();
        request.setCode("dataModel");
        request.setName("数据模型");
        request.setFullName("com.changhong.sei.datamodel.entity.DataModel");
        request.setTypeCode("master_data");
        request.setTypeName("master_data");
        ResultData<String> resultData = controller.register(request);
        System.out.println(resultData);
    }

    @Test
    public void getConfigByTypeCode() {
        ResultData<List<MasterDataUiConfigDto>> resultData = controller.getConfigByTypeCode("master_data");
        System.out.println(resultData);
    }

    @Test
    public void getAllMasterData() {
        ResultData<List<EntityDto>> resultData = controller.getAllMasterData();
        System.out.println(resultData);
    }

    @Test
    public void getPropertiesByCode() {
        ResultData<List<EntityDto.Property>> resultData = controller.getPropertiesByCode("country");
        System.out.println(resultData);
    }
}