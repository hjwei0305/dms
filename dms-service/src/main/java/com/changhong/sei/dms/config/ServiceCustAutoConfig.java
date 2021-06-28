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

    /**
     * 现金流代码导入导出扩展实现
     *
     * @return 扩展实现
     */
    @Bean("cashFlowCodeExcelService")
    @ConditionalOnMissingBean(CashFlowCodeExcelService.class)
    public CashFlowCodeExcelService cashFlowCodeExcelService(CashFlowCodeService service) {
        return new DefaultCashFlowCodeExcelService(service);
    }

    /**
     * 成本中心导入导出扩展实现
     *
     * @return 扩展实现
     */
    @Bean("costCenterExcelService")
    @ConditionalOnMissingBean(CostCenterExcelService.class)
    public CostCenterExcelService costCenterExcelService(CostCenterService service) {
        return new DefaultCostCenterExcelService(service);
    }

    /**
     * 内部订单导入导出扩展实现
     *
     * @return 扩展实现
     */
    @Bean("innerOrderExcelService")
    @ConditionalOnMissingBean(InnerOrderExcelService.class)
    public InnerOrderExcelService innerOrderExcelService(InnerOrderService service) {
        return new DefaultInnerOrderExcelService(service);
    }

    /**
     * 总账科目导入导出扩展实现
     *
     * @return 扩展实现
     */
    @Bean("ledgerAccountExcelService")
    @ConditionalOnMissingBean(LedgerAccountExcelService.class)
    public LedgerAccountExcelService innerOrderExcelService(LedgerAccountService service) {
        return new DefaultLedgerAccountExcelService(service);
    }

    /**
     * 企业员工导入导出扩展实现
     *
     * @return 扩展实现
     */
    @Bean("personnelExcelService")
    @ConditionalOnMissingBean(PersonnelExcelService.class)
    public PersonnelExcelService personnelExcelService(PersonnelService service) {
        return new DefaultPersonnelExcelService(service);
    }

    /**
     * HR组织机构导入导出扩展实现
     *
     * @return 扩展实现
     */
    @Bean("hrOrganizationExcelService")
    @ConditionalOnMissingBean(HrOrganizationExcelService.class)
    public HrOrganizationExcelService hrOrganizationExcelService(HrOrganizationService service) {
        return new DefaultHrOrganizationExcelService(service);
    }

    /**
     * WBS项目导入导出扩展实现
     *
     * @return 扩展实现
     */
    @Bean("wbsProjectExcelService")
    @ConditionalOnMissingBean(WbsProjectExcelService.class)
    public WbsProjectExcelService wbsProjectExcelService(WbsProjectService service) {
        return new DefaultWbsProjectExcelService(service);
    }

    /**
     * 备用金员工导入导出扩展实现
     *
     * @return 扩展实现
     */
    @Bean("imprestEmployeeExcelService")
    @ConditionalOnMissingBean(ImprestEmployeeExcelService.class)
    public ImprestEmployeeExcelService imprestEmployeeExcelService(ImprestEmployeeService service) {
        return new DefaultImprestEmployeeExcelService(service);
    }

    /**
     * 客户导入导出扩展实现
     *
     * @return 扩展实现
     */
    @Bean("customerExcelService")
    @ConditionalOnMissingBean(CustomerExcelService.class)
    public CustomerExcelService customerExcelService(CustomerService service) {
        return new DefaultCustomerExcelService(service);
    }

    /**
     * 供应商导入导出扩展实现
     *
     * @return 扩展实现
     */
    @Bean("supplierExcelService")
    @ConditionalOnMissingBean(SupplierExcelService.class)
    public SupplierExcelService supplierExcelService(SupplierService service) {
        return new DefaultSupplierExcelService(service);
    }

    /**
     * 汇率导入导出扩展实现
     *
     * @return 扩展实现
     */
    @Bean("exchangeRateExcelService")
    @ConditionalOnMissingBean(ExchangeRateExcelService.class)
    public ExchangeRateExcelService exchangeRateExcelService(ExchangeRateService service) {
        return new DefaultExchangeRateExcelService(service);
    }

    /**
     * 银行类别导入导出扩展实现
     *
     * @return 扩展实现
     */
    @Bean("bankCategoryExcelService")
    @ConditionalOnMissingBean(BankCategoryExcelService.class)
    public BankCategoryExcelService bankCategoryExcelService(BankCategoryService service) {
        return new DefaultBankCategoryExcelService(service);
    }

    /**
     * 税分类导入导出扩展实现
     *
     * @return 扩展实现
     */
    @Bean("taxTypeExcelService")
    @ConditionalOnMissingBean(TaxTypeExcelService.class)
    public TaxTypeExcelService taxTypeExcelService(TaxTypeService service) {
        return new DefaultTaxTypeExcelService(service);
    }
}
