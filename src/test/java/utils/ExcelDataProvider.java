package utils;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

	@DataProvider(name="loginCredentials")	
	public Object[][] getData() throws IOException {
		String projectPath = System.getProperty("user.dir");
		Object data[][] = testData(projectPath+"/excel/data.xlsx", "credentials");
		return data;
	}

	public Object[][] testData(String excelPath, String sheetName) throws IOException {
		@SuppressWarnings("unused")
		ExcelUtils excelUtils = new ExcelUtils(excelPath, sheetName);
		int rowCount = ExcelUtils.getRowCount();
		int colCount = ExcelUtils.getColCount();

		Object data[][] = new Object[rowCount-1][colCount]; 
		String cellData;
		for(int i=1; i<rowCount;i++) {
			for (int j=0;j<colCount;j++) {
				cellData = ExcelUtils.getCellData(i, j);
				data[i-1][j] = cellData;
			}
		}
		return data;

	}

}
