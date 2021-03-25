package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.dms.commom.Constants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.StringJoiner;

/**
 * 实现功能: 数据字典项目DTO
 *
 * @author 王锦光 wangjg
 * @version 2020-01-26 19:50
 */
@ApiModel(description = "数据字典项目DTO")
public class DataDictItemDto extends BaseEntityDto {
    private static final long serialVersionUID = 6473909758037634659L;
    /**
     * 租户代码
     * 默认租户代码为 global
     */
    @ApiModelProperty(value = "租户代码")
    private String tenantCode = Constants.DEFAULT_TENANT;
    /**
     * 数据字典Id
     */
    @NotBlank
    @Size(max = 36)
    @ApiModelProperty(value = "数据字典Id(max = 36)", required = true)
    private String dataDictId;

    /**
     * 展示值
     */
    @NotBlank
    @Size(max = 100)
    @ApiModelProperty(value = "名称(max = 100)", required = true)
    private String dataName;

    /**
     * 使用值
     */
    @NotBlank
    @Size(max = 100)
    @ApiModelProperty(value = "值(max = 100)", required = true)
    private String dataValue;

    /**
     * 是否冻结
     */
    @NotNull
    @ApiModelProperty(value = "是否冻结", required = true)
    private Boolean frozen = Boolean.FALSE;

    /**
     * 排序值
     */
    @NotNull
    @ApiModelProperty(value = "排序值", required = true)
    private Integer rank = 0;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注(max = 200)")
    private String remark;

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    /**
     * 是否为租户私有
     */
    public Boolean getTenantPrivate() {
        return !Constants.DEFAULT_TENANT.equals(getTenantCode());
    }

    public String getDataDictId() {
        return dataDictId;
    }

    public void setDataDictId(String dataDictId) {
        this.dataDictId = dataDictId;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

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

    @Override
    public String toString() {
        return new StringJoiner(", ", DataDictItemDto.class.getSimpleName() + "[", "]")
                .add("dataName='" + dataName + "'")
                .add("dataValue='" + dataValue + "'")
                .toString();
    }
}
