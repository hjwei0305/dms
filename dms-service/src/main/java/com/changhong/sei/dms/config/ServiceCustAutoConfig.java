package com.changhong.sei.dms.config;

import com.changhong.sei.dms.general.service.*;
import com.changhong.sei.dms.general.service.excel.*;
import com.changhong.sei.dms.general.service.excel.impl.*;
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
    public CountryExcelService countryExcelService(CountryService service) {
        return new DefaultCountryExcelService(service);
    }

    @Bean("currencyExcelService")
    @ConditionalOnMissingBean(CurrencyExcelService.class)
    public CurrencyExcelService currencyExcelService(CurrencyService service) {
        return new DefaultCurrencyExcelService(service);
    }

    @Bean("regionExcelService")
    @ConditionalOnMissingBean(RegionExcelService.class)
    public RegionExcelService regionExcelService(RegionService service) {
        return new DefaultRegionExcelService(service);
    }

    @Bean("unitExcelService")
    @ConditionalOnMissingBean(UnitExcelService.class)
    public UnitExcelService unitExcelService(UnitService service) {
        return new DefaultUnitExcelService(service);
    }

    @Bean("transportationWayExcelService")
    @ConditionalOnMissingBean(TransportationWayExcelService.class)
    public TransportationWayExcelService transportationWayExcelService(TransportationWayService service) {
        return new DefaultTransportationWayExcelService(service);
    }

    @Bean("taxRateExcelService")
    @ConditionalOnMissingBean(TaxRateExcelService.class)
    public TaxRateExcelService taxRateExcelService(TaxRateService service) {
        return new DefaultTaxRateExcelService(service);
    }

    @Bean("cashFlowCodeExcelService")
    @ConditionalOnMissingBean(CashFlowCodeExcelService.class)
    public CashFlowCodeExcelService cashFlowCodeExcelService(CashFlowCodeService service) {
        return new DefaultCashFlowCodeExcelService(service);
    }

    @Bean("costCenterExcelService")
    @ConditionalOnMissingBean(CostCenterExcelService.class)
    public CostCenterExcelService costCenterExcelService(CostCenterService service) {
        return new DefaultCostCenterExcelService(service);
    }
}
