package com.changhong.sei.dms.general.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.ICodeUnique;
import com.changhong.sei.core.entity.IFrozen;
import com.changhong.sei.core.entity.ITenant;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.AccessType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 实现功能：运输方式
 * <p>
 * Created by XuBiao on 2018/1/8.
 *
 * @version 1.0.00
 */
@Entity
@Table(name = "transportation_way")
@DynamicInsert
@DynamicUpdate
@AccessType(AccessType.Type.FIELD)
public class TransportationWay extends BaseAuditableEntity implements ICodeUnique, ITenant, IFrozen {
    private static final long serialVersionUID = 5184043802129831810L;
    /**
     * 代码
     */
    @Column(name = "code", length = 20, unique = true, nullable = false)
    private String code;
    /**
     * 名称
     */
    @Column(name = "name", length = 100, nullable = false)
    private String name;
    /**
     * 是否冻结
     */
    @Column(name = "frozen", nullable = false)
    private Boolean frozen = Boolean.FALSE;
    /**
     * 租户代码
     */
    @Column(name = "tenant_code", length = 20, nullable = false)
    private String tenantCode;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getTenantCode() {
        return tenantCode;
    }

    @Override
    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    @Override
    public Boolean getFrozen() {
        return frozen;
    }
}
