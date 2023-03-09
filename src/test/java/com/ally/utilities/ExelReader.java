package com.ally.utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ExelReader {

    public static String getRowCell(int rowNum, int cellNum) {

        String cellValue = "";
        String excelPath = "B23 TryCloud credentials.xlsx";
        String sheetName = "Sheet1";


        try {
            InputStream is = new FileInputStream(excelPath);
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheet(sheetName);

            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(cellNum);
            cellValue = cell.getStringCellValue();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return cellValue;
    }
}
