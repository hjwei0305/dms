package com.changhong.sei.mdms.service.manager;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.mdms.dto.ColumnDto;
import com.changhong.sei.mdms.dto.TableDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-08-14 00:30
 */
public class DatabaseManagerTest extends BaseUnitTest {

    @Autowired
    private DatabaseManager manager;

    @Test
    public void getDatabases() {
        List<String> db = manager.getDatabases();
        System.out.println(db);
    }

    @Test
    public void getAllTableName() {
        ResultData<List<TableDto>> tables = manager.getAllTableName();
        System.out.println(tables);
    }

    @Test
    public void getAllColumn() {
        String table = "master_data_ui_config";
        ResultData<List<ColumnDto>> columns = manager.getAllColumn(table);
        System.out.println(columns);
    }


}