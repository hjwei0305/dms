package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.dto.serach.SearchFilter;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.core.util.JsonUtils;
import com.changhong.sei.dms.general.dto.LedgerAccountCorporationDto;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * 实现功能:
 *
 * @author 冯华
 * @create 2021-04-19 14:35
 */
public class LedgerAccountControllerTest extends BaseUnitTest {

    @Autowired
    private LedgerAccountController controller;

    @Test
    public void findCorporationInfoByPage() {
        Search search = new Search();
        search.addFilter(new SearchFilter("erpCorporationCode", "1100"));
        search.addFilter(new SearchFilter("ledgerAccount.code", "0010000000"));
        ResultData<PageResult<LedgerAccountCorporationDto>> resultData = controller.findCorporationInfoByPage(search);
        Assert.isTrue(resultData.successful());
    }

    @Test
    public void findByCode() {
        String code = "0010020103";
        ResultData<?> resultData = controller.findByCode(code);
        System.out.println(JsonUtils.toJson(resultData));
        Assertions.assertTrue(resultData.successful());
    }
}
