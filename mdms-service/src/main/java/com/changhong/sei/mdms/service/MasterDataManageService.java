package com.changhong.sei.mdms.service;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.mdms.dto.ColumnDto;
import com.changhong.sei.mdms.dto.TableDto;
import com.changhong.sei.mdms.service.manager.DatabaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-08-14 14:02
 */
@Service
public class MasterDataManageService {

    @Autowired
    private DatabaseManager databaseManager;

    /**
     * 获取当前数据库所有的表
     * https://cloud.tencent.com/developer/article/1011788
     */
    public ResultData<List<TableDto>> getAllMasterData() {
        return databaseManager.getAllTableName();
    }

    /**
     * 获取指定表字段信息
     *
     * @param code 主数据代码
     * @return 返回指定表字段清单
     */
    public ResultData<List<ColumnDto>> getPropertiesByCode(String code) {
        return databaseManager.getAllColumn(code);
    }

}
