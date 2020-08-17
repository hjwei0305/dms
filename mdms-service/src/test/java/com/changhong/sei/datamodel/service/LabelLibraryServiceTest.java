package com.changhong.sei.datamodel.service;

import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.datamodel.entity.LabelLibrary;
import com.changhong.sei.datamodel.service.LabelLibraryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-07-29 13:35
 */
public class LabelLibraryServiceTest extends BaseUnitTest {

    @Autowired
    private LabelLibraryService service;

    @Test
    public void save() {
        LabelLibrary label = new LabelLibrary();
        label.setCode("test");
        label.setName("测试");
        OperateResultWithData<LabelLibrary> result = service.save(label);
        System.out.println(result);
    }
}