package com.changhong.sei.dms.management.service;

import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.dms.management.entity.DataCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-09-28 10:18
 */
public class DataCategoryServiceTest extends BaseUnitTest {

    @Autowired
    private DataCategoryService service;

    @Test
    public void save() {
        DataCategory category = new DataCategory();
        category.setName("test123");
        service.save(category);
    }

    @Test
    public void getTreeByCode() {
    }
}