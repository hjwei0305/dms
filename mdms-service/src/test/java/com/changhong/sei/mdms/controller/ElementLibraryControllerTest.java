package com.changhong.sei.mdms.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.core.util.JsonUtils;
import com.changhong.sei.mdms.dao.ElementLibraryDao;
import com.changhong.sei.mdms.dto.ElementLibraryDto;
import com.changhong.sei.mdms.entity.ElementLibrary;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-07-29 17:53
 */
public class ElementLibraryControllerTest extends BaseUnitTest {

    @Autowired
    private ElementLibraryController controller;

    @Test
    public void save() {
        String json = "{\"code\":\"23d2d\",\"name\":\"rrr\",\"dataType\":\"金额\",\"dataLength\":32,\"precision\":8,\"remark\":\"rr\",\"frozen\":false}";
        ElementLibraryDto dto = JsonUtils.fromJson(json, ElementLibraryDto.class);
        ResultData<ElementLibraryDto> resultData = controller.save(dto);
        System.out.println(resultData);
    }
}