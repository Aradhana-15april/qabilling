package com.obsqura.utilities;

import com.obsqura.constants.Constants;
import io.netty.util.Constant;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtility {
    XSSFSheet sheet;
    XSSFWorkbook workbook;

    XSSFRow row;
    XSSFCell cell;

    public void setExcelFile(String workBookName, String sheetName) {
        try {
            String path = Constants.EXCEL_FILES_PATH + workBookName + ".xlsx";
            File src = new File(path);
            FileInputStream fi = new FileInputStream(src);
            workbook = new XSSFWorkbook(fi);
            sheet = workbook.getSheet(sheetName);

        } catch (Exception e) {

        }

    }

    public String getCellData(int rowNo, int columnNo) {
        row = sheet.getRow(rowNo);
        cell = row.getCell(columnNo);

        switch (cell.getCellType()) {
            case STRING: {
                String x;
                x = cell.getStringCellValue();
                return x;
            }
            case NUMERIC: {
                long d = (long) cell.getNumericCellValue();
                return String.valueOf(d);
            }

            default:
                return null;

        }


    }
}
