package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindAllApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.dms.general.dto.TaxCategory;
import com.changhong.sei.dms.general.dto.TaxTypeDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * 税类型(TaxType)API
 *
 * @author 杨沄炜
 * @since 2021/06/23 9:12
 */
@Valid
@FeignClient(name = "dms", path = TaxTypeApi.PATH)
public interface TaxTypeApi extends BaseEntityApi<TaxTypeDto>, FindByPageApi<TaxTypeDto>, FindAllApi<TaxTypeDto> {
    String PATH = "taxType";

    /**
     * 根据税分类获取税类型清单
     *
     * @param taxCategory 税分类
     * @return 税类型清单
     */
    @GetMapping(path = "findByTaxCategory")
    @ApiOperation(value = "根据税分类获取税类型清单", notes = "根据税分类获取税类型清单")
    ResultData<List<TaxTypeDto>> findByTaxCategory(@RequestParam("taxCategory") TaxCategory taxCategory);

    /**
     * 根据税码获取税类型清单
     *
     * @param code 税码
     * @return 税类型
     */
    @GetMapping(path = "findByCode")
    @ApiOperation(value = "根据税码获取税类型", notes = "根据税码获取税类型")
    ResultData<TaxTypeDto> findByCode(@RequestParam("code") String code);
}