package com.changhong.sei.mdms.management.entity;

import com.changhong.sei.core.dto.IRank;
import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.ICodeUnique;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 语言类型
 */
@Access(AccessType.FIELD)
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "lang_type")
public class Language extends BaseAuditableEntity implements ICodeUnique, IRank {
    private static final long serialVersionUID = -4725894672976311016L;
    /**
     * 代码
     */
    @Column(name = "code", length = 10, nullable = false, unique = true)
    private String code;

    /**
     * 名称
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    /**
     * 基础语言码
     */
    @Column(name = "base_code", length = 10, nullable = false)
    private String baseCode;

    /**
     * 排序号
     */
    @Column(name = "rank", nullable = false)
    private Integer rank = 0;

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

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    @Override
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
