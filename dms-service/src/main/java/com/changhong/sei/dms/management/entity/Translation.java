package com.changhong.sei.dms.management.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 实现功能：译文表
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "lang_translation")
@DynamicUpdate
@DynamicInsert
public class Translation extends BaseAuditableEntity {
    private static final long serialVersionUID = -8660906165097002506L;
    /**
     * 语言类型Id
     */
    @Column(name = "language_id", length = 36, nullable = false)
    private String languageId;

    /**
     * 语言类型
     */
    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false, insertable = false, updatable = false)
    private Language language;

    /**
     * 语义Id
     */
    @Column(name = "semanteme_id", length = 36, nullable = false)
    private String semantemeId;

    /**
     * 语义
     */
    @ManyToOne
    @JoinColumn(name = "semanteme_id", nullable = false, insertable = false, updatable = false)
    private Semanteme semanteme;

    /**
     * 翻译值
     */
    @Column(name = "trans_value", length = 900, nullable = false)
    private String transValue;

    public String getLanguageId() {
        return languageId;
    }

    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getSemantemeId() {
        return semantemeId;
    }

    public void setSemantemeId(String semantemeId) {
        this.semantemeId = semantemeId;
    }

    public Semanteme getSemanteme() {
        return semanteme;
    }

    public void setSemanteme(Semanteme semanteme) {
        this.semanteme = semanteme;
    }

    public String getTransValue() {
        return transValue;
    }

    public void setTransValue(String transValue) {
        this.transValue = transValue;
    }
}
