package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageInfo;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.dto.serach.SearchFilter;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.core.util.JsonUtils;
import com.changhong.sei.dms.general.dto.MobileRegionDto;
import com.changhong.sei.dms.general.dto.RegionDto;
import com.changhong.sei.dms.general.dto.search.MobileRegionParam;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

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


    @Test
    public void getConverters() {
        MobileRegionParam param = new MobileRegionParam();
        ResultData<Map<String, List<MobileRegionDto>>> resultData = controller.getRegionByInitials(param);
        Assert.assertTrue(resultData.successful());
    }
}