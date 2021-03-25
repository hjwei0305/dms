package com.changhong.sei.dms.general.entity;

import com.changhong.sei.core.dto.IRank;
import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.IFrozen;
import com.changhong.sei.core.entity.ITenant;
import com.changhong.sei.dms.commom.Constants;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 实现功能：数据字典项
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "data_dict_item")
@DynamicUpdate
@DynamicInsert
public class DataDictItem extends BaseAuditableEntity implements ITenant, IFrozen, IRank {
    private static final long serialVersionUID = -2013360193839296084L;
    /**
     * 租户代码
     * 默认租户代码为 global
     */
    @Column(name = "tenant_code", nullable = false)
    private String tenantCode = Constants.DEFAULT_TENANT;
    /**
     * 数据字典Id
     */
    @Column(name = "data_dict_id", length = 36, nullable = false)
    private String dataDictId;

    /**
     * 展示值
     */
    @Column(name = "data_name", length = 100, nullable = false)
    private String dataName;

    /**
     * 使用值
     */
    @Column(name = "data_value", length = 100, nullable = false)
    private String dataValue;

    /**
     * 是否冻结
     */
    @Column(name = "frozen", nullable = false)
    private Boolean frozen = Boolean.FALSE;

    /**
     * 排序值
     */
    @Column(name = "rank", nullable = false)
    private Integer rank = 0;

    /**
     * 备注
     */
    @Column(name = "remark", length = 200)
    private String remark;

    @Override
    public String getTenantCode() {
        return tenantCode;
    }

    @Override
    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public String getDataDictId() {
        return dataDictId;
    }

    public void setDataDictId(String dataDictId) {
        this.dataDictId = dataDictId;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
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
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
