package com.changhong.sei.mdms.general.service;

import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.core.util.JsonUtils;
import com.changhong.sei.mdms.general.entity.Region;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-08-25 13:26
 */
public class RegionServiceTest extends BaseUnitTest {

    @Autowired
    private RegionService service;

    @Test
    public void save() {
        String json = "{\"code\":\"test\",\"name\":\"12312\",\"rank\":\"3\",\"parentId\":\"79427182-E693-11EA-BB75-0242C0A84605\"}";
        Region region = JsonUtils.fromJson(json, Region.class);
        OperateResultWithData<Region> result = service.save(region);
        System.out.println(result);
    }
}