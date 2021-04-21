package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnit5Test;
import com.changhong.sei.dms.general.dto.HrOrganizationDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2021-04-21 15:55
 */
class HrOrganizationServiceTest extends BaseUnit5Test {
    @Autowired
    private HrOrganizationService service;

    @Test
    void save() {
    }

    @Test
    void getUnfrozenTree() {
        ResultData<List<HrOrganizationDto>> tree = service.getUnfrozenTree();
        System.out.println(tree);
    }

    @Test
    void insertRelation() {
    }

    @Test
    void removeRelation() {
    }
}