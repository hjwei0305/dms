package com.changhong.sei.mdms.management.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.IFrozen;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 实现功能：应用数据订阅管理
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2021-02-22 10:28
 */
@Entity
@Table(name = "_subscription")
@DynamicInsert
@DynamicUpdate
public class Subscription extends BaseAuditableEntity implements Serializable, IFrozen {
    private static final long serialVersionUID = -8289122883080864166L;
    public static final String FIELD_APP_CODE = "appCode";
    /**
     * 应用服务代码
     */
    @Column(name = "app_code", nullable = false)
    private String appCode;
    /**
     * 数据代码
     */
    @Column(name = "data_code", nullable = false)
    private String dataCode;
    /**
     * 数据名称
     */
    @Column(name = "data_name")
    private String dataName;
    /**
     * 冻结
     */
    @Column(name = "frozen_")
    private Boolean frozen;
    /**
     * 描述说明
     */
    @Column(name = "remark")
    private String remark;
    /**
     * 拥有者名称
     */
    @Column(name = "owner_name")
    private String ownerName;
    /**
     * 拥有者邮箱
     */
    @Column(name = "owner_email")
    private String ownerEmail;

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getDataCode() {
        return dataCode;
    }

    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    @Override
    public Boolean getFrozen() {
        return frozen;
    }

    @Override
    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }
}
