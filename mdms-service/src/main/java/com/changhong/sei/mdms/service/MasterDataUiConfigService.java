package com.changhong.sei.mdms.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.mdms.dao.MasterDataUiConfigDao;
import com.changhong.sei.mdms.entity.MasterDataUiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 主数据UI配置(MasterDataUiConfig)业务逻辑实现类
 *
 * @author sei
 * @since 2020-08-13 22:47:16
 */
@Service("masterDataUiConfigService")
public class MasterDataUiConfigService extends BaseEntityService<MasterDataUiConfig> {
    @Autowired
    private MasterDataUiConfigDao dao;

    @Override
    protected BaseEntityDao<MasterDataUiConfig> getDao() {
        return dao;
    }

}