package com.changhong.sei.mdms.management.entity;

import com.changhong.sei.core.dto.IRank;
import com.changhong.sei.core.dto.TreeEntity;
import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.ICodeUnique;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * 主数据分类(MasterDataType)实体类
 *
 * @author sei
 * @since 2020-08-13 22:47:05
 */
@Entity
@Table(name = "_data_category")
@DynamicInsert
@DynamicUpdate
public class DataCategory extends BaseAuditableEntity implements Serializable, TreeEntity<DataCategory>, ICodeUnique, IRank {
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
     * 父节点Id
     */
    @Column(name = "parent_id")
    private String parentId;
    /**
     * 层级
     */
    @Column(name = "node_level")
    private Integer nodeLevel;
    /**
     * 代码路径
     */
    @Column(name = "code_path")
    private String codePath;
    /**
     * 名称路径
     */
    @Column(name = "name_path")
    private String namePath;
    /**
     * 排序
     */
    @Column(name = "rank")
    private Integer rank;
    /**
     * 描述说明
     */
    @Column(name = "remark")
    private String remark;
    /**
     * 冻结
     */
    @Column(name = "frozen")
    private Boolean frozen;

    @Transient
    private List<DataCategory> children;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getParentId() {
        return parentId;
    }

    @Override
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public Integer getNodeLevel() {
        return nodeLevel;
    }

    @Override
    public void setNodeLevel(Integer nodeLevel) {
        this.nodeLevel = nodeLevel;
    }

    @Override
    public String getCodePath() {
        return codePath;
    }

    @Override
    public void setCodePath(String codePath) {
        this.codePath = codePath;
    }

    @Override
    public String getNamePath() {
        return namePath;
    }

    @Override
    public void setNamePath(String namePath) {
        this.namePath = namePath;
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

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    @Override
    public List<DataCategory> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<DataCategory> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return namePath;
    }
}