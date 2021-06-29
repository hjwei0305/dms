package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.dms.general.dto.PaymentInfoDto;
import com.changhong.sei.dms.general.dto.PaymentInfoUseScopeEnum;
import com.changhong.sei.dms.general.dto.ReceiverInfoDto;
import com.changhong.sei.dms.general.dto.ReceiverTypeEnum;
import com.changhong.sei.util.EnumUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * 支付信息(PaymentInfo)API
 *
 * @author sei
 * @since 2021-06-29 09:17:48
 */
@Valid
@FeignClient(name = "dms", path = PaymentInfoApi.PATH)
public interface PaymentInfoApi extends BaseEntityApi<PaymentInfoDto>, FindByPageApi<PaymentInfoDto> {
    String PATH = "paymentInfo";

    /**
     * 通过收款对象代码获取支付信息清单
     *
     * @param receiverType 收款对象类型
     * @param useScope     使用范围
     * @param receiverCode 收款对象代码
     * @return 支付信息清单
     */
    @GetMapping(path = "findByReceiverCode")
    @ApiOperation(value = "通过收款对象代码获取支付信息清单", notes = "通过收款对象类型、适用范围、收款对象代码获取支付信息清单")
    ResultData<List<PaymentInfoDto>> findByReceiverCode(@RequestParam("receiverType") ReceiverTypeEnum receiverType,
                                                        @RequestParam("useScope") PaymentInfoUseScopeEnum useScope,
                                                        @RequestParam("receiverCode") String receiverCode);


    /**
     * 通过银行账号获取收款方信息(银行账号右匹配)
     *
     * @param bankAccountNumber 银行账号
     * @param receiverType      收款对象类型:H-员工，K-供应商，D-客户
     * @return 支付信息
     */
    @GetMapping(path = "findReceiverInfoByBankAccountNumber")
    @ApiOperation(value = "通过银行账号获取收款方ERP信息(银行账号右匹配)", notes = "通过银行账号获取收款方ERP信息(银行账号右匹配)，收款对象类型:H-员工，K-供应商，D-客户")
    ResultData<ReceiverInfoDto> findReceiverInfoByBankAccountNumber(@RequestParam("bankAccountNumber") String bankAccountNumber,
                                                                    @RequestParam("receiverType") ReceiverTypeEnum receiverType);
}