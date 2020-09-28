package com.changhong.sei.mdms.management.service;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.BaseTreeDao;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseTreeService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.mdms.management.dao.DataCategoryDao;
import com.changhong.sei.mdms.management.entity.DataCategory;
import com.changhong.sei.util.IdGenerator;
import org.apache.commons.lang3.StringUtils;
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
     * 保存树对象
     * 通过entity.isNew()判断是否是新增，当为true时，执行创建操作；为fasle时，执行更新操作
     * 约束：不允许修改parentId
     *
     * @param entity 树形结构实体
     * @return 返回操作对象
     */
    @Override
    public OperateResultWithData<DataCategory> save(DataCategory entity) {
        // code 为系统自定生成
        if (StringUtils.isBlank(entity.getCode())) {
            entity.setCode(String.valueOf(IdGenerator.randomLong()));
        }
        return super.save(entity);
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