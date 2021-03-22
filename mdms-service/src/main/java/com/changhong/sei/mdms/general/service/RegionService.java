package com.changhong.sei.mdms.general.service;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.BaseTreeDao;
import com.changhong.sei.core.service.BaseTreeService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.mdms.common.utils.PinYinUtil;
import com.changhong.sei.mdms.general.dao.RegionDao;
import com.changhong.sei.mdms.general.entity.Region;
import com.changhong.sei.util.IdGenerator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


/**
 * 行政区域(Region)业务逻辑实现类
 *
 * @author sei
 * @since 2020-08-17 14:02:48
 */
@Service("regionService")
public class RegionService extends BaseTreeService<Region> {
    @Autowired
    private RegionDao dao;

    @Override
    protected BaseTreeDao<Region> getDao() {
        return dao;
    }

    public List<Region> getRegionTree() {
        List<Region> rootTree = getAllRootNode();
        List<Region> rootRegionTree = new ArrayList<>();
        for (Region aRootTree : rootTree) {
            Region region = getTree(aRootTree.getId());
            rootRegionTree.add(region);
        }
        return rootRegionTree;
    }

    /**
     * 通过国家id查询行政区域树
     *
     * @param countryId 国家id
     * @return 行政区域树清单
     */
    public List<Region> getRegionTreeByCountry(String countryId) {
        //获取根节点-国家
        Region region = dao.findByCountryIdAndNodeLevel(countryId, 0);
        if (region == null) {
            return Collections.emptyList();
        }
        return buildTree(dao.findByCodePathStartingWithAndIdNot(region.getCodePath(), region.getId()));
    }

    public List<Region> getProvinceByCountry(String countryId) {
        if (StringUtils.isEmpty(countryId)) {
            return Collections.emptyList();
        }
        //获取根节点-国家
        Region region = dao.findByCountryIdAndNodeLevel(countryId, 0);
        if (region == null) {
            return Collections.emptyList();
        }
        return dao.findListByProperty("parentId", region.getId());
    }

    public List<Region> getCityByProvince(String provinceId) {
        if (StringUtils.isEmpty(provinceId)) {
            return Collections.emptyList();
        }
        return dao.findListByProperty("parentId", provinceId);
    }

    /**
     * 保存前检查代码唯一性
     * 同前端约定:根节点为国家前端会传递CountryId,非根节点需要通过parentId获取CountryId
     *
     * @param entity 待保存的行政区域
     * @return 操作结果
     */
    @Override
    public OperateResultWithData<Region> save(Region entity) {
        // 同前端约定:根节点为国家前端会传递CountryId,非根节点需要通过parentId获取CountryId
//        if (StringUtils.isBlank(entity.getCountryId())) {
//            // 该行政区域对应国家属性为空！
//            return OperateResultWithData.operationFailure("00010");
//        }
        String id = IdGenerator.uuid();
        if (StringUtils.isNotBlank(entity.getId())) {
            id = entity.getId();
        }
        if (dao.isCodeExists(ContextUtil.getTenantCode(), entity.getCode(), id)) {
            // 该行政区域代码已存在，不能重复！
            return OperateResultWithData.operationFailure("00011");
        }
        //根节点未国家，因此需要检查是否重复添加国家根节点
        String parentId = entity.getParentId();
        if (StringUtils.isBlank(parentId)) {
            //获取根节点-国家
            Region region = dao.findByCountryIdAndNodeLevel(entity.getCountryId(), 0);
            if (Objects.nonNull(region) && !Objects.equals(region.getId(), entity.getId())) {
                // 国家根节点，不能重复！
                return OperateResultWithData.operationFailure("00012", region.getName());
            }
        } else {
            // 同前端约定:根节点为国家前端会传递CountryId,非根节点需要通过parentId获取CountryId
            Region region = dao.findOne(parentId);
            if (Objects.nonNull(region)) {
                // 从父节点获取国家id
                entity.setCountryId(region.getCountryId());
            } else {
                // 【{0}】的上级行政区域不存在！
                return OperateResultWithData.operationFailure("00017", entity.getName());
            }
        }
        // 设置简称为拼音首字母
        if (StringUtils.isBlank(entity.getShortName())) {
            entity.setShortName(PinYinUtil.getUpperCase(entity.getName(), false));
        }
        // 设置汉语拼音
        if (StringUtils.isBlank(entity.getPinYin())) {
            entity.setPinYin(PinYinUtil.getLowerCase(entity.getName(), true));
        }
        OperateResultWithData<Region> resultWithData = super.save(entity);
        //保存成功，移除所有缓存，防止旧数据
        if (resultWithData.successful()) {
            String keyPattern = "sei:commomsdata:region:*";
            Set<String> keySet = cacheBuilder.keys(keyPattern);
            keySet.forEach(key -> {
                cacheBuilder.remove(key);
            });
        }
        return resultWithData;
    }

    /**
     * 更新简称为拼音大写首字母
     */
    @Transactional(rollbackFor = Exception.class)
    public void refreshShortName() {
        List<Region> regions = findAll();
        regions.forEach(region -> {
            boolean isChange = Boolean.FALSE;
            // 设置简称为拼音首字母
            if (StringUtils.isBlank(region.getShortName())) {
                region.setShortName(PinYinUtil.getUpperCase(region.getName(), false));
                isChange = Boolean.TRUE;
            }
            // 设置汉语拼音
            if (StringUtils.isBlank(region.getPinYin())) {
                region.setPinYin(PinYinUtil.getLowerCase(region.getName(), true));
                isChange = Boolean.TRUE;
            }
            if (isChange) {
                dao.save(region);
            }
        });
    }
}