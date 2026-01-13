package com.ninza.crm.generic.fileutility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetName, int row, int col) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
		return data;
	}

	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis2 = new FileInputStream("./src/test/resources/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		return rowCount;
	}

}
