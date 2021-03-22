package com.changhong.sei.mdms.management.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.ICodeUnique;
import com.changhong.sei.core.entity.IFrozen;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 应用服务(App)实体类
 *
 * @author sei
 * @since 2020-08-13 22:47:05
 */
@Entity
@Table(name = "_app_service")
@DynamicInsert
@DynamicUpdate
public class App extends BaseAuditableEntity implements Serializable, ICodeUnique, IFrozen {
    private static final long serialVersionUID = -76211558295839968L;
    /**
     * 标识符(UUID)
     */
    @Column(name = "code")
    private String code;
    /**
     * 名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 密钥
     */
    @Column(name = "secret")
    private String secret;
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
    /**
     * 冻结
     */
    @Column(name = "frozen_")
    private Boolean frozen;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
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

    @Override
    public Boolean getFrozen() {
        return frozen;
    }

    @Override
    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }
}