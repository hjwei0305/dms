package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindAllApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.dms.general.dto.TransportationWayDto;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author: 刘松林
 * @Contact: songlin.liu@changhong.com
 * @Date: 2020/3/12 16:01
 * @Description: 运输方式API接口
 */
@FeignClient(name = "dms", path = "transportationWay")
public interface TransportationWayApi extends BaseEntityApi<TransportationWayDto>,
        FindByPageApi<TransportationWayDto>, FindAllApi<TransportationWayDto> {
}
