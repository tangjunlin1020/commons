package com.wondersgroup.commons.util.demo.io.Excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * TODO
 *唐俊林
 * @since
 */
public class Excel {

    /**
     * 1.创建工作簿
     * @throws IOException
     */
    @Test
    public  void test1() throws IOException {
        //创建工作簿 （使用了多态特性）    HSSFWorkbook wb = new HSSFWorkbook();
        Workbook wb = new HSSFWorkbook();
        //使用工作簿的write()方法向文件输出工作簿
        FileOutputStream out = new FileOutputStream("src/main/resources/demo/excel/1.xls");
        wb.write(out);
        //流的关闭
        out.close();
        System.out.printf("创建工作簿成功");
    }

    /**
     * 2.创建sheet页
     * @throws IOException
     */
    @Test
    public  void test2() throws IOException {
            //创建工作簿 （使用了多态特性）    HSSFWorkbook wb = new HSSFWorkbook();
            Workbook wb = new HSSFWorkbook();
            //创建两个sheet页
            wb.createSheet("sheet1");
            wb.createSheet("sheet2");
            //创建流并将wb输出
            FileOutputStream out = new FileOutputStream("src/main/resources/demo/excel/2.xls");
            wb.write(out);
            //流的关闭
            out.close();
        System.out.printf("创建sheet页成功");
        }

    /**
     * 3.创建行和单元格
     * @throws IOException
     */
    @Test
    public  void test3() throws IOException {
        //创建工作簿 （使用了多态特性）    HSSFWorkbook wb = new HSSFWorkbook();
        Workbook wb = new HSSFWorkbook();
        //创建sheet页（使用的是带参构造器）
        Sheet sheet = wb.createSheet("sheet01");
        //创建行（从0开始）
        Row row = sheet.createRow(0);
        //创建单元格(第一列)
        Cell cell = row.createCell(0);
        //给单元格赋值
        cell.setCellValue("测试单元格内容");
        //创建流并将wb输出
        FileOutputStream out = new FileOutputStream("src/main/resources/demo/excel/3.xls");
        wb.write(out);
        //流的关闭
        out.close();
        System.out.printf("创建行和单元格成功");
    }

    /**
     * 3.单元格创建其他值的示例
     * @throws IOException
     */
    @Test
    public  void test4() throws IOException {
        //创建工作簿 （使用了多态特性）    HSSFWorkbook wb = new HSSFWorkbook();
        Workbook wb = new HSSFWorkbook();
        //创建sheet页（使用的是带参构造器）
        Sheet sheet = wb.createSheet("sheet01");
        //创建行（从0开始）
        Row row = sheet.createRow(0);
        //创建单元格(第一列)
        Cell cell = row.createCell(0);
        //给单元格赋值
        cell.setCellValue("测试单元格内容");
        //测试其他的赋值方式
        row.createCell(1).setCellValue(1.1);    //第二列赋浮点值
        row.createCell(2).setCellValue(false);  //第三列赋值boolean型
        row.createCell(3).setCellValue("测试单元格内容11");  //
        //创建流并将wb输出
        FileOutputStream out = new FileOutputStream("src/main/resources/demo/excel/4.xls");
        wb.write(out);
        //流的关闭
        out.close();
        System.out.printf("单元格创建其他值的示例成功");
    }

}


