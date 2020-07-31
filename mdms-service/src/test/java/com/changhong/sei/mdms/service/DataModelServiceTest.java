package com.changhong.sei.mdms.service;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.mdms.entity.DataModelField;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-07-31 10:30
 */
public class DataModelServiceTest extends BaseUnitTest {

    @Autowired
    private DataModelService service;

    @Test
    public void saveFields() {
        String dataModelId = "1111";
        List<DataModelField> fields = addFields(dataModelId);

        ResultData<String> resultData = service.saveFields(dataModelId, fields);
        System.out.println(resultData);
    }

    @Test
    public void groupCount() {
        List<DataModelField> fields = addFields("111111");
        Map<String, Long> dataMap = fields.parallelStream()
                .collect(Collectors.groupingBy(DataModelField::getFieldName, Collectors.counting()));
        System.out.println(dataMap);
    }

    private List<DataModelField> addFields(String modelId) {
        DataModelField modelField;
        List<DataModelField> fields = new LinkedList<>();
        modelField = new DataModelField();
        modelField.setDataModelId(modelId);
        modelField.setFieldName("creator_id");
        modelField.setRemark("创建者");
        // {@link init_data.sql}
        modelField.setDataType("ShortString");
        modelField.setDataTypeDesc("字串-短");
        modelField.setDataLength(56);
        fields.add(modelField);
        modelField = new DataModelField();
        modelField.setDataModelId(modelId);
        modelField.setFieldName("creator_id");
        modelField.setRemark("创建者");
        // {@link init_data.sql}
        modelField.setDataType("ShortString");
        modelField.setDataTypeDesc("字串-短");
        modelField.setDataLength(56);
        fields.add(modelField);

        modelField = new DataModelField();
        modelField.setDataModelId(modelId);
        modelField.setFieldName("creator_account");
        modelField.setRemark("创建者账号");
        // {@link init_data.sql}
        modelField.setDataType("ShortString");
        modelField.setDataTypeDesc("字串-短");
        modelField.setDataLength(56);
        fields.add(modelField);

        modelField = new DataModelField();
        modelField.setDataModelId(modelId);
        modelField.setFieldName("creator_name");
        modelField.setRemark("创建者名称");
        // {@link init_data.sql}
        modelField.setDataType("ShortString");
        modelField.setDataTypeDesc("字串-短");
        modelField.setDataLength(56);
        fields.add(modelField);

        modelField = new DataModelField();
        modelField.setDataModelId(modelId);
        modelField.setFieldName("created_date");
        modelField.setRemark("创建时间");
        // {@link init_data.sql}
        modelField.setDataType("DateTime");
        modelField.setDataTypeDesc("日期时间");
        fields.add(modelField);


        modelField = new DataModelField();
        modelField.setDataModelId(modelId);
        modelField.setFieldName("last_editor_id");
        modelField.setRemark("创建者");
        // {@link init_data.sql}
        modelField.setDataType("ShortString");
        modelField.setDataTypeDesc("字串-短");
        modelField.setDataLength(56);
        fields.add(modelField);

        modelField = new DataModelField();
        modelField.setDataModelId(modelId);
        modelField.setFieldName("last_editor_account");
        modelField.setRemark("创建者账号");
        // {@link init_data.sql}
        modelField.setDataType("ShortString");
        modelField.setDataTypeDesc("字串-短");
        modelField.setDataLength(56);
        fields.add(modelField);

        modelField = new DataModelField();
        modelField.setDataModelId(modelId);
        modelField.setFieldName("last_editor_name");
        modelField.setRemark("创建者名称");
        // {@link init_data.sql}
        modelField.setDataType("ShortString");
        modelField.setDataTypeDesc("字串-短");
        modelField.setDataLength(56);
        fields.add(modelField);

        modelField = new DataModelField();
        modelField.setDataModelId(modelId);
        modelField.setFieldName("last_edited_date");
        modelField.setRemark("创建时间");
        // {@link init_data.sql}
        modelField.setDataType("DateTime");
        modelField.setDataTypeDesc("日期时间");
        fields.add(modelField);
        return fields;
    }
}