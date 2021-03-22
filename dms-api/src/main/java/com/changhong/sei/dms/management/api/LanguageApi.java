package com.changhong.sei.dms.management.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindAllApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.dms.management.dto.LanguageDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 实现功能: 语言类型API接口
 *
 * @author 王锦光 wangjg
 * @version 2020-03-22 8:00
 */
@FeignClient(name = "sei-commons-data", path = "language")
public interface LanguageApi extends BaseEntityApi<LanguageDto>, FindAllApi<LanguageDto> {
    /**
     * 获取外国语类型
     * @return 语言类型清单
     */
    @GetMapping(path = "getForeignLanguages")
    @ApiOperation(value = "获取外国语类型", notes = "获取排除中文以外的外国语类型")
    ResultData<List<LanguageDto>> getForeignLanguages();
}
