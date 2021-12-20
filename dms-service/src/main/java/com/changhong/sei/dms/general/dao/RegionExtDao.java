package com.changhong.sei.dms.general.dao;

import com.changhong.sei.dms.general.dto.search.MobileRegionParam;
import com.changhong.sei.dms.general.entity.Region;

import java.util.List;

/**
 * 实现功能:
 *
 * @author 杨沄炜
 * @date 2021/08/02 8:50
 */
public interface RegionExtDao {

    /**
     * 查询行政区域
     *
     * @param param 查询参数
     * @param countryId 国家Id
     * @return 行政区域清单
     */
    List<Region> getRegionByInitials(MobileRegionParam param,String countryId);
}
