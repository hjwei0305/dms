package com.changhong.sei.mdms.management.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 语义类型
 */
@Access(AccessType.FIELD)
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "lang_semanteme_type")
public class SemantemeType extends BaseAuditableEntity {
    private static final long serialVersionUID = -6950198043462048658L;
    /**
     * 业务实体全类名
     */
    @Column(name = "class_name", length = 100, nullable = false, unique = true)
    private String className;

    /**
     * 属性名
     */
    @Column(name = "property_name", length = 50, nullable = false)
    private String propertyName;

    /**
     * 描述
     */
    @Column(name = "remark", length = 50, nullable = false)
    private String remark;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
