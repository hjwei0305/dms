package com.changhong.sei.mdms.service;

import com.changhong.sei.core.dao.BaseTreeDao;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseTreeService;
import com.changhong.sei.mdms.dao.MasterDataTypeDao;
import com.changhong.sei.mdms.entity.DataModelType;
import com.changhong.sei.mdms.entity.MasterDataType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


/**
 * 主数据分类(MasterDataType)业务逻辑实现类
 *
 * @author sei
 * @since 2020-08-13 22:47:06
 */
@Service("masterDataTypeService")
public class MasterDataTypeService extends BaseTreeService<MasterDataType> {
    @Autowired
    private MasterDataTypeDao dao;

    @Override
    protected BaseTreeDao<MasterDataType> getDao() {
        return dao;
    }

    /**
     * 根据模型代码获取一个节点的树
     *
     * @param code 节点code
     * @return 节点树
     */
    public ResultData<MasterDataType> getTreeByCode(String code) {
        MasterDataType type = dao.findByProperty(DataModelType.CODE, code);
        if (Objects.nonNull(type)) {
            MasterDataType tree = dao.getTree(type.getId());
            return ResultData.success(tree);
        }
        return ResultData.fail("未找到[" + code + "]主数据分类.");
    }
}