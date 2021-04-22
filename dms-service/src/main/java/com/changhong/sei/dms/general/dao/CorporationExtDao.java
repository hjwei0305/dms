package com.changhong.sei.dms.general.dao;


import com.changhong.sei.dms.general.entity.Corporation;

import java.util.List;

/**
 * 产品扩展
 * @author Vision.Mac
 * @version 1.0.1 2019/2/16 0:24
 */
public interface CorporationExtDao{

    /**
     * 查询所有，根据创建日期正序排序
     *
     * @return
     */
    List<Corporation> findAll();
}
