package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.dms.annotation.MasterData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 利润中心(ProfitCenter)DTO类
 *
 * @author sei
 * @since 2021-07-30 14:59:18
 */
@MasterData(code = "ProfitCenter", name = "利润中心")
@ApiModel(description = "利润中心DTO")
public class ProfitCenterDto extends BaseEntityDto {
    private static final long serialVersionUID = 721378769575337232L;
    /**
     * 代码
     */
    @NotBlank
    @Size(max = 10)
    @ApiModelProperty(value = "代码")
    private String code;
    /**
     * 名称
     */
    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * ERP公司代码
     */
    @NotBlank
    @Size(max = 10)
    @ApiModelProperty(value = "ERP公司代码")
    private String erpCorporationCode;
    /**
     * 利润中心组
     */
    @Size(max = 10)
    @ApiModelProperty(value = "利润中心组")
    private String profitGroup;
    /**
     * 负责人
     */
    @Size(max = 20)
    @ApiModelProperty(value = "负责人")
    private String keyPerson;
    /**
     * 已冻结
     */
    @NotNull
    @ApiModelProperty(value = "已冻结")
    private Boolean frozen = Boolean.FALSE;
    /**
     * 租户代码
     */
    @ApiModelProperty(value = "租户代码")
    private String tenantCode;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getErpCorporationCode() {
        return erpCorporationCode;
    }

    public void setErpCorporationCode(String erpCorporationCode) {
        this.erpCorporationCode = erpCorporationCode;
    }

    public String getProfitGroup() {
        return profitGroup;
    }

    public void setProfitGroup(String profitGroup) {
        this.profitGroup = profitGroup;
    }

    public String getKeyPerson() {
        return keyPerson;
    }

    public void setKeyPerson(String keyPerson) {
        this.keyPerson = keyPerson;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

}