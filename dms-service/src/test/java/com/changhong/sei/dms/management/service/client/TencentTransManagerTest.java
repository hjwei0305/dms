package com.changhong.sei.dms.management.service.client;

import com.changhong.sei.core.test.BaseUnit5Test;
import com.changhong.sei.core.util.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 实现功能:
 *
 * @author 王锦光 wangjg
 * @version 2021-06-25 10:53
 */
class TencentTransManagerTest extends BaseUnit5Test {
    @Autowired
    private TencentTransManager manager;

    @Test
    public void translate() {
        List<String> queries = new LinkedList<>();
        queries.add("基础应用");
        queries.add("权限管理");
        queries.add("功能角色");
        queries.add("数据角色");
        queries.add("数据权限显示");
        queries.add("组织架构");
        queries.add("公司管理");
        queries.add("组织机构");
        queries.add("岗位类别");
        queries.add("岗位管理");
        queries.add("用户管理");
        queries.add("企业用户管理");
        queries.add("供应商用户管理");
        queries.add("专业领域");
        queries.add("专家用户管理");
        queries.add("系统配置");
        queries.add("给号服务配置");
        queries.add("发票管理");
        queries.add("发票类型");
        queries.add("商品编码");
        queries.add("推送信息模板");
        queries.add("系统日志");
        queries.add("税率");
        queries.add("接口权限配置");
        queries.add("数据来源");
        queries.add("邮箱配置");
        queries.add("基础配置");
        queries.add("物流公司");
        queries.add("用户配置");
        queries.add("公司");
        queries.add("客户");
        queries.add("发票类型分配");
        queries.add("税盘用途");
        queries.add("税率分配");
        queries.add("多税控盘");
        queries.add("物料管理");
        queries.add("产品");
        queries.add("发票认证配置");
        queries.add("授权下载配置");
        queries.add("公司邮箱");
        queries.add("公司开票证书配置");
        Map<String, String> transResult = manager.getTransResult(queries, "zh", "en");
        System.out.println((JsonUtils.toJson(transResult)));
    }
}