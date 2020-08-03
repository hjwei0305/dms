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
        String json = "{\"id\":\"8C66593D-D527-11EA-A7E6-0242C0A84617\",\"code\":\"companyCode\",\"name\":\"预算公司代码\",\"dataType\":\"MiddleString\",\"dataTypeDesc\":\"字串-中\",\"dataLength\":256,\"precision\":null,\"remark\":\"test\",\"frozen\":false}";
        ElementLibraryDto dto = JsonUtils.fromJson(json, ElementLibraryDto.class);
        ResultData<ElementLibraryDto> resultData = controller.save(dto);
        System.out.println(resultData);
    }
}