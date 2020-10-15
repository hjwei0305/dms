package com.changhong.sei.mdms.common.controller;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.mdms.commom.dto.ProcessResult;
import com.changhong.sei.notify.dto.NotifyMessage;
import com.changhong.sei.notify.sdk.manager.NotifyManager;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-10-13 17:43
 */
public class ImportExportDataControllerTest extends BaseUnitTest {

    @Autowired
    private ImportExportDataController controller;
    @Autowired
    private NotifyManager notifyManager;

    private static final String SERVICE_NAME = "country";

    @Test
    public void imExStatus() {
        ResultData<Map<String, ProcessResult>> resultData = controller.imExStatus(SERVICE_NAME);
        System.out.println(resultData);

//        // 系统消息提醒
//        NotifyMessage message = new NotifyMessage();
//        message.setSubject("数据导出处理结果");
//        message.setReceiverIds(Lists.newArrayList(ContextUtil.getUserId()));
//        message.setContent("数据导出处理结果");
//        notifyManager.send(message);
    }

    @Test
    public void importTemplateData() {
        ResultData<Map<String, List<String>>> resultData = controller.importTemplateData(SERVICE_NAME);
        System.out.println(resultData);
    }

    @Test
    public void importDataExcel() {
        MultipartFile file = null;
        try {
            file = new MockMultipartFile("Country.xlsx", new FileInputStream(new File("/Users/chaoma/Downloads/Country.xlsx")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ResultData<Map<String, ProcessResult>> resultData = controller.importDataExcel(SERVICE_NAME, file);
        System.out.println(resultData);

        try {
            Thread.sleep(200000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void exportData() {
        ResultData<Map<String, ProcessResult>> resultData = controller.exportData(SERVICE_NAME, Search.createSearch());
        System.out.println(resultData);

        try {
            Thread.sleep(100000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}