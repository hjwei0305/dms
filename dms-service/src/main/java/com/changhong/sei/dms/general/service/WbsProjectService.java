package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.dms.general.dao.WbsProjectDao;
import com.changhong.sei.dms.general.dto.WbsProjectDto;
import com.changhong.sei.dms.general.entity.HrOrganization;
import com.changhong.sei.dms.general.entity.WbsProject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * WBS项目(WbsProject)业务逻辑实现类
 *
 * @author sei
 * @since 2021-04-19 16:58:44
 */
@Service("wbsProjectService")
public class WbsProjectService extends BaseEntityService<WbsProject> {
    @Autowired
    private WbsProjectDao dao;

    @Override
    protected BaseEntityDao<WbsProject> getDao() {
        return dao;
    }


    /**
     * 覆写保存方法，增加保存前校验
     *
     * @param entity 待保存实体
     * @return 操作结果
     */
    @Override
    public OperateResultWithData<WbsProject> save(WbsProject entity) {
        //判断父节点是否存在
        if (StringUtils.isNoneBlank(entity.getParentCode())) {
            WbsProject parentWbsProject = findByProperty("code", entity.getParentCode());
            if (Objects.isNull(parentWbsProject)) {
                //00023=父节点【{0}】不存在，请检查！
                return OperateResultWithData.operationWarning("00023", entity.getParentCode());
            }
        }
        return super.save(entity);
    }


    /**
     * 获取WBS项目树（未冻结的）
     *
     * @return WBS项目多根树对象集合
     */
    public List<WbsProject> getUnfrozenTree() {
        List<WbsProject> treeList = new ArrayList<>();
        List<WbsProject> allList = dao.findAllUnfrozen();
        List<WbsProject> rootNodeList = allList.stream().filter(a -> StringUtils.isBlank(a.getParentCode())).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(rootNodeList)) {
            allList.removeAll(rootNodeList);
            for (WbsProject rootNode : rootNodeList) {
                if (Objects.nonNull(rootNode)) {
                    WbsProject tree = getTree(rootNode, allList);
                    treeList.add(tree);
                }
            }
        }
        return treeList;
    }

    /**
     * 获取WBS项目树（含冻结）
     */
    public List<WbsProject> getAllTree() {
        List<WbsProject> treeList = new ArrayList<>();
        List<WbsProject> allList = dao.findAll();
        List<WbsProject> rootNodeList = allList.stream().filter(a -> StringUtils.isBlank(a.getParentCode())).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(rootNodeList)) {
            allList.removeAll(rootNodeList);
            for (WbsProject rootNode : rootNodeList) {
                if (Objects.nonNull(rootNode)) {
                    WbsProject tree = getTree(rootNode, allList);
                    treeList.add(tree);
                }
            }
        }
        return treeList;
    }


    /**
     * 获取树
     *
     * @param rootNode        当前节点
     * @param allChildrenList 子节点清单
     * @return 返回指定节点树形对象
     */
    private WbsProject getTree(WbsProject rootNode, List<WbsProject> allChildrenList) {
        List<WbsProject> childrenTreeList = new ArrayList<>();
        if (Objects.nonNull(rootNode)) {
            if (CollectionUtils.isNotEmpty(allChildrenList)) {
                List<WbsProject> rootChildrenList = allChildrenList.stream().filter(e -> Objects.equals(e.getParentCode(), rootNode.getCode())).collect(Collectors.toList());
                if (CollectionUtils.isNotEmpty(rootChildrenList)) {
                    allChildrenList.removeAll(rootChildrenList);
                    //递归构造子节点
                    rootChildrenList.forEach(children -> {
                        if (Objects.nonNull(children)) {
                            WbsProject childrenTree = getTree(children, allChildrenList);
                            childrenTreeList.add(childrenTree);
                        }
                    });
                }
            }
            rootNode.setChildren(childrenTreeList);
        }
        return rootNode;
    }

}