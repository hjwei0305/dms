package com.changhong.sei.mdms.general.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.mdms.general.entity.DataDict;
import org.springframework.stereotype.Repository;

/**
 * 数据字典数据访问接口
 */
@Repository
public interface DataDictDao extends BaseEntityDao<DataDict> {
    /**
     * 通过代码获取数据字典
     *
     * @param code 字典代码
     * @return 数据字典
     */
    DataDict findByCode(String code);
}
