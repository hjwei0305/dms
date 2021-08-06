package com.changhong.sei.dms.general.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.dms.general.dto.ReceiverTypeEnum;
import com.changhong.sei.dms.general.entity.PaymentInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 支付信息(PaymentInfo)数据库访问类
 *
 * @author sei
 * @since 2021-06-29 09:17:26
 */
@Repository
public interface PaymentInfoDao extends BaseEntityDao<PaymentInfo> {
    /**
     * 通过类型和代码获取支付信息
     * @param receiverTypeEnum 收款方类型
     * @param receiverCode 收款方代码
     * @param tenantCode 租户代码
     * @return 支付信息
     */
    @Query("select info from PaymentInfo info where info.receiverType=?1 " +
            "and info.receiverCode=?2 and info.tenantCode=?3 and info.frozen = false " +
            "order by info.createdDate desc ")
    List<PaymentInfo> findReceiverPaymentInfos(ReceiverTypeEnum receiverTypeEnum, String receiverCode, String tenantCode);
}