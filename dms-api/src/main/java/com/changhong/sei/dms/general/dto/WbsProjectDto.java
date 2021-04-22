package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.core.dto.TreeEntity;
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
import java.util.List;

/**
 * WBS项目(WbsProject)DTO类
 *
 * @author sei
 * @since 2021-04-19 17:00:14
 */
@MasterData(code = "WbsProject", name = "WBS项目")
@ApiModel(description = "WBS项目DTO")
public class WbsProjectDto extends BaseEntityDto implements TreeEntity<WbsProjectDto> {
    private static final long serialVersionUID = 994343553751342075L;
    /**
     * 代码
     */
    @NotBlank
    @Size(max = 30)
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
     * 父节点代码
     */
    @Size(max = 30)
    @ApiModelProperty(value = "父节点代码")
    private String parentCode;
    /**
     * 项目类型
     */
    @NotBlank
    @Size(max = 2)
    @ApiModelProperty(value = "项目类型")
    private String projectType;
    /**
     * ERP公司代码
     */
    @NotBlank
    @Size(max = 4)
    @ApiModelProperty(value = "ERP公司代码")
    private String erpCorporationCode;
    /**
     * 层级
     */
    @NotNull
    @ApiModelProperty(value = "层级")
    private Integer nodeLevel;
    /**
     * 成本中心代码
     */
    @Size(max = 10)
    @ApiModelProperty(value = "成本中心代码")
    private String costCenterCode;
    /**
     * 业务范围代码
     */
    @Size(max = 4)
    @ApiModelProperty(value = "业务范围代码")
    private String rangeCode;
    /**
     * ERP创建日期
     */
    @NotNull
    @DateTimeFormat(pattern = DateUtils.DEFAULT_TIME_FORMAT)
    @JsonFormat(pattern = DateUtils.DEFAULT_TIME_FORMAT)
    @ApiModelProperty(value = "ERP创建日期")
    private Date erpCreateDate;
    /**
     * 总账科目代码
     */
    @Size(max = 10)
    @ApiModelProperty(value = "总账科目代码")
    private String ledgerAccountCode;
    /**
     * 总账科目名称
     */
    @Size(max = 200)
    @ApiModelProperty(value = "总账科目名称")
    private String ledgerAccountName;
    /**
     * 已冻结
     */
    @ApiModelProperty(value = "已冻结")
    private Boolean frozen = Boolean.FALSE;
    /**
     * 租户代码
     */
    @ApiModelProperty(value = "租户代码")
    private String tenantCode;

    /**
     * 子节点列表
     */
    @ApiModelProperty(value = "子节点列表")
    private List<WbsProjectDto> children;

    /**
     * 代码路径
     */
    @ApiModelProperty(value = "代码路径")
    private String codePath;
    /**
     * 名称路径
     */
    @ApiModelProperty(value = "名称路径")
    private String namePath;
    /**
     * 父节点id
     */
    @ApiModelProperty(value = "父节点id")
    private String parentId;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer rank = 0;

    @Override
    public String getCode() {
        return code;
    }

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

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getErpCorporationCode() {
        return erpCorporationCode;
    }

    public void setErpCorporationCode(String erpCorporationCode) {
        this.erpCorporationCode = erpCorporationCode;
    }

    @Override
    public Integer getNodeLevel() {
        return nodeLevel;
    }

    @Override
    public void setNodeLevel(Integer nodeLevel) {
        this.nodeLevel = nodeLevel;
    }

    public String getCostCenterCode() {
        return costCenterCode;
    }

    public void setCostCenterCode(String costCenterCode) {
        this.costCenterCode = costCenterCode;
    }

    public String getRangeCode() {
        return rangeCode;
    }

    public void setRangeCode(String rangeCode) {
        this.rangeCode = rangeCode;
    }

    public Date getErpCreateDate() {
        return erpCreateDate;
    }

    public void setErpCreateDate(Date erpCreateDate) {
        this.erpCreateDate = erpCreateDate;
    }

    public String getLedgerAccountCode() {
        return ledgerAccountCode;
    }

    public void setLedgerAccountCode(String ledgerAccountCode) {
        this.ledgerAccountCode = ledgerAccountCode;
    }

    public String getLedgerAccountName() {
        return ledgerAccountName;
    }

    public void setLedgerAccountName(String ledgerAccountName) {
        this.ledgerAccountName = ledgerAccountName;
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

    @Override
    public List<WbsProjectDto> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<WbsProjectDto> children) {
        this.children = children;
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
    public String getParentId() {
        return parentId;
    }

    @Override
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}