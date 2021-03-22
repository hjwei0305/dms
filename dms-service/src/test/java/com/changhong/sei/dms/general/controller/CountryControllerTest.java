package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.test.BaseUnitTest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-10-09 14:59
 */
public class CountryControllerTest extends BaseUnitTest {

    @Autowired
    private CountryController controller;

//    @Test
//    public void importDataExcel() {
//        MultipartFile file = null;
//        try {
//            file = new MockMultipartFile("Country.xlsx", new FileInputStream(new File("/Users/chaoma/Downloads/Country.xlsx")));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        controller.importDataExcel(file);
//    }
//
//    @Test
//    public void importTemplateData() {
//        ResultData<Map<String, List<String>>> processResultResultData = controller.importTemplateData();
//        System.out.println(processResultResultData);
//    }
//
//    @Test
//    public void exportData() {
//
//        controller.exportData(Search.createSearch());
//    }
}