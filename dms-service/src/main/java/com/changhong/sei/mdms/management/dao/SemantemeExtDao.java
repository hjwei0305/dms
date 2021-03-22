package com.changhong.sei.mdms.management.dao;

import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.mdms.management.dto.search.TranslationQuickQueryParam;
import com.changhong.sei.mdms.management.dto.trans.TransPropertyResult;

/**
 * 实现功能: 语义表的数据访问扩展接口
 *
 * @author 王锦光 wangjg
 * @version 2020-03-24 9:50
 */
public interface SemantemeExtDao {
    /**
     * 查询指定语种和语义类型的语义
     *
     * @param queryParam 查询参数
     * @return 语义qingdan
     */
    PageResult<TransPropertyResult> findTranslationsByPage(TranslationQuickQueryParam queryParam);
}
