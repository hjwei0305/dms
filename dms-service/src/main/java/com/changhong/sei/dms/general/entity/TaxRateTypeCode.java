package com.changhong.sei.dms.general.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 税收分类编码(TaxRateTypeCode)实体类
 *
 * @author sei
 * @since 2021-11-10 14:19:29
 */
@Entity
@Table(name = "tax_rate_type_code")
@DynamicInsert
@DynamicUpdate
public class TaxRateTypeCode extends BaseAuditableEntity implements Serializable {
    private static final long serialVersionUID = 674849071888386444L;
    /**
     * 商品编码
     */
    @Column(name = "good_num")
    private String goodNum;
    /**
     * 商品名称
     */
    @Column(name = "good_name")
    private String goodName;
    /**
     * 商品简称
     */
    @Column(name = "good_brief_name")
    private String goodBriefName;
    /**
     * 说明
     */
    @Column(name = "remark")
    private String remark;
    /**
     * 增值税税率
     */
    @Column(name = "tax_rate")
    private String taxRate;
    /**
     * 关键字
     */
    @Column(name = "key_word")
    private String keyWord;
    /**
     * 汇总项
     */
    @Column(name = "summary_item")
    private String summaryItem;
    /**
     * 是否可用
     */
    @Column(name = "frozen")
    private Boolean frozen;
    /**
     * 增值税特殊管理
     */
    @Column(name = "value_tax_special_manage")
    private String valueTaxSpecialManage;
    /**
     * 增值税政策依据
     */
    @Column(name = "value_tax_dependence_policy")
    private String valueTaxDependencePolicy;
    /**
     * 增值税特殊管理代码
     */
    @Column(name = "value_tax_special_manage_code")
    private String valueTaxSpecialManageCode;
    /**
     * 消费税特殊管理
     */
    @Column(name = "sale_tax_special_manage")
    private String saleTaxSpecialManage;
    /**
     * 消费税政策依据
     */
    @Column(name = "sale_tax_dependence_policy")
    private String saleTaxDependencePolicy;
    /**
     * 消费税特殊管理代码
     */
    @Column(name = "sale_tax_special_manage_code")
    private String saleTaxSpecialManageCode;
    /**
     * 统计编码
     */
    @Column(name = "statistics_code")
    private String statisticsCode;
    /**
     * 海关品目
     */
    @Column(name = "customs_good")
    private String customsGood;
    /**
     * 商品编码的上级节点
     */
    @Column(name = "pid")
    private String pid;
    /**
     * 版本
     */
    @Column(name = "version")
    private String version;
    /**
     * 启用时间
     */
    @Column(name = "star_day")
    private String starDay;
    /**
     * 过渡期截止时间
     */
    @Column(name = "end_day")
    private String endDay;
    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private String updateTime;
    /**
     * 租户代码
     */
    @Column(name = "tenant_code")
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