package com.changhong.sei.datamodel.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.core.util.JsonUtils;
import com.changhong.sei.datamodel.controller.DataSourceController;
import com.changhong.sei.datamodel.dto.DataSourceDto;
import com.changhong.sei.datamodel.dto.DataSourceRequest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-07-30 17:53
 */
public class DataSourceControllerTest extends BaseUnitTest {

    @Autowired
    private DataSourceController controller;

    @Test
    public void save() {
        String json = "{\"id\":\"E94BAB8E-D223-11EA-8A84-0242C0A84617\",\"code\":\"test\",\"remark\":\"123123123\",\"dbType\":\"MYSQL\",\"host\":\"127.0.0.1\",\"port\":3306,\"url\":\"jdbc:mysql://127.0.0.1:3306/test\",\"username\":\"dsfd\",\"password\":\"MTIzNA==\",\"frozen\":null}";
        DataSourceRequest dto = JsonUtils.fromJson(json, DataSourceRequest.class);
        ResultData<DataSourceDto> resultData = controller.save(dto);
        System.out.println(resultData);
    }

    @Test
    public void findByPage() {
        ResultData<PageResult<DataSourceDto>> resultData = controller.findByPage(Search.createSearch());
        System.out.println(resultData);
    }
}