package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.dms.general.dto.PaymentInfoDto;
import com.changhong.sei.dms.general.dto.PaymentInfoUseScopeEnum;
import com.changhong.sei.dms.general.dto.ReceiverTypeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 实现功能:支付信息测试
 *
 * @author 冯华
 * @create 2021-06-29 15:20
 */
public class PaymentInfoControllerTest extends BaseUnitTest {

    @Autowired
    private PaymentInfoController controller;

    @Test
    public void findByReceiverCode() {
        ResultData<List<PaymentInfoDto>> resultData = controller.findByReceiverCode(ReceiverTypeEnum.K, PaymentInfoUseScopeEnum.CASH, "Q60002");
        Assert.assertTrue(resultData.successful());
    }
}
