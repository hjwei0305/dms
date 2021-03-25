package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.test.BaseUnit5Test;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2021-03-25 16:55
 */
class DataDictServiceTest extends BaseUnit5Test {

    @Autowired
    private DataDictService service;

    @Test
    void saveDictItem() {
    }

    @Test
    void deleteDictItem() {
    }

    @Test
    void getDataDictItems() {
    }

    @Test
    void batchSaveDataDict() {
    }

    @Test
    void getDataDictItem() {
    }

    @Test
    void tenantPrivate() {
        service.tenantPrivate("609236C2-56E0-11EB-9F0C-0242C0A84624", true);
    }
}