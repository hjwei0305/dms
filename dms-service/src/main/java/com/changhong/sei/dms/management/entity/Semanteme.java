package com.changhong.sei.dms.management.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 语义表
 */
@Access(AccessType.FIELD)
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "lang_semanteme")
public class Semanteme extends BaseAuditableEntity {
    private static final long serialVersionUID = -1070216856911959539L;
    /**
     * 语义类型Id
     */
    @Column(name = "semanteme_type_id", length = 36, nullable = false)
    private String semantemeTypeId;

    /**
     * 语义类型
     */
    @ManyToOne
    @JoinColumn(name = "semanteme_type_id", nullable = false, insertable = false, updatable = false)
    private SemantemeType semantemeType;

    /**
     * 属性值
     */
    @Column(name = "property_value", length = 300, nullable = false)
    private String propertyValue;

    public String getSemantemeTypeId() {
        return semantemeTypeId;
    }

    public void setSemantemeTypeId(String semantemeTypeId) {
        this.semantemeTypeId = semantemeTypeId;
    }

    public SemantemeType getSemantemeType() {
        return semantemeType;
    }

    public void setSemantemeType(SemantemeType semantemeType) {
        this.semantemeType = semantemeType;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }
}
