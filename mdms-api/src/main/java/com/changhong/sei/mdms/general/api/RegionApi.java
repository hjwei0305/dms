package com.changhong.sei.mdms.general.api;

import com.changhong.sei.core.api.BaseTreeApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.mdms.general.dto.RegionDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * 行政区域(Region)API
 *
 * @author sei
 * @since 2020-08-17 14:03:33
 */
@Valid
@FeignClient(name = "mdms", path = "region")
public interface RegionApi extends BaseTreeApi<RegionDto>, FindByPageApi<RegionDto> {
    /**
     * 获取所有行政区域树
     *
     * @return 行政区域树形对象集合
     */
    @GetMapping(path = "getMultipleRoots")
    @ApiOperation(notes = "查询所有的行政区域树", value = "查询所有的行政区域树")
    ResultData<List<RegionDto>> getMultipleRoots();

    /**
     * 通过国家id查询行政区域树
     *
     * @param countryId 国家id
     * @return 行政区域树清单
     */
    @GetMapping(path = "getRegionTreeByCountry")
    @ApiOperation(value = "行政区域树", notes = "通过国家id查询行政区域树")
    ResultData<List<RegionDto>> getRegionTreeByCountry(@RequestParam("countryId") String countryId);

    /**
     * 通过国家id查询省
     */
    @GetMapping(path = "getProvinceByCountry")
    @ApiOperation(value = "通过国家id查询省", notes = "通过国家id查询省")
    ResultData<List<RegionDto>> getProvinceByCountry(@RequestParam("countryId") String countryId);

    /**
     * 通过省id查询市
     */
    @GetMapping(path = "getCityByProvince")
    @ApiOperation(value = "通过省id查询市", notes = "通过省id查询市")
    ResultData<List<RegionDto>> getCityByProvince(@RequestParam("provinceId") String provinceId);

}