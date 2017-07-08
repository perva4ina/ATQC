package com.gmail.perva4ina.helper;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    private XSSFWorkbook book;
    private XSSFSheet sheet;
    private XSSFCell cell;

    public ExcelReader(String relatedPath) throws IOException {
        String projectPath = System.getProperty("user.dir");
        String fullPath = projectPath + relatedPath;
        try {
            FileInputStream excelFile = new FileInputStream(fullPath);
            this.book = new XSSFWorkbook(excelFile);
        }
        catch (IOException e) {
            throw new IOException(String.format("File '%s' is not found", fullPath));

        }
    }

    public ExcelReader(String relatedPath, String sheetName) throws IOException {
        this(relatedPath);
        sheet = getSheet(sheetName);
    }

    private XSSFSheet getSheet(String sheetName) {
        return book.getSheet(sheetName);
    }

    private Object getCellData(int rowNum, int colNum) {
        Object cellValue = null;
        cell = sheet.getRow(rowNum).getCell(colNum);
        CellType cellType = cell.getCellTypeEnum();
        switch (cellType) {
            case STRING : { cellValue = cell.getStringCellValue(); break; }
            case BOOLEAN : { cellValue = cell.getBooleanCellValue(); break; }
            case NUMERIC : { cellValue = cell.getNumericCellValue(); break; }
        }
        return cellValue;
    }

    private List<Integer> getRowNumbersWithText(String testCaseName, int colNum) {
        List<Integer> list = new ArrayList<Integer>();
        int rowCount = sheet.getLastRowNum();
        for (int i = 0; i<= rowCount; i++) {
            String cellData = getCellData(i, colNum).toString();
            if (cellData.equalsIgnoreCase(testCaseName)) {
                list.add(i);
            }
        }
        return list;
    }

    private Object[] getRowData(int rowNum) {
        List<Object> rowData = new ArrayList<Object>();
        int startCol = 0;
        int endCol = sheet.getRow(rowNum).getLastCellNum() - 1;
        for (int i = startCol; i <= endCol; i++) {
            rowData.add(getCellData(rowNum, i));
        }
        return rowData.toArray(new Object[rowData.size()]);
    }

    public Object[][] getTableArray() {
        int rows = sheet.getPhysicalNumberOfRows();
        Object[][] tableArray = new Object[rows][];
        for (int i = 0; i < rows; i++) {
            tableArray[i] = getRowData(i);
        }
        return tableArray;
    }

    public Object[][] getTableArray(String testCaseName, int colNum) {
        List<Integer> rowNumbers = getRowNumbersWithText(testCaseName, colNum);
        Object[][] tableArray = new Object[rowNumbers.size()][];
        for (int i = 0; i < rowNumbers.size(); i++) {
            tableArray[i] = getRowData(rowNumbers.get(i));
        }
        return tableArray;
    }
}
