package com.changhong.sei.dms.general.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.dms.general.entity.TaxRateTypeCode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 税收分类编码(TaxRateTypeCode)数据库访问类
 *
 * @author sei
 * @since 2021-11-10 14:21:38
 */
@Repository
public interface TaxRateTypeCodeDao extends BaseEntityDao<TaxRateTypeCode> {


    @Query("select c from TaxRateTypeCode c where c.goodNum = :goodNum and c.version = :version")
    TaxRateTypeCode findCodeBySPBMAndBB(@Param("goodNum") String goodNum, @Param("version") String version);

    @Query("select c from TaxRateTypeCode c where c.pid = '0' and c.frozen = false ")
    List<TaxRateTypeCode> getRootNode();


    @Query("select c from TaxRateTypeCode c where c.pid = :pid and c.frozen = false ")
    List<TaxRateTypeCode> getNodeByPid(@Param("pid") String pid);

    @Query("select c from TaxRateTypeCode c where c.goodNum  like concat(\'\',:prefixCode,\'%\') and c.frozen = false")
    List<TaxRateTypeCode> getNodeByPrefix(@Param("prefixCode") String prefixCode);
    
}