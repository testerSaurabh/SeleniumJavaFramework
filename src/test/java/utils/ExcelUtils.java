package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static int rowCount;
	static int colCount;

	public ExcelUtils(String excelPath, String sheetName) throws IOException {
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
	}

	public static int getRowCount() throws IOException {
		rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;
	}

	public static int getColCount() throws IOException {
		colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		return colCount;
	}

	public static String getCellData(int rowNum, int colNum) throws IOException {
		String userName=null;
		for(int i=1;i<rowCount;i++) {
			userName = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		}
		return userName;
	}
}