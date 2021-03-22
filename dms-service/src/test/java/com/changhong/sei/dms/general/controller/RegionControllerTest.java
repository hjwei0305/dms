package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.core.util.JsonUtils;
import com.changhong.sei.dms.general.dto.RegionDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-08-25 13:31
 */
public class RegionControllerTest extends BaseUnitTest {

    @Autowired
    private RegionController controller;

    @Test
    public void save() {
        String json = "{\"code\":\"test12\",\"name\":\"1231212\",\"rank\":\"2\",\"parentId\":\"79427182-E693-11EA-BB75-0242C0A84605\"}";
        RegionDto region = JsonUtils.fromJson(json, RegionDto.class);
        ResultData<RegionDto> result = controller.save(region);
        System.out.println(result);
    }
}