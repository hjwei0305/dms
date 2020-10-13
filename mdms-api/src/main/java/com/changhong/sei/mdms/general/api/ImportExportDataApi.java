package com.changhong.sei.mdms.general.api;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.mdms.management.dto.ProcessResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-10-09 13:08
 */
public interface ImportExportDataApi {

    /**
     * 获取导入导出状态
     *
     * @return 获取导入导出状态
     */
    @GetMapping(path = "imExStatus")
    @ApiOperation(value = "获取导入导出状态", notes = "获取导入导出状态")
    ResultData<List<ProcessResult>> imExStatus();

    /**
     * excel导入模版数据
     *
     * @return 导入模版数据
     */
    @PostMapping(path = "importDataExcel")
    @ApiOperation(value = "导入模版数据", notes = "导入模版数据,前端应用根据数据生成excel模版")
    ResultData<Map<String, List<String>>> importTemplateData();

    /**
     * excel文件数据导入
     *
     * @param file excel文件
     * @return 导入结果
     */
    @PostMapping(path = "importDataExcel", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "excel文件数据导入", notes = "excel文件数据导入")
    ResultData<String> importDataExcel(MultipartFile file);

    /**
     * 数据导出excel文件
     *
     * @param search 导出查询参数
     * @return 导出结果
     */
    @PostMapping(path = "exportData", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "数据导出excel文件", notes = "数据导出excel文件")
    ResultData<String> exportData(@RequestBody Search search);
}
