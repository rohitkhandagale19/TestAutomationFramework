package com.epam.framework.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {

    public static List<String[]> readExcelData(String filePath, String sheetName) {
        List<String[]> data = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Iterator<Row> rowIterator = sheet.iterator();

            // Skip the first row (header row)
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            // Process the remaining rows
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                String[] rowData = new String[row.getLastCellNum()];
                for (int i = 0; i < row.getLastCellNum(); i++) {
                    rowData[i] = formatter.formatCellValue(row.getCell(i));
                }
                data.add(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
