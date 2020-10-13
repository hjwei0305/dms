package com.changhong.sei.mdms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.mdms.management.dto.ProcessResult;
import com.changhong.sei.mdms.general.api.CountryApi;
import com.changhong.sei.mdms.general.dto.CountryDto;
import com.changhong.sei.mdms.general.entity.Country;
import com.changhong.sei.mdms.general.service.CountryService;
import com.changhong.sei.mdms.general.service.excel.CountryExcelService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 国家(Country)控制类
 *
 * @author sei
 * @since 2020-08-17 14:02:44
 */
@RestController
@Api(value = "CountryApi", tags = "国家服务")
@RequestMapping(path = "country", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CountryController extends BaseEntityController<Country, CountryDto> implements CountryApi {
    /**
     * 国家服务对象
     */
    @Autowired
    private CountryService service;
    @Autowired
    private CountryExcelService countryExcelService;

    @Override
    public BaseEntityService<Country> getService() {
        return service;
    }

    /**
     * 根据代码查询国家
     *
     * @param code 代码
     * @return 国家信息
     */
    @Override
    public ResultData<CountryDto> findByCode(String code) {
        Country country = service.findByCode(code);
        return ResultData.success(convertToDto(country));
    }

    /**
     * 获取所有业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<CountryDto>> findAll() {
        return ResultData.success(convertToDtos(service.findAll()));
    }

    /**
     * 获取所有未冻结的业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<CountryDto>> findAllUnfrozen() {
        return ResultData.success(convertToDtos(service.findAllUnfrozen()));
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<CountryDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }

    /**
     * 获取导入导出状态
     *
     * @return 获取导入导出状态
     */
    @Override
    public ResultData<List<ProcessResult>> imExStatus() {
        return countryExcelService.imExStatus();
    }

    /**
     * excel导入模版数据
     *
     * @return 导入模版数据
     */
    @Override
    public ResultData<Map<String, List<String>>> importTemplateData() {
        return countryExcelService.importTemplateData();
    }

    /**
     * excel文件数据导入
     *
     * @param file excel文件
     * @return 导入结果
     */
    @Override
    public ResultData<String> importDataExcel(MultipartFile file) {
        countryExcelService.importDataExcel(file);

        return ResultData.success();
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<String> exportData(Search search) {
        countryExcelService.exportData(search);

        return ResultData.success();
    }
}