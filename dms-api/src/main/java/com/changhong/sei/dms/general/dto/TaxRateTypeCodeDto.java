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
     * 说明
     */
    @ApiModelProperty(value = "说明")
    private String remark;
    /**
     * 增值税税率
     */
    @ApiModelProperty(value = "增值税税率")
    private String taxRate;
    /**
     * 关键字
     */
    @ApiModelProperty(value = "关键字")
    private String keyWord;
    /**
     * 汇总项
     */
    @ApiModelProperty(value = "汇总项")
    private String summaryItem;
    /**
     * 是否可用
     */
    @ApiModelProperty(value = "是否可用")
    private Boolean frozen;
    /**
     * 增值税特殊管理
     */
    @ApiModelProperty(value = "增值税特殊管理")
    private String valueTaxSpecialManage;
    /**
     * 增值税政策依据
     */
    @ApiModelProperty(value = "增值税政策依据")
    private String valueTaxDependencePolicy;
    /**
     * 增值税特殊管理代码
     */
    @ApiModelProperty(value = "增值税特殊管理代码")
    private String valueTaxSpecialManageCode;
    /**
     * 消费税特殊管理
     */
    @ApiModelProperty(value = "消费税特殊管理")
    private String saleTaxSpecialManage;
    /**
     * 消费税政策依据
     */
    @ApiModelProperty(value = "消费税政策依据")
    private String saleTaxDependencePolicy;
    /**
     * 消费税特殊管理代码
     */
    @ApiModelProperty(value = "消费税特殊管理代码")
    private String saleTaxSpecialManageCode;
    /**
     * 统计编码
     */
    @ApiModelProperty(value = "统计编码")
    private String statisticsCode;
    /**
     * 海关品目
     */
    @ApiModelProperty(value = "海关品目")
    private String customsGood;
    /**
     * 商品编码的上级节点
     */
    @ApiModelProperty(value = "商品编码的上级节点")
    private String pid;
    /**
     * 版本
     */
    @ApiModelProperty(value = "版本")
    private String version;
    /**
     * 启用时间
     */
    @ApiModelProperty(value = "启用时间")
    private String starDay;
    /**
     * 过渡期截止时间
     */
    @ApiModelProperty(value = "过渡期截止时间")
    private String endDay;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private String updateTime;
    /**
     * 租户代码
     */
    @ApiModelProperty(value = "租户代码")
    private String tenantCode;


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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getSummaryItem() {
        return summaryItem;
    }

    public void setSummaryItem(String summaryItem) {
        this.summaryItem = summaryItem;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    public String getValueTaxSpecialManage() {
        return valueTaxSpecialManage;
    }

    public void setValueTaxSpecialManage(String valueTaxSpecialManage) {
        this.valueTaxSpecialManage = valueTaxSpecialManage;
    }

    public String getValueTaxDependencePolicy() {
        return valueTaxDependencePolicy;
    }

    public void setValueTaxDependencePolicy(String valueTaxDependencePolicy) {
        this.valueTaxDependencePolicy = valueTaxDependencePolicy;
    }

    public String getValueTaxSpecialManageCode() {
        return valueTaxSpecialManageCode;
    }

    public void setValueTaxSpecialManageCode(String valueTaxSpecialManageCode) {
        this.valueTaxSpecialManageCode = valueTaxSpecialManageCode;
    }

    public String getSaleTaxSpecialManage() {
        return saleTaxSpecialManage;
    }

    public void setSaleTaxSpecialManage(String saleTaxSpecialManage) {
        this.saleTaxSpecialManage = saleTaxSpecialManage;
    }

    public String getSaleTaxDependencePolicy() {
        return saleTaxDependencePolicy;
    }

    public void setSaleTaxDependencePolicy(String saleTaxDependencePolicy) {
        this.saleTaxDependencePolicy = saleTaxDependencePolicy;
    }

    public String getSaleTaxSpecialManageCode() {
        return saleTaxSpecialManageCode;
    }

    public void setSaleTaxSpecialManageCode(String saleTaxSpecialManageCode) {
        this.saleTaxSpecialManageCode = saleTaxSpecialManageCode;
    }

    public String getStatisticsCode() {
        return statisticsCode;
    }

    public void setStatisticsCode(String statisticsCode) {
        this.statisticsCode = statisticsCode;
    }

    public String getCustomsGood() {
        return customsGood;
    }

    public void setCustomsGood(String customsGood) {
        this.customsGood = customsGood;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStarDay() {
        return starDay;
    }

    public void setStarDay(String starDay) {
        this.starDay = starDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

}