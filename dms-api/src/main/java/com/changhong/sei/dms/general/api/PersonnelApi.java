package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.dms.general.dto.LedgerAccountDto;
import com.changhong.sei.dms.general.dto.PersonnelDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

/**
 * 公司员工(ERP)(Personnel)API
 *
 * @author sei
 * @since 2021-04-19 10:53:34
 */
@Valid
@FeignClient(name = "dms", path = PersonnelApi.PATH)
public interface PersonnelApi extends BaseEntityApi<PersonnelDto>, FindByPageApi<PersonnelDto> {
    String PATH = "personnel";

    /**
     * 获取在职状态
     */
    @GetMapping(path = "getWorkingStatus")
    @ApiOperation(value = "获取在职状态", notes = "获取在职状态")
    ResultData<Map<String, String>> getWorkingStatus();

    /**
     * 根据员工编号获取员工
     *
     * @param code 员工编号
     * @return 员工
     */
    @GetMapping(path = "findByCode")
    @ApiOperation(value = "根据员工编号获取员工", notes = "根据员工编号获取员工")
    ResultData<PersonnelDto> findByCode(@RequestParam("code") String code);
}