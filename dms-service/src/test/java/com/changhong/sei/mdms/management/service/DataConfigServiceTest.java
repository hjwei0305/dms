package com.changhong.sei.mdms.management.service;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.mdms.management.dto.EntityDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-08-15 02:04
 */
public class DataConfigServiceTest extends BaseUnitTest {

    @Autowired
    private DataDefinitionService service;

    @Test
    public void getAllMasterDataEntities() {
        ResultData<List<EntityDto>> entityDtos = service.getAllMasterDataEntities();
        System.out.println(entityDtos);
    }

    @Test
    public void getPropertiesByCode() {
        ResultData<List<EntityDto.Property>> entityDtos = service.getPropertiesByCode("dataModel");
        System.out.println(entityDtos);
    }
}