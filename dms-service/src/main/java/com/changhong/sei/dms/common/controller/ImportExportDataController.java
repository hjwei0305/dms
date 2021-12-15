package com.changhong.sei.dms.common.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.dms.commom.api.ImportExportDataApi;
import com.changhong.sei.dms.commom.dto.ImportExportStatus;
import com.changhong.sei.dms.common.excel.ExcelDataBuilder;
import com.changhong.sei.dms.common.excel.IBaseExcelService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-10-13 16:38
 */
@Controller
@Api(value = "ImportExportDataApi", tags = "Excel导入导出服务")
@RequestMapping(path = "excel", produces = MediaType.APPLICATION_JSON_VALUE)
public class ImportExportDataController implements ImportExportDataApi {
    private static final Logger LOG = LoggerFactory.getLogger(ImportExportDataController.class);
    @Autowired
    private ExcelDataBuilder excelDataBuilder;

    private IBaseExcelService getExcelService(String serviceName) {
        // 约定按bean的名字查找服务
        return excelDataBuilder.getExcelDataService(serviceName + "ExcelService");
    }

    /**
     * 获取导入导出状态
     *
     * @return 获取导入导出状态
     */
    @Override
    @ResponseBody
    public ResultData<ImportExportStatus> imExStatus(String serviceName) {
        IBaseExcelService excelService;
        try {
            excelService = getExcelService(serviceName);
        } catch (Exception e) {
            LOG.warn(e.getMessage());
            return ResultData.success(new ImportExportStatus(Boolean.FALSE));
        }
        return excelService.imExStatus();
    }

    /**
     * excel导入模版数据
     *
     * @return 导入模版数据
     */
    @Override
    @ResponseBody
    public ResultData<Map<String, Object>> importTemplateData(String serviceName) {
        return getExcelService(serviceName).importTemplateData();
    }

    /**
     * excel文件数据导入
     *
     * @param file excel文件
     * @return 导入结果
     */
    @Override
    @ResponseBody
    public ResultData<ImportExportStatus> importDataExcel(String serviceName, MultipartFile file) {
        // 提交异步处理
        getExcelService(serviceName).importDataExcel(file);

        // 异步处理,处理状态可能不能立即返回,故延迟2秒返回状态
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return imExStatus(serviceName);
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    @ResponseBody
    public ResultData<ImportExportStatus> exportData(String serviceName, Search search) {
        // 提交异步处理
        getExcelService(serviceName).exportData(search);

        // 异步处理,处理状态可能不能立即返回,故延迟2秒返回状态
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return imExStatus(serviceName);
    }
}
