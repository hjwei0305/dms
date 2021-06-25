package com.changhong.sei.dms.management.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.dms.management.dto.SemantemeDto;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实现功能: 语义表API接口
 *
 * @author 王锦光 wangjg
 * @version 2020-03-22 8:00
 */
@FeignClient(name = "dms", path = "semanteme")
public interface SemantemeApi extends BaseEntityApi<SemantemeDto> {
}
