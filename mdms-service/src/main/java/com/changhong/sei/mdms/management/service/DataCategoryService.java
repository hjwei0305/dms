package com.changhong.sei.mdms.management.service;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.BaseTreeDao;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseTreeService;
import com.changhong.sei.mdms.management.dao.DataCategoryDao;
import com.changhong.sei.mdms.management.entity.DataCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


/**
 * 主数据分类(DataCategory)业务逻辑实现类
 *
 * @author sei
 * @since 2020-08-13 22:47:06
 */
@Service("dataCategoryService")
public class DataCategoryService extends BaseTreeService<DataCategory> {
    @Autowired
    private DataCategoryDao dao;

    @Override
    protected BaseTreeDao<DataCategory> getDao() {
        return dao;
    }

    /**
     * 根据模型代码获取一个节点的树
     *
     * @param code 节点code
     * @return 节点树
     */
    public ResultData<DataCategory> getTreeByCode(String code) {
        DataCategory type = dao.findByProperty(DataCategory.CODE, code);
        if (Objects.nonNull(type)) {
            DataCategory tree = dao.getTree(type.getId());
            return ResultData.success(tree);
        }
        // 未找到[" + code + "]主数据分类.
        return ResultData.fail(ContextUtil.getMessage("00019", code));
    }
}