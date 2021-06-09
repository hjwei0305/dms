package com.changhong.sei.dms.general.dto.search;

import com.changhong.sei.core.dto.serach.QuickQueryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 实现功能: 客户主数据快速查询参数
 *
 * @author 王锦光 wangjg
 * @version 2021-06-09 14:06
 */
@ApiModel("客户主数据快速查询参数")
public class CustomerQuickSearchParam extends QuickQueryParam {
    private static final long serialVersionUID = 703364187619287975L;
    /**
     * ERP公司代码
     */
    @NotBlank
    @Size(max = 10)
    @ApiModelProperty(value = "ERP公司代码", required = true)
    private String erpCode;

    public String getErpCode() {
        return erpCode;
    }

    public void setErpCode(String erpCode) {
        this.erpCode = erpCode;
    }
}
