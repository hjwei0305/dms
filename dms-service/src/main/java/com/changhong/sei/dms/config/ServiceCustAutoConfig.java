package com.changhong.sei.dms.config;

import com.changhong.sei.dms.general.service.excel.CountryExcelService;
import com.changhong.sei.dms.general.service.excel.CurrencyExcelService;
import com.changhong.sei.dms.general.service.excel.impl.DefaultCountryExcelService;
import com.changhong.sei.dms.general.service.excel.impl.DefaultCurrencyExcelService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 实现功能: 自定义业务逻辑扩展配置
 * 导入导出扩展bean注意名字约定 {@see ImportExportDataController.getExcelService()}
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-10-12 00:35
 */
@Configuration
public class ServiceCustAutoConfig {
    /**
     * 国家导入导出扩展实现
     *
     * @return 扩展实现
     */
    @Bean("countryExcelService")
    @ConditionalOnMissingBean(CountryExcelService.class)
    public CountryExcelService countryExcelService() {
        return new DefaultCountryExcelService();
    }

    @Bean("currencyExcelService")
    @ConditionalOnMissingBean(CurrencyExcelService.class)
    public CurrencyExcelService currencyExcelService() {
        return new DefaultCurrencyExcelService();
    }
}
