package com.changhong.sei.dms.general.service.excel.impl;

import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.dms.common.excel.BaseExcelService;
import com.changhong.sei.dms.general.entity.Currency;
import com.changhong.sei.dms.general.service.CurrencyService;
import com.changhong.sei.dms.general.service.excel.CurrencyExcelService;
import com.changhong.sei.dms.general.service.excel.vo.CurrencyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 实现功能：币种导入导出服务
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-10-12 00:35
 */
public class DefaultCurrencyExcelService extends BaseExcelService<Currency, CurrencyVo> implements CurrencyExcelService {
    /**
     * 服务对象
     */
    @Autowired
    private CurrencyService service;

    /**
     * 处理数据方法
     *
     * @param dataList 校验通过的解析数据
     */
    @Override
    @Transactional
    public void doImportHandle(final String batchId, List<CurrencyVo> dataList) {
        List<Currency> countries = dataList.stream()
                .map(o -> MODEL_MAPPER.map(o, Currency.class)).collect(Collectors.toList());
        service.save(countries);
    }

    /**
     * 分页导出数据
     *
     * @param search 分页查询对象
     * @return 返回分页查询结果
     */
    @Override
    public PageResult<Currency> findByPage(Search search) {
        return service.findByPage(search);
    }
}
