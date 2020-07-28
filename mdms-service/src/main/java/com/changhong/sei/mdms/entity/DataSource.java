package com.changhong.sei.mdms.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 数据源(DataSource)实体类
 *
 * @author sei
 * @since 2020-07-28 17:31:44
 */
@Entity
@Table(name = "data_source")
@DynamicInsert
@DynamicUpdate
public class DataSource extends BaseAuditableEntity implements Serializable {
    private static final long serialVersionUID = -55714157101308549L;
    /**
     * 数据库名
     */
    @Column(name = "code")
    private String code;
    /**
     * 描述说明
     */
    @Column(name = "remark")
    private String remark;
    /**
     * 数据库类型
     */
    @Column(name = "db_type")
    private String dbType;
    /**
     * url
     */
    @Column(name = "url")
    private String url;
    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;
    /**
     * 密码
     */
    @Column(name = "password")
    private Object password;
    /**
     * 冻结
     */
    @Column(name = "frozen")
    private Boolean frozen;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

}