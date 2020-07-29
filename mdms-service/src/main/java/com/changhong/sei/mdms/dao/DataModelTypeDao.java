package com.changhong.sei.mdms.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dao.BaseTreeDao;
import com.changhong.sei.mdms.entity.DataModelType;
import org.springframework.stereotype.Repository;

/**
 * 数据模型分类(DataModelType)数据库访问类
 *
 * @author sei
 * @since 2020-07-28 17:31:43
 */
@Repository
public interface DataModelTypeDao extends BaseTreeDao<DataModelType> {

}