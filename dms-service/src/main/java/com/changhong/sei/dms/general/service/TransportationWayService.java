package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.TransportationWayDao;
import com.changhong.sei.dms.general.entity.TransportationWay;
import org.springframework.stereotype.Service;

/**
 * @Author: 刘松林
 * @Contact: songlin.liu@changhong.com
 * @Date: 2020/3/12 16:02
 * @Description:
 */
@Service
public class TransportationWayService extends BaseEntityService<TransportationWay> {

    private final TransportationWayDao transportationWayDao;

    public TransportationWayService(TransportationWayDao transportationWayDao) {
        this.transportationWayDao = transportationWayDao;
    }

    @Override
    protected BaseEntityDao<TransportationWay> getDao() {
        return this.transportationWayDao;
    }
}
