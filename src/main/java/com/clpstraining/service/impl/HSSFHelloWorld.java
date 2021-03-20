package com.clpstraining.service.impl;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class HSSFHelloWorld {

    public static void main(String[] args) {
        // 文件路径
        String filePath = "E:\\CLPS Training\\helloWorld.xls";
        // 创建Excel文件(Workbook)
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建工作表(Sheet)
        HSSFSheet sheet = workbook.createSheet("Test");
        HSSFRow row = sheet.createRow(0);// 创建行,从0开始
        HSSFCell cell = row.createCell(0);// 创建行的单元格,也是从0开始
        cell.setCellValue("Jackie Chan");// 设置单元格内容
        row.createCell(1).setCellValue(false);// 设置单元格内容,重载
        CellStyle cellStyle = workbook.createCellStyle();
        CreationHelper createHelper = workbook.getCreationHelper();
        cellStyle.setDataFormat(
                createHelper.createDataFormat().getFormat("m/d/yy h:mm"));
        HSSFCell secondCell = row.createCell(2);
//        SimpleDateFormat sdf = new SimpleDateFormat("m/d/yy h:mm");
        secondCell.setCellValue(new Date());
        secondCell.setCellStyle(cellStyle);
        // 设置单元格内容,重载
        row.createCell(3).setCellValue(12.345);// 设置单元格内容,重载
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath);
            workbook.write(out);// 保存Excel文件
            out.close();// 关闭文件流
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("OK!");
    }
}
