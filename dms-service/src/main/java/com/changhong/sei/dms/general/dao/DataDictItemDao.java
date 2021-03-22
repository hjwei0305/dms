package com.changhong.sei.dms.general.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.dms.general.entity.DataDictItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataDictItemDao extends BaseEntityDao<DataDictItem> {
    /**
     * 根据字典代码，获取租户的字典项清单
     *
     * @param dataDictId 字典代码
     * @param tenantCode 租户代码
     * @return 字典下的字典项
     */
    @Query("select item from DataDictItem item where item.dataDict.id=?1 and item.tenantCode=?2 order by item.rank")
    List<DataDictItem> findByDictId(String dataDictId, String tenantCode);

    /**
     * 根据字典代码，展示值获取指定租户的字典项
     *
     * @param dataDictId 字典代码
     * @param dataName   展示值
     * @param tenantCode 租户代码
     * @return 字典下的字典项
     */
    @Query("select item from DataDictItem item where item.dataDict.id=?1 and item.dataName=?2 and item.tenantCode=?3")
    DataDictItem findByDictIdAndDataName(String dataDictId, String dataName, String tenantCode);

    /**
     * 根据字典代码，展示值获取指定租户未冻结的字典项
     *
     * @param dataDictId 字典代码
     * @param dataName   展示值
     * @param tenantCode 租户代码
     * @return 字典下的字典项
     */
    @Query("select item from DataDictItem item where item.dataDict.id=?1 and item.dataName=?2 and item.tenantCode=?3 and item.frozen=false")
    DataDictItem findByDictIdAndDataNameUnfrozen(String dataDictId, String dataName, String tenantCode);


    /**
     * 根据字典代码，获取租户未冻结的字典项清单
     *
     * @param dataDictId 字典Id
     * @param tenantCode 租户代码
     * @return 字典下的字典项
     */
    @Query("select item from DataDictItem item where item.dataDict.id=?1 and item.tenantCode=?2 and item.frozen=false order by item.rank")
    List<DataDictItem> findByDictIdUnfrozen(String dataDictId, String tenantCode);

    /**
     * 按字典Id和字典项的展示值查询字典项
     *
     * @param dataDictId 字典Id
     * @param dataName   字典项展示值
     * @param tenantCode 租户代码
     * @return 返回符合条件的字典项
     */
    DataDictItem findByDataDictIdAndDataNameAndTenantCode(String dataDictId, String dataName, String tenantCode);

    /**
     * 按字典Id和字典项的使用值查询字典项
     *
     * @param dataDictId 字典Id
     * @param dataValue  字典项使用值
     * @param tenantCode 租户代码
     * @return 返回符合条件的字典项
     */
    DataDictItem findByDataDictIdAndDataValueAndTenantCode(String dataDictId, String dataValue, String tenantCode);

    /**
     * 根据字典Id值判断业务实体是否存在
     *
     * @param dataDictId 字典Id
     * @return 未查询到返回false，如果查询到一条或多条数据则返回true
     */
    Boolean existsDataDictItemByDataDictId(String dataDictId);
}
