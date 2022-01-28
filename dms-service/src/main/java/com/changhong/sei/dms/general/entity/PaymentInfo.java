package com.changhong.sei.dms.general.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.IFrozen;
import com.changhong.sei.core.entity.ITenant;
import com.changhong.sei.dms.general.dto.PaymentInfoUseScopeEnum;
import com.changhong.sei.dms.general.dto.ReceiverTypeEnum;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 支付信息(PaymentInfo)实体类
 *
 * @author sei
 * @since 2021-06-29 09:17:24
 */
@Entity
@Table(name = "payment_info")
@DynamicInsert
@DynamicUpdate
public class PaymentInfo extends BaseAuditableEntity implements Serializable, ITenant, IFrozen {
    private static final long serialVersionUID = 996661538181703153L;
    /**
     * 收款对象类型（供应商K、客户D、员工H）
     */
    @Column(name = "receiver_type")
    @Enumerated(value = EnumType.STRING)
    private ReceiverTypeEnum receiverType;
    /**
     * 收款对象Id
     */
    @Column(name = "receiver_id")
    private String receiverId;
    /**
     * 收款对象代码
     */
    @Column(name = "receiver_code")
    private String receiverCode;
    /**
     * 收款对象名称
     */
    @Column(name = "receiver_name")
    private String receiverName;
    /**
     * 银行Id
     */
    @Column(name = "bank_id")
    private String bankId;
    /**
     * 银行
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "bank_id", insertable = false, updatable = false)
    private Bank bank;
    /**
     * 银行户名
     */
    @Column(name = "bank_account_name")
    private String bankAccountName;
    /**
     * 银行帐号
     */
    @Column(name = "bank_account_number")
    private String bankAccountNumber;
    /**
     * 使用范围
     */
    @Column(name = "use_scope")
    @Enumerated(value = EnumType.STRING)
    private PaymentInfoUseScopeEnum useScope;
    /**
     * 个人账户
     */
    @Column(name = "personal")
    private Boolean personal;
    /**
     * 已冻结
     */
    @Column(name = "frozen")
    private Boolean frozen;
    /**
     * 租户代码
     */
    @Column(name = "tenant_code")
    private String tenantCode;

    public ReceiverTypeEnum getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(ReceiverTypeEnum receiverType) {
        this.receiverType = receiverType;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverCode() {
        return receiverCode;
    }

    public void setReceiverCode(String receiverCode) {
        this.receiverCode = receiverCode;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public PaymentInfoUseScopeEnum getUseScope() {
        return useScope;
    }

    public void setUseScope(PaymentInfoUseScopeEnum useScope) {
        this.useScope = useScope;
    }

    public Boolean getPersonal() {
        return personal;
    }

    public void setPersonal(Boolean personal) {
        this.personal = personal;
    }

    @Override
    public Boolean getFrozen() {
        return frozen;
    }

    @Override
    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    @Override
    public String getTenantCode() {
        return tenantCode;
    }

    @Override
    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

}