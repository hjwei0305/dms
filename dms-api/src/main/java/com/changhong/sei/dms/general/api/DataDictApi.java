package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.dms.general.dto.DataDictBatchSaveDto;
import com.changhong.sei.dms.general.dto.DataDictDto;
import com.changhong.sei.dms.general.dto.DataDictItemDto;
import com.changhong.sei.dms.general.dto.DataDictValue;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 实现功能: 数据字典API接口
 *
 * @author 王锦光 wangjg
 * @version 2020-01-26 19:55
 */
@FeignClient(name = "dms", path = "dataDict")
public interface DataDictApi extends BaseEntityApi<DataDictDto>, FindByPageApi<DataDictDto> {
    /**
     * 保存字典项
     *
     * @param dictItemDto 字典项DTO
     * @return 处理结果
     */
    @PostMapping(path = "saveDictItem")
    @ApiOperation(value = "保存字典项", notes = "通过DTO保存字典项")
    ResultData<DataDictItemDto> saveDictItem(@RequestBody @Valid DataDictItemDto dictItemDto);

    /**
     * 删除字典项
     *
     * @param id 字典项id
     * @return 处理结果
     */
    @DeleteMapping(path = "deleteDictItem/{id}")
    @ApiOperation(value = "删除字典项", notes = "通过Id删除字典项")
    ResultData<Void> deleteDictItem(@PathVariable("id") String id);

    /**
     * 通过字典Id获取字典项
     *
     * @param dataDictId 字典Id
     * @return 数据字典项清单
     */
    @GetMapping(path = "getDataDictItems")
    @ApiOperation(value = "通过字典Id获取字典项", notes = "通过字典Id获取当前租户的全部字典项清单")
    ResultData<List<DataDictItemDto>> getDataDictItems(@RequestParam("dataDictId") String dataDictId);

    /**
     * 通过字典代码，获取可以使用的数据字典值
     *
     * @param dictCode 字典代码
     * @return 可使用的数据字典值
     */
    @GetMapping(path = "getCanUseDataDictValues")
    @ApiOperation(value = "通过字典代码，获取可以使用的数据字典值", notes = "通过字典代码，获取当前租户可以使用的数据字典值")
    ResultData<List<DataDictValue>> getCanUseDataDictValues(@RequestParam("dictCode") String dictCode);

    /**
     * 通过字典代码和字典项展示值，获取指定可以使用的数据字典值
     *
     * @param dictCode 字典代码
     * @param dataName 展示值
     * @return 可使用的指定数据字典值
     */
    @GetMapping(path = "getCanUseDataDictValue")
    @ApiOperation(value = "通过字典代码和字典项展示值，获取指定可以使用的数据字典值", notes = "通过字典代码和字典项展示值，获取指定可以使用的数据字典值")
    ResultData<DataDictValue> getCanUseDataDictValue(@RequestParam("dictCode") String dictCode, @RequestParam("dataName") String dataName);

    /**
     * 通过字典代码，获取可以使用的数据字典值
     *
     * @param batchDataDictSaveDto 字典批量维护DTO
     * @return 可使用的数据字典值
     */
    @PostMapping(path = "batchSaveDataDict")
    @ApiOperation(value = "批量存储数据字典", notes = "批量存储数据字典")
    ResultData<Boolean> batchSaveDataDict(@RequestBody DataDictBatchSaveDto batchDataDictSaveDto);

    /**
     * 字典项转为(取消)租户私有
     *
     * @param dictId 字典id
     * @param action 操作(true or false)
     * @return 操作结果
     */
    @PostMapping(path = "tenantPrivate/{dictId}/{action}")
    @ApiOperation(value = "字典项转为(取消)租户私有", notes = "字典项转为(取消)租户私有")
    ResultData<Void> tenantPrivate(@PathVariable("dictId") String dictId, @PathVariable("action") boolean action);
}
