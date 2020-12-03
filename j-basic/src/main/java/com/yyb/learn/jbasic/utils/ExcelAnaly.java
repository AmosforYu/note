package com.yyb.learn.jbasic.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class ExcelAnaly {
    private static final String XLS = "xls";
    private static final String XLSX = "xlsx";


    public static void main(String[] args) {
        gogo();
    }
    public static void gogo() {

        String finalXlsxPath = "F:\\File Re\\WeChat Files\\yyb2682338\\FileStorage\\File\\2019-07\\高频号码集团统计.xlsx";
        File imss = new File("F:\\File Re\\WeChat Files\\yyb2682338\\FileStorage\\File\\2019-07\\和家固话号码及呼叫次数.xlsx");

        InputStream isIms = null;
        Workbook wbIms = null;
        try {
            isIms = new FileInputStream(imss);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            wbIms = new XSSFWorkbook(isIms);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> imsNums = readExcelValue(wbIms);
        writeExcelValue(imsNums, finalXlsxPath);
        System.out.println("写入完成");

    }


    private static List<String> readExcelValue(Workbook wb) {
//        LOGGER.info("》》》校验3：开始获取excel里的内容《《《");

        //1 获取第一个sheet
        Sheet sheet = wb.getSheetAt(0);
        //2.获取所有行数
        int allRows = sheet.getPhysicalNumberOfRows();
//        if (!"测试固话号".equals(sheet.getRow(1).getCell(0).getStringCellValue())) {
//            return ResultUtils.genFailResult(Constants.PARAM_ERROR, "格式错误，请重新上传!");
//        }
        int empty = 0;
        //从第2行开始读取数据.将所有数据存入list
        List<String> imsNums = new ArrayList<String>();
        System.out.println("读取开始时间："+ System.currentTimeMillis());
        for (int r = 1; r < allRows; r++) {
            Row row = sheet.getRow(r);

            Cell cell = row.getCell(0);
            cell.setCellType(CellType.STRING);

            String imsNum = cell.getStringCellValue();
            imsNums.add(imsNum);
        }
        System.out.println("读取结束时间："+ System.currentTimeMillis());


        return imsNums;
    }

    private static void writeExcelValue(List<String> list,String finalXlsxPath) {
        LOGGER.info("》》》校验3：开始写入excel《《《");

        OutputStream out = null;
        try {
            File finalXlsxFile = new File(finalXlsxPath);
            Workbook workBook = getWorkbok(finalXlsxFile);
            //1 获取第一个sheet
            Sheet sheet = workBook.getSheetAt(0);

//            //获取Excel最后一行
//            int rowNumber = sheet.getLastRowNum();
//            //empty
//            for (int i = 1; i <= rowNumber; i++) {
//                Row row = sheet.getRow(i);
//                sheet.removeRow(row);
//            }

            //2.获取所有行数
            int allRows = sheet.getPhysicalNumberOfRows();

            //从第2行开始读取数据.将所有数据存入list
            System.out.println("写开始时间："+ System.currentTimeMillis());
            for (int r = 1; r < allRows; r++) {
                Row row = sheet.getRow(r);

                String yes = "是";
                String no = "否";
                Cell first = row.getCell(0);
                first.setCellType(CellType.STRING);
                Cell third = row.getCell(2);
                third.setCellType(CellType.STRING);
                Cell second = row.getCell(1);
                second.setCellType(CellType.STRING);

                LOGGER.info("first.getStringCellValue()="+first.getStringCellValue());
                LOGGER.info("second.getStringCellValue()="+second.getStringCellValue());
                LOGGER.info("first.getStringCellValue().substring(5)="+first.getStringCellValue().substring(5));

                if (second != null || second.getStringCellValue() != "" || second.getStringCellValue() != null) {
                    if (list.contains(first.getStringCellValue().substring(5))) {
                        try {
                            third.setCellValue(yes);
                            System.out.println((r+1) +"|"+first.getStringCellValue()+ ": shi");
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else {
                        try {
                            third.setCellValue(no);
                            System.out.println((r+1) +"|"+first.getStringCellValue() + ": fou");
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                }
            }
            out =  new FileOutputStream(finalXlsxPath);
            workBook.write(out);
        } catch (Exception e) {
            System.out.println("error error" + e);
        } finally {
            try {
                if(out != null){
                    out.flush();
                    out.close();
                    System.out.println("数据导出成功");
                }
            } catch (IOException e) {
                System.out.println("error error error" + e);
            }
        }


    }

    public static Workbook getWorkbok(File file) throws IOException{
        Workbook wb = null;
        FileInputStream in = new FileInputStream(file);
        if(file.getName().endsWith(XLS)){     //Excel&nbsp;2003
            wb = new HSSFWorkbook(in);
        }else if(file.getName().endsWith(XLSX)){    // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }

}
