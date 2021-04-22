package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.dms.general.dao.HrOrganizationDao;
import com.changhong.sei.dms.general.dto.HrOrganizationDto;
import com.changhong.sei.dms.general.entity.HrOrganization;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * HR组织机构(ERP)(HrOrganization)业务逻辑实现类
 *
 * @author sei
 * @since 2021-04-19 14:59:04
 */
@Service("hrOrganizationService")
public class HrOrganizationService extends BaseEntityService<HrOrganization> {
    @Autowired
    private HrOrganizationDao dao;

    protected static final ModelMapper dtoModelMapper;

    // 初始化静态属性
    static {
        // 初始化Entity与DTO的转换器
        dtoModelMapper = new ModelMapper();
        // 设置为严格匹配
        dtoModelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    protected BaseEntityDao<HrOrganization> getDao() {
        return dao;
    }


    /**
     * 覆写保存方法，增加保存前校验
     *
     * @param entity 待保存实体
     * @return 操作结果
     */
    @Override
    public OperateResultWithData<HrOrganization> save(HrOrganization entity) {
        //判断父节点是否存在
        if (StringUtils.isNoneBlank(entity.getParentCode())) {
            HrOrganization parentHrOrganization = findByProperty("code", entity.getParentCode());
            if (Objects.isNull(parentHrOrganization)) {
                //00023=父节点【{0}】不存在，请检查！
                return OperateResultWithData.operationWarning("00023", entity.getParentCode());
            }
        }
        return super.save(entity);
    }

    /**
     * 获取HR组织机构树（未冻结的）
     *
     * @return HrOrganization多根树对象集合
     */
    public ResultData<List<HrOrganizationDto>> getUnfrozenTree() {
        List<HrOrganizationDto> treeList = new ArrayList<>();
        List<HrOrganization> allList = dao.findAllUnfrozen();
        List<HrOrganization> rootNodeList = allList.stream().filter(a -> StringUtils.isBlank(a.getParentCode())).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(rootNodeList)) {
            allList.removeAll(rootNodeList);
            for (HrOrganization rootNode : rootNodeList) {
                if (Objects.nonNull(rootNode)) {
                    HrOrganizationDto rootDto = dtoModelMapper.map(rootNode, HrOrganizationDto.class);
                    rootDto.setCodePath(HrOrganizationDto.CODE_DELIMITER + rootNode.getCode());
                    rootDto.setNamePath(HrOrganizationDto.NAME_DELIMITER + rootNode.getName());
                    HrOrganizationDto tree = getTree(rootDto, allList);
                    treeList.add(tree);
                }
            }
        }
        return ResultData.success(treeList);
    }

    /**
     * 获取树
     *
     * @param rootNode        当前节点
     * @param allChildrenList 子节点清单
     * @return 返回指定节点树形对象
     */
    private HrOrganizationDto getTree(HrOrganizationDto rootNode, List<HrOrganization> allChildrenList) {
        List<HrOrganizationDto> childrenTreeList = new ArrayList<>();
        if (Objects.nonNull(rootNode)) {
            if (CollectionUtils.isNotEmpty(allChildrenList)) {
                List<HrOrganization> rootChildrenList = allChildrenList.stream().filter(e -> Objects.equals(e.getParentCode(), rootNode.getCode())).collect(Collectors.toList());
                if (CollectionUtils.isNotEmpty(rootChildrenList)) {
                    allChildrenList.removeAll(rootChildrenList);
                    //递归构造子节点
                    rootChildrenList.forEach(children -> {
                        if (Objects.nonNull(children)) {
                            HrOrganizationDto childrenDto = dtoModelMapper.map(children, HrOrganizationDto.class);
                            childrenDto.setCodePath(rootNode.getCodePath() + HrOrganizationDto.CODE_DELIMITER + childrenDto.getCode());
                            childrenDto.setNamePath(rootNode.getNamePath() + HrOrganizationDto.NAME_DELIMITER + childrenDto.getName());
                            childrenDto.setNodeLevel(rootNode.getNodeLevel() + 1);
                            childrenDto.setParentId(rootNode.getId());
                            HrOrganizationDto childrenTree = getTree(childrenDto, allChildrenList);
                            childrenTreeList.add(childrenTree);
                        }
                    });
                }
            }
            rootNode.setChildren(childrenTreeList);
        }
        return rootNode;
    }

    /**
     * 添加映射关系
     *
     * @param id             HR组织机构Id
     * @param organizationId 组织机构Id
     * @return 操作结果
     */
    public OperateResultWithData<HrOrganization> insertRelation(String id, String organizationId) {
        if (StringUtils.isBlank(id) || StringUtils.isBlank(organizationId)) {
            return OperateResultWithData.operationFailure("00069");
        }
        HrOrganization hrOrganization = findOne(id);
        if (null == hrOrganization) {
            return OperateResultWithData.operationFailure("00070", id);
        }
        hrOrganization.setOrganizationId(organizationId);
        return save(hrOrganization);
    }

    /**
     * 移除映射关系
     *
     * @param id HR组织机构Id
     * @return 操作结果
     */
    public OperateResultWithData<HrOrganization> removeRelation(String id) {
        if (StringUtils.isBlank(id)) {
            return OperateResultWithData.operationFailure("00071");
        }
        HrOrganization hrOrganization = findOne(id);
        if (null == hrOrganization) {
            return OperateResultWithData.operationFailure("00070", id);
        }
        hrOrganization.setOrganizationId(null);
        return save(hrOrganization);
    }

}