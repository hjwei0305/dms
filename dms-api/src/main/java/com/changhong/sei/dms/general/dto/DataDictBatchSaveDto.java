package com.changhong.sei.dms.general.dto;

import java.util.List;

/**
 * @Author: 刘松林
 * @Contact: songlin.liu@changhong.com
 * @Date: 2020/3/16 17:25
 * @Description:
 */
public class DataDictBatchSaveDto {

    private DataDictDto dataDictDto;

    private List<DataDictItemDto> dataDictItemDtoList;

    public DataDictDto getDataDictDto() {
        return dataDictDto;
    }

    public void setDataDictDto(DataDictDto dataDictDto) {
        this.dataDictDto = dataDictDto;
    }

    public List<DataDictItemDto> getDataDictItemDtoList() {
        return dataDictItemDtoList;
    }

    public void setDataDictItemDtoList(List<DataDictItemDto> dataDictItemDtoList) {
        this.dataDictItemDtoList = dataDictItemDtoList;
    }
}
