package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindAllApi;
import com.changhong.sei.dms.general.dto.UnitDto;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author: 刘松林
 * @Contact: songlin.liu@changhong.com
 * @Date: 2020/3/12 15:30
 * @Description: 计量单位API接口
 */
@FeignClient(name = "dms", path = "unit")
public interface UnitApi extends BaseEntityApi<UnitDto>, FindAllApi<UnitDto> {
}
