package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.dms.annotation.MasterData;
import com.changhong.sei.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 汇率(ExchangeRate)DTO类
 *
 * @author sei
 * @since 2021-05-06 17:04:28
 */
@MasterData(code = "ExchangeRate", name = "汇率")
@ApiModel(description = "汇率DTO")
public class ExchangeRateDto extends BaseEntityDto {
    private static final long serialVersionUID = 779244127018191377L;
    /**
     * 代码
     */
    @ApiModelProperty(value = "代码（自生成）")
    private String code;
    /**
     * 汇率类型
     */
    @NotBlank
    @Size(max = 4)
    @ApiModelProperty(value = "汇率类型")
    private String rateType;
    /**
     * 生效起始日期
     */
    @NotNull
    @ApiModelProperty(value = "生效起始日期")
    @DateTimeFormat(pattern = DateUtils.DEFAULT_DATE_FORMAT)
    @JsonFormat(pattern = DateUtils.DEFAULT_DATE_FORMAT)
    private Date startDate;
    /**
     * 货币（从）
     */
    @NotBlank
    @Size(max = 5)
    @ApiModelProperty(value = "货币（从）")
    private String fromCurrency;
    /**
     * 货币（到）
     */
    @NotBlank
    @Size(max = 5)
    @ApiModelProperty(value = "货币（到）")
    private String toCurrency;
    /**
     * 比率（从）
     */
    @NotNull
    @ApiModelProperty(value = "比率（从）")
    private Integer fromUnit;
    /**
     * 比率（到）
     */
    @NotNull
    @ApiModelProperty(value = "比率（到）")
    private Integer toUnit;
    /**
     * 汇率
     */
    @NotNull
    @ApiModelProperty(value = "汇率")
    private Double rate;
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

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public Integer getFromUnit() {
        return fromUnit;
    }

    public void setFromUnit(Integer fromUnit) {
        this.fromUnit = fromUnit;
    }

    public Integer getToUnit() {
        return toUnit;
    }

    public void setToUnit(Integer toUnit) {
        this.toUnit = toUnit;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

}