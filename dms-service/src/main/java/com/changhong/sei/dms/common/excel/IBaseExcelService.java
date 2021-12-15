package com.changhong.sei.dms.common.excel;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.dms.commom.dto.ImportExportStatus;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-10-13 16:49
 */
public interface IBaseExcelService {

    /**
     * 获取导入导出状态
     *
     * @return 获取导入导出状态
     */
    ResultData<ImportExportStatus> imExStatus();

    /**
     * 获取excel导入模版数据
     *
     * @return 导入模版数据
     */
    ResultData<Map<String, Object>> importTemplateData();

    /**
     * 异步将excel文件数据导入系统
     *
     * @param file excel文件
     */
    void importDataExcel(MultipartFile file);

    /**
     * 异步将数据导出到excel文件
     *
     * @param search 导出查询参数
     */
    void exportData(Search search);
}
