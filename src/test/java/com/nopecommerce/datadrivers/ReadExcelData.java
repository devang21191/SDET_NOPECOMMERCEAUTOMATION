package com.nopecommerce.datadrivers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	public void readData() throws IOException {

		File file = new File("DataFolder/DataSheet2.xlsx"); // creating a new file instance
		FileInputStream fis = new FileInputStream(file); // obtaining bytes from the file
		// creating Workbook instance that refers to .xlsx file
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Credentials"); // creating a Sheet object to retrieve object
		Iterator<Row> itr = sheet.iterator(); // iterating over excel file
		/*int rows = sheet.getLastRowNum();
		System.out.println(rows);
		for(int i = 0; i < rows; i++) {
			Row row = sheet.getRow(i);
			int cols = row.getLastCellNum();
			
			for(int j = 0; j< cols; j++) {
				System.out.println(row.getCell(j));
			}
		}*/
		while (itr.hasNext()) {
			Row row = itr.next();
			Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING: // field that represents string cell type
					System.out.print(cell.getStringCellValue() + "\t\t\t");
					break;
				case Cell.CELL_TYPE_NUMERIC: // field that represents number cell type
					System.out.print(cell.getNumericCellValue() + "\t\t\t");
					break;
				default:
				}
			}
			System.out.println("");
		}
	}
}
