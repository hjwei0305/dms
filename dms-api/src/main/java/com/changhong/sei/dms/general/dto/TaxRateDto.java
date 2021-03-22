package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.dms.annotation.MasterData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

/**
 * @Author: 刘松林
 * @Contact: songlin.liu@changhong.com
 * @Date: 2020/3/12 15:50
 * @Description: 税率DTO
 */
@MasterData(value = "TaxRate")
@ApiModel("税率DTO")
public class TaxRateDto extends BaseEntityDto {

    private static final long serialVersionUID = -1921601364683613579L;
    /**
     * 代码
     */
    @NotBlank
    @Size(max = 20)
    @ApiModelProperty(value = "代码", required = true)
    private String code;

    /**
     * 名称
     */
    @NotBlank
    @Size(max = 100)
    @ApiModelProperty(value = "名称", required = true)
    private String name;

    /**
     * 税率百分比
     */
    @NotNull
    @Min(0)
    @Max(100)
    @ApiModelProperty(value = "税率百分比", required = true)
    private Double taxRate;

    /**
     * 冻结标识
     */
    @NotNull
    @ApiModelProperty("冻结标识")
    private Boolean frozen = Boolean.FALSE;

    /**
     * 租户代码
     */
    @ApiModelProperty("租户代码")
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

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
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
