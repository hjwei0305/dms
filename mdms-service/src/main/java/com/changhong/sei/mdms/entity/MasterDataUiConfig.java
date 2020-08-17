package com.changhong.sei.mdms.entity;

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
 * 主数据UI配置(MasterDataUiConfig)实体类
 *
 * @author sei
 * @since 2020-08-13 22:47:16
 */
@Entity
@Table(name = "master_data_ui_config")
@DynamicInsert
@DynamicUpdate
public class MasterDataUiConfig extends BaseAuditableEntity implements Serializable, ICodeUnique, IFrozen {
    private static final long serialVersionUID = -55502538661881172L;
    public static final String TYPE_CODE = "typeCode";
    /**
     * 代码(表名)
     */
    @Column(name = "code", nullable = false)
    private String code;
    /**
     * 名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 全路径类名
     */
    @Column(name = "full_name", nullable = false)
    private String fullName;
    /**
     * 分类代码
     */
    @Column(name = "type_code", nullable = false)
    private String typeCode;
    /**
     * 分类名称
     */
    @Column(name = "type_name")
    private String typeName;
    /**
     * 冻结
     * 取消注册即冻结
     */
    @Column(name = "frozen")
    private Boolean frozen = Boolean.FALSE;
    /**
     * 描述说明
     */
    @Column(name = "remark")
    private String remark;
    /**
     * UI表格默认排序配置json
     */
    @Column(name = "rank_fields")
    private String rankFields;
    /**
     * UI表格配置json
     */
    @Column(name = "table_data")
    private String tableData;
    /**
     * UI表单配置json
     */
    @Column(name = "form_data")
    private String formData;
    /**
     * 导入导出配置json
     */
    @Column(name = "imp_exp_data")
    private String impExpData;


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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public String getRankFields() {
        return rankFields;
    }

    public void setRankFields(String rankFields) {
        this.rankFields = rankFields;
    }

    public String getTableData() {
        return tableData;
    }

    public void setTableData(String tableData) {
        this.tableData = tableData;
    }

    public String getFormData() {
        return formData;
    }

    public void setFormData(String formData) {
        this.formData = formData;
    }

    public String getImpExpData() {
        return impExpData;
    }

    public void setImpExpData(String impExpData) {
        this.impExpData = impExpData;
    }

}