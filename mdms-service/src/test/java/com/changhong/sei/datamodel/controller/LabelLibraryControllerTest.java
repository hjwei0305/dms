package com.changhong.sei.datamodel.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.datamodel.controller.LabelLibraryController;
import com.changhong.sei.datamodel.dto.LabelLibraryDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-07-29 13:39
 */
public class LabelLibraryControllerTest extends BaseUnitTest {
    @Autowired
    private LabelLibraryController controller;

    @Test
    public void save() {
        LabelLibraryDto label = new LabelLibraryDto();
        label.setCode("test1");
        label.setName("测试");
        ResultData<LabelLibraryDto> result = controller.save(label);
        System.out.println(result);
    }
}