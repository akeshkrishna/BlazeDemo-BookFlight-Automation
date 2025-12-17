package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.IOException;
import java.io.InputStream;

public class ExcelUtils {

    private Sheet sheet;
    private DataFormatter formatter = new DataFormatter();


    public ExcelUtils(String excelFileNameOnClasspath, String sheetName) {
        try {
            InputStream is = ExcelUtils.class
                    .getClassLoader()
                    .getResourceAsStream(excelFileNameOnClasspath);

            if (is == null) {
                throw new RuntimeException("Excel file not found: " + excelFileNameOnClasspath);
            }

            Workbook workbook = WorkbookFactory.create(is);
            sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }

        } catch (IOException e) {
            throw new RuntimeException("Unable to open Excel file: " + excelFileNameOnClasspath, e);
        }
    }

    public String getCellData(int row, int col) {
        Cell cell = sheet.getRow(row).getCell(col);
        // DataFormatter converts anything (string/number/date) into a String
        return formatter.formatCellValue(cell);
    }

    }
