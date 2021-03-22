package com.changhong.sei.dms.general.dao;

import com.changhong.sei.core.dao.BaseTreeDao;
import com.changhong.sei.dms.general.entity.Region;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

/**
 * 行政区域(Region)数据库访问类
 *
 * @author sei
 * @since 2020-08-17 14:02:48
 */
@Repository
public interface RegionDao extends BaseTreeDao<Region> {
    /**
     * 通过国家id查询行政区域树
     *
     * @param countryId 国家id
     * @return 行政区域树
     */
    Region findByCountryIdAndNodeLevel(String countryId, Integer nodeLevel);

    /**
     * Retrieves an entity by its id.
     *
     * @param s must not be {@literal null}.
     * @return the entity with the given id or {@literal null} if none found
     * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    @EntityGraph(attributePaths = {"country"}, type = EntityGraph.EntityGraphType.FETCH)
    @Override
    Region findOne(String s);
}