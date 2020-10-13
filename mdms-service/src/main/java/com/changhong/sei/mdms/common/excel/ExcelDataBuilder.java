package com.changhong.sei.mdms.common.excel;

import com.changhong.sei.exception.ServiceException;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-10-13 16:57
 */
@Component
public class ExcelDataBuilder {

    /**
     * IBaseExcelService缓存
     */
    private final Map<String, IBaseExcelService> granterPool = new ConcurrentHashMap<>();

    public ExcelDataBuilder(Map<String, IBaseExcelService> granterPool) {
        granterPool.forEach(this.granterPool::put);
    }

    /**
     * 获取IBaseExcelService
     *
     * @param serviceName 服务名
     * @return TokenAuthenticator
     */
    public IBaseExcelService getExcelDataService(String serviceName) {
        IBaseExcelService excelService = granterPool.get(serviceName);
        if (Objects.isNull(excelService)) {
            throw new ServiceException(serviceName + "导入导出服务不存在.");
        } else {
            return excelService;
        }
    }
}
