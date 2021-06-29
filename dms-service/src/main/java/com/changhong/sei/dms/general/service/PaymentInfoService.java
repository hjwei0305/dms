package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.dto.serach.SearchFilter;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.ResponseData;
import com.changhong.sei.dms.general.dao.PaymentInfoDao;
import com.changhong.sei.dms.general.dto.PaymentInfoDto;
import com.changhong.sei.dms.general.dto.PaymentInfoUseScopeEnum;
import com.changhong.sei.dms.general.dto.ReceiverTypeEnum;
import com.changhong.sei.dms.general.entity.PaymentInfo;
import org.apache.curator.shaded.com.google.common.base.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * 支付信息(PaymentInfo)业务逻辑实现类
 *
 * @author sei
 * @since 2021-06-29 09:17:27
 */
@Service("paymentInfoService")
public class PaymentInfoService extends BaseEntityService<PaymentInfo> {
    @Autowired
    private PaymentInfoDao dao;

    @Override
    protected BaseEntityDao<PaymentInfo> getDao() {
        return dao;
    }


    /**
     * 通过收款对象代码获取支付信息清单
     *
     * @param receiverType 收款对象类型
     * @param useScope     使用范围
     * @param receiverCode 收款对象代码
     * @return 支付信息清单
     */
    public ResponseData<List<PaymentInfo>> findByReceiverCode(ReceiverTypeEnum receiverType, PaymentInfoUseScopeEnum useScope, String receiverCode) {
        Search search = new Search();
        search.addFilter(new SearchFilter("receiverType", receiverType));
        search.addFilter(new SearchFilter("receiverCode", receiverCode));
        //使用范围包含所有
        List<PaymentInfoUseScopeEnum> useScopeList = new ArrayList<>();
        useScopeList.add(useScope);
        if (!Objects.equal(PaymentInfoUseScopeEnum.ALL, useScope)) {
            useScopeList.add(PaymentInfoUseScopeEnum.ALL);
        }
        search.addFilter(new SearchFilter("useScope", useScopeList, SearchFilter.Operator.IN));
        return ResponseData.operationSuccessWithData(findByFilters(search));
    }

}