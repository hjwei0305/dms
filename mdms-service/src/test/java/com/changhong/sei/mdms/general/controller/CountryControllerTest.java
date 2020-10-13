package com.changhong.sei.mdms.general.controller;

import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.test.BaseUnitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-10-09 14:59
 */
public class CountryControllerTest extends BaseUnitTest {

    @Autowired
    private CountryController controller;

    @Test
    public void importDataExcel() {
        MultipartFile file = null;
        try {
            file = new MockMultipartFile("Country.xlsx", new FileInputStream(new File("/Users/chaoma/Downloads/Country.xlsx")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        controller.importDataExcel(file);
    }

    @Test
    public void exportData() {

        controller.exportData(Search.createSearch());
    }
}