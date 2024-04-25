package com.saltfish.dailypractice.poi.easypoi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * EasyPoi测试
 */
public class EasyPoiTest {

    @SneakyThrows
    public static void main(String[] args) {
        // 测试多Sheet导出
        List<Map<String, Object>> list = new ArrayList<>(2);

        // 第一个Sheet
        List<Student> students1 = new ArrayList<>(2);
        students1.add(Student.builder().name("小明").age(14).build());
        students1.add(Student.builder().name("小红").age(10).build());
        Map<String, Object> map1 = getMap("第1页", students1);

        // 第二个Sheet
        List<Student> students2 = new ArrayList<>(2);
        students2.add(Student.builder().name("小明").age(14).build());
        students2.add(Student.builder().name("小红").age(10).build());
        Map<String, Object> map2 = getMap("第2页", students2);

        list.add(map1);
        list.add(map2);
        
        Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.XSSF);
        OutputStream out = new FileOutputStream(new File("D:\\test\\test.xlsx"));
        workbook.write(out);
        out.flush();
        out.close();
    }

    /**
     * 获取用于生成Sheet的map
     *
     * @param sheetName Sheet名称
     * @param students  学生列表
     * @return map
     */
    private static Map<String, Object> getMap(String sheetName, List<Student> students) {
        Map<String, Object> map2 = new HashMap<>(4);
        // ExportParams参数中title为表名，若有值则在当前Sheet最上面添加一行，内容为表名，若为null则没有该行
        // sheetName：当前Sheet名称
        // type：指定导出excel的类型，HSSF为xls文件，XSSF为xlsx文件
        map2.put("title", new ExportParams(null, sheetName, ExcelType.XSSF));
        map2.put("entity", Student.class);
        map2.put("data", students);
        return map2;
    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class Student {

        @Excel(name = "姓名")
        private String name;

        @Excel(name = "年龄")
        private Integer age;
    }
}
