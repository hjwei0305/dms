package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.dto.serach.SearchFilter;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.ResponseData;
import com.changhong.sei.dms.general.dao.PaymentInfoDao;
import com.changhong.sei.dms.general.dto.PaymentInfoUseScopeEnum;
import com.changhong.sei.dms.general.dto.ReceiverInfoDto;
import com.changhong.sei.dms.general.dto.ReceiverTypeEnum;
import com.changhong.sei.dms.general.entity.Customer;
import com.changhong.sei.dms.general.entity.PaymentInfo;
import com.changhong.sei.dms.general.entity.Personnel;
import com.changhong.sei.dms.general.entity.Supplier;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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
    /**
     * 员工信息服务
     */
    @Autowired
    private PersonnelService personnelService;
    /**
     * 供应商信息服务
     */
    @Autowired
    private SupplierService supplierService;
    /**
     * 客户信息服务
     */
    @Autowired
    private CustomerService customerService;

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
        if (!Objects.equals(PaymentInfoUseScopeEnum.ALL, useScope)) {
            useScopeList.add(PaymentInfoUseScopeEnum.ALL);
        }
        search.addFilter(new SearchFilter("useScope", useScopeList, SearchFilter.Operator.IN));
        return ResponseData.operationSuccessWithData(findByFilters(search));
    }


    /**
     * 通过银行账号获取收款方信息(左模糊匹配银行账号)
     *
     * @param bankAccountNumber 银行账号
     * @param receiverType      收款对象类型:H-员工，K-供应商，D-客户
     * @return 支付信息
     */
    public ReceiverInfoDto findReceiverInfoByBankAccountNumber(String bankAccountNumber, ReceiverTypeEnum receiverType) {
        // 获取支付信息=有些账号前面维护了地区码，所以启用右匹配
        Search search = new Search();
        search.addFilter(new SearchFilter("receiverType", receiverType));
        search.addFilter(new SearchFilter("bankAccountNumber", bankAccountNumber, SearchFilter.Operator.RLK));
        PaymentInfo paymentInfo = findFirstByFilters(search);
        if (Objects.isNull(paymentInfo)) {
            return null;
        }
        ReceiverInfoDto receiverInfo = new ReceiverInfoDto();
        receiverInfo.setId(paymentInfo.getReceiverId());
        receiverInfo.setCode(paymentInfo.getReceiverCode());
        receiverInfo.setName(paymentInfo.getReceiverName());
        receiverInfo.setReceiverType(receiverType);
        String receiverCode = paymentInfo.getReceiverCode();
        // 获取ERP信息
        switch (receiverType) {
            case H:
                Personnel personnel = personnelService.findByCode(receiverCode);
                if (Objects.nonNull(personnel)) {
                    receiverInfo.setAccountGroup(personnel.getPersonnelGroup());
                }
                break;
            case K:
                Supplier supplier = supplierService.findByCode(receiverCode);
                if (Objects.nonNull(supplier)) {
                    receiverInfo.setAccountGroup(supplier.getAccountGroup());
                }
                break;
            case D:
                Customer customer = customerService.findByCode(receiverCode);
                if (Objects.nonNull(customer)) {
                    receiverInfo.setAccountGroup(customer.getAccountGroup());
                }
                break;
            default:
                break;
        }
        return receiverInfo;
    }


    /**
     * 获取指定代码的收款方默认支付信息
     *
     * @param receiverType 收款对象类型
     * @param receiverCode 收款对象代码
     * @return 支付信息清单
     */
    public PaymentInfo findDefaultPaymentInfo(ReceiverTypeEnum receiverType, String receiverCode) {
        List<PaymentInfo> paymentInfos = dao.findReceiverPaymentInfos(receiverType, receiverCode, ContextUtil.getTenantCode());
        if (CollectionUtils.isEmpty(paymentInfos)) {
            return null;
        }
        return paymentInfos.get(0);
    }
}