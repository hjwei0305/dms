package com.changhong.sei.dms.commom.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2021-12-15 13:30
 */
@ApiModel(description = "导入导出状态DTO")
public class ImportExportStatus {

    @ApiModelProperty(value = "是否启用导入导出服务")
    private Boolean enable = Boolean.FALSE;
    @ApiModelProperty(value = "导入结果")
    private ProcessResult<?> importResult;
    @ApiModelProperty(value = "导出结果")
    private ProcessResult<?> exportResult;

    public ImportExportStatus() {
    }

    public ImportExportStatus(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public ProcessResult<?> getImportResult() {
        return importResult;
    }

    public void setImportResult(ProcessResult<?> importResult) {
        this.importResult = importResult;
    }

    public ProcessResult<?> getExportResult() {
        return exportResult;
    }

    public void setExportResult(ProcessResult<?> exportResult) {
        this.exportResult = exportResult;
    }
}
