package com.changhong.sei.mdms.management.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.mdms.management.dto.ConfigTypeEnum;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 主数据UI配置(MasterDataUiConfig)实体类
 *
 * @author sei
 * @since 2020-08-13 22:47:16
 */
@Entity
@Table(name = "_data_config")
@DynamicInsert
@DynamicUpdate
public class DataConfig extends BaseAuditableEntity implements Serializable {
    private static final long serialVersionUID = -55502538661881172L;
    public static final String TYPE_CODE = "typeCode";
    /**
     * 数据定义Id
     */
    @Column(name = "data_definition_id", nullable = false)
    private String dataDefinitionId;
    /**
     * 配置类型枚举
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "config_type", nullable = false)
    private ConfigTypeEnum configType;
    /**
     * json格式配置数据
     */
    @Column(name = "config_data", nullable = false)
    private String configData;

    public String getDataDefinitionId() {
        return dataDefinitionId;
    }

    public void setDataDefinitionId(String dataDefinitionId) {
        this.dataDefinitionId = dataDefinitionId;
    }

    public ConfigTypeEnum getConfigType() {
        return configType;
    }

    public void setConfigType(ConfigTypeEnum configType) {
        this.configType = configType;
    }

    public String getConfigData() {
        return configData;
    }

    public void setConfigData(String configData) {
        this.configData = configData;
    }
}