package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.core.util.JsonUtils;
import com.changhong.sei.dms.general.dto.CorpPaymentBankAccountDto;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 实现功能:
 *
 * @author 冯华
 * @create 2021-11-17 14:39
 */
public class CorpPaymentBankAccountControllerTest extends BaseUnitTest {
    @Autowired
    private CorpPaymentBankAccountController controller;

    @Test
   public void findByCorpAndBankCategory() {
        ResultData<List<CorpPaymentBankAccountDto>> resultData = controller.findByCorpAndBankCategory("Q000","103");
        System.out.println(JsonUtils.toJson(resultData));
        Assertions.assertTrue(resultData.successful());
    }
}
