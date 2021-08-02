package com.changhong.sei.dms.general.service;


import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.QuickSearchParam;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.dto.serach.SearchFilter;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.dms.general.dao.CorporationProjectDao;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import com.changhong.sei.dms.general.entity.CorporationProject;
import com.changhong.sei.dms.general.entity.CostCenter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


/**
 * 公司项目(CorporationProject)业务逻辑实现类
 *
 * @author sei
 * @since 2021-07-31 16:02:42
 */
@Service("corporationProjectService")
public class CorporationProjectService extends BaseEntityService<CorporationProject> {
    @Autowired
    private CorporationProjectDao dao;

    @Override
    protected BaseEntityDao<CorporationProject> getDao() {
        return dao;
    }


    /**
     * 保存数据
     *
     * @param entity 数据实体
     * @return 结果
     */
    @Override
    public OperateResultWithData<CorporationProject> save(CorporationProject entity) {
        if (StringUtils.isNoneBlank(entity.getWbsProjectId(), entity.getInnerOrderId())) {
            //00027 = WBS项目编号与内部订单编号只能存在一个，请检查！
            return OperateResultWithData.operationFailure("00027");
        }
        if (StringUtils.isAllBlank(entity.getWbsProjectId(), entity.getInnerOrderId())) {
            //00028 = WBS项目编号与内部订单编号必须存在一个，请检查！
            return OperateResultWithData.operationFailure("00028", entity.getName());
        }
        //校验名称重复
        Search search = new Search();
        search.addFilter(new SearchFilter("name", entity.getName()));
        search.addFilter(new SearchFilter("erpCorporationCode", entity.getErpCorporationCode()));
        search.addFilter(new SearchFilter("id", entity.getId(), SearchFilter.Operator.NE));
        CorporationProject exist = findFirstByFilters(search);
        if (Objects.nonNull(exist)) {
            //00025 = 已存在相同记录，请检查！
            return OperateResultWithData.operationFailure("00025", entity.getName());
        }
        return super.save(entity);
    }
}