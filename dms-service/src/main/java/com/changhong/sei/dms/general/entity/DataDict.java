package com.changhong.sei.dms.general.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.ICodeUnique;
import com.changhong.sei.core.entity.IFrozen;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 实现功能：数据字典
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "data_dict")
@DynamicUpdate
@DynamicInsert
public class DataDict extends BaseAuditableEntity implements ICodeUnique, IFrozen {
    private static final long serialVersionUID = 7665641870616737740L;
    /**
     * 代码
     */
    @Column(name = "code", unique = true, length = 50, nullable = false)
    private String code;
    /**
     * 名称
     */
    @Column(name = "name", length = 100, nullable = false)
    private String name;
    /**
     * 是否冻结
     */
    @Column(name = "frozen")
    private Boolean frozen = Boolean.FALSE;
    /**
     * 备注
     */
    @Column(name = "remark", length = 100)
    private String remark;

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
}
