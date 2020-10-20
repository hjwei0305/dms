package com.changhong.sei.mdms.commom.api;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.mdms.commom.dto.ProcessResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@SuppressWarnings("rawtypes")
public interface ImportExportDataApi {

    /**
     * 获取导入导出状态
     *
     * @return 获取导入导出状态
     */
    @GetMapping(path = "{serviceName}/imExStatus")
    @ApiOperation(value = "获取导入导出状态", notes = "获取导入导出状态")
    ResultData<Map<String, ProcessResult>> imExStatus(@PathVariable("serviceName") String serviceName);

    /**
     * excel导入模版数据
     *
     * @return 导入模版数据
     */
    @GetMapping(path = "{serviceName}/importTemplateData")
    @ApiOperation(value = "导入模版数据", notes = "导入模版数据,前端应用根据数据生成excel模版")
    ResultData<Map<String, Object>> importTemplateData(@PathVariable("serviceName") String serviceName);

    /**
     * excel文件数据导入
     *
     * @param file excel文件
     * @return 导入结果
     */
    @PostMapping(path = "{serviceName}/importDataExcel")
    @ApiOperation(value = "excel文件数据导入", notes = "excel文件数据导入")
    ResultData<Map<String, ProcessResult>> importDataExcel(@PathVariable("serviceName") String serviceName, MultipartFile file);

    /**
     * 数据导出excel文件
     *
     * @param search 导出查询参数
     * @return 导出结果
     */
    @PostMapping(path = "{serviceName}/exportData", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "数据导出excel文件", notes = "数据导出excel文件")
    ResultData<Map<String, ProcessResult>> exportData(@PathVariable("serviceName") String serviceName, @RequestBody Search search);
}
