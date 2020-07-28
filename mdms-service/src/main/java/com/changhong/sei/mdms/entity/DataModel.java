package com.changhong.sei.mdms.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 数据模型(DataModel)实体类
 *
 * @author sei
 * @since 2020-07-28 17:31:36
 */
@Entity
@Table(name = "data_model")
@DynamicInsert
@DynamicUpdate
public class DataModel extends BaseAuditableEntity implements Serializable {
    private static final long serialVersionUID = -42966144790593251L;
    /**
     * 数据源code
     */
    @Column(name = "ds_code")
    private String dsCode;
    /**
     * 表名
     */
    @Column(name = "table_name")
    private String tableName;
    /**
     * 模型分类代码
     */
    @Column(name = "model_type_code")
    private String modelTypeCode;
    /**
     * 模型分类名称
     */
    @Column(name = "model_type_name")
    private String modelTypeName;
    /**
     * 描述说明
     */
    @Column(name = "remark")
    private String remark;
    /**
     * 版本号
     */
    @Column(name = "version_")
    private String version_;


    public String getDsCode() {
        return dsCode;
    }

    public void setDsCode(String dsCode) {
        this.dsCode = dsCode;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getModelTypeCode() {
        return modelTypeCode;
    }

    public void setModelTypeCode(String modelTypeCode) {
        this.modelTypeCode = modelTypeCode;
    }

    public String getModelTypeName() {
        return modelTypeName;
    }

    public void setModelTypeName(String modelTypeName) {
        this.modelTypeName = modelTypeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getVersion_() {
        return version_;
    }

    public void setVersion_(String version_) {
        this.version_ = version_;
    }

}