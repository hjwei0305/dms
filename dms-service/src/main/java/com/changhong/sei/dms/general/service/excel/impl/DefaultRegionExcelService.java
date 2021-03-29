package com.changhong.sei.dms.general.service.excel.impl;

import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.dms.common.excel.BaseExcelService;
import com.changhong.sei.dms.general.entity.Region;
import com.changhong.sei.dms.general.service.RegionService;
import com.changhong.sei.dms.general.service.excel.RegionExcelService;
import com.changhong.sei.dms.general.service.excel.vo.RegionVo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 实现功能：行政区域导入导出服务
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-10-12 00:35
 */
public class DefaultRegionExcelService extends BaseExcelService<Region, RegionVo> implements RegionExcelService {

    private final RegionService service;

    public DefaultRegionExcelService(RegionService service) {
        super(null);

        this.service = service;
    }

    /**
     * 处理数据方法
     *
     * @param batchId  当前导入批次id(一次上传导入记为一个batchId)
     * @param dataList 校验通过的解析数据
     */
    @Override
    public void doImportHandle(String batchId, List<RegionVo> dataList) {
        List<Region> countries = dataList.stream()
                .map(o -> MODEL_MAPPER.map(o, Region.class)).collect(Collectors.toList());
        // 树形结构需要根据模版独立处理层级管理
        service.save(countries);
    }

    /**
     * 分页导出数据
     *
     * @param search 分页查询对象
     * @return 返回分页查询结果
     */
    @Override
    public PageResult<Region> findByPage(Search search) {
        return service.findByPage(search);
    }
}
