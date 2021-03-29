package com.changhong.sei.dms.general.service.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.changhong.sei.dms.common.excel.BaseExcelRow;
import com.changhong.sei.dms.common.excel.validate.NotDuplicate;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 运输方式(TransportationWay)Excel导入导出模版vo
 *
 * @author sei
 * @since 2020-08-17 14:02:39
 */
public class TransportationWayVo extends BaseExcelRow implements Serializable {
    private static final long serialVersionUID = 180242575737929170L;
    /**
     * 代码
     */
    @NotDuplicate
    @NotBlank
    @ExcelProperty(value = "代码", order = 1)
    private String code;
    /**
     * 名称
     */
    @NotBlank
    @ExcelProperty(value = "名称", order = 2)
    private String name;

    /**
     * 冻结
     */
    @ExcelProperty(value = "冻结", order = 3)
    private Boolean frozen = Boolean.FALSE;

    /**
     * 租户代码
     */
    @ExcelProperty(value = "租户代码", order = 4)
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