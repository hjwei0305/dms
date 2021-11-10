package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 税收分类编码(TaxRateTypeCode)DTO类
 *
 * @author sei
 * @since 2021-11-10 14:19:31
 */
@ApiModel(description = "税收分类编码DTO")
public class TaxRateTypeCodeDto extends BaseEntityDto {
    private static final long serialVersionUID = 790466346294500206L;
    /**
     * 商品编码
     */
    @ApiModelProperty(value = "商品编码")
    private String goodNum;
    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String goodName;
    /**
     * 商品简称
     */
    @ApiModelProperty(value = "商品简称")
    private String goodBriefName;
    /**
     * 增值税税率
     */
    @ApiModelProperty(value = "增值税税率")
    private String taxRate;
    /**
     * 是否可用
     */
    @ApiModelProperty(value = "是否可用")
    private Boolean frozen;
    /**
     * 商品编码的上级节点
     */
    @ApiModelProperty(value = "商品编码的上级节点")
    private String pid;

    public String getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(String goodNum) {
        this.goodNum = goodNum;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodBriefName() {
        return goodBriefName;
    }

    public void setGoodBriefName(String goodBriefName) {
        this.goodBriefName = goodBriefName;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}