package TestNGTestS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * If @DataProvider present in other class and we need to use it then use syntax
 * as @Test(dataProvider="dp_name", dataProviderClass="class_name.class") over
 * Test case.
 * 
 * (.xls): class as HSSFSheet & HSSFWorkbook (HSSF: Horibble Spread Sheet Format)
 * (.xlsx): class as XSSFSheet & XSSFWorkbook (XML Spread Sheet Format)
 * 
 * FIS - class in java to read data of file (specify path in its constructor)
 * FOS - class in java to write data in file (specify path in its constructor)
 * 
 * @author Dharmik Mehta
 */

public class ReadExcelUsingPOI {
	
/*
// Hard coded Data
 
 	@Test(dataProvider = "Login Data1")
	public void tc_01(String name, String rollNo, double fees) {
		System.out.println(name+"\t"+rollNo+"\t"+fees);
	}
 
	@DataProvider(name = "Login Data1")
	public Object[][] readExcel() {
		Object[][] obj = {{"AAA","1001",10000},{"BBB","1002",5000},{"CCC","1003",12500},
						  {"DDD","1004",8000},{"EEE","1004",15000}};
		return obj;
	}
*/
	
/*
// Read only String Data with FileInputStream from Excel
	
	@Test(dataProvider = "Login Data2")
	public void tc_01(String name, String rollNo) {
		System.out.println(name+"\t"+rollNo);
	}
	
	@DataProvider(name = "Login Data2")
	public Object[][] readExcelwithFIS() throws IOException {
		
		Object[][] obj = new Object[5][2];
		
		FileInputStream fis = new FileInputStream("D:\\Jars\\Test_Data.xlsx");
		
		XSSFWorkbook book = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = book.getSheet("Student_Data");	// getSheet(String name) & getSheetAt(int index) with initial index=0
		
		int lastRow = sheet.getLastRowNum();
		for (int i = 1; i <=lastRow; i++) {
			Row row = sheet.getRow(i);
			int lastCell = row.getLastCellNum();
			for (int j = 1; j < lastCell; j++) {
				Cell cell = row.getCell(j);
				obj[i-1][j-1] = cell.getStringCellValue();
			}
		}
		return obj;
	}
*/
	
// /*
// Read all types of Data with FileInputStream from Excel
		
	@Test(dataProvider = "Login Data3")
	public void tc_01(String name, String rollNo, double fees, boolean value) {
		System.out.println(name+"\t "+rollNo+"\t "+fees+" \t "+value);
	}
		
	@DataProvider(name = "Login Data3")
	public Object[][] readExcelwithFIS() throws IOException {
		
		Object[][] obj = new Object[5][4];
		
		FileInputStream fis = new FileInputStream("D:\\Jars\\Test_Data.xlsx");
		
		XSSFWorkbook book = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = book.getSheet("Student_Data2");	// getSheet(String name) & getSheetAt(int index) with initial index=0
		
		int lastRow = sheet.getLastRowNum();	
		for (int i = 1; i <=lastRow; i++) {
			Row row = sheet.getRow(i);
			int lastCell = row.getLastCellNum();
			for (int j = 1; j < lastCell; j++) {
				Cell cell = row.getCell(j);
				switch(cell.getCellType()) {
				case STRING: 
					obj[i-1][j-1] = cell.getStringCellValue();
					break;
				case NUMERIC:
					obj[i-1][j-1] = cell.getNumericCellValue();
					break;
				case BLANK: 
					obj[i-1][j-1] = "BLANK";
					break;
				case BOOLEAN: 
 					obj[i-1][j-1] = cell.getBooleanCellValue();
					break;				
				case ERROR:
					obj[i-1][j-1] = cell.getErrorCellValue();
					break;
/*				case FORMULA:
					obj[i-1][j-1] = cell.getCellFormula();
					break;
				case _NONE:
					obj[i-1][j-1] = "NONE";
					break;	
*/						 
				default: 
					System.err.println("Invalid value found in Excel Sheet");
				}
			}
		}
		return obj;
	}
// */
}