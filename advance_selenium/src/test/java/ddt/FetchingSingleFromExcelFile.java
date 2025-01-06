package ddt;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingSingleFromExcelFile {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis1 = new FileInputStream("C:\\eclipse-jee-2024-06-R-win32-x86_64\\eclipse\\advance_selenium\\src\\test\\resources\\add_selenium.xlsx");
		
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet("sheet1");
	   Row row = sheet.getRow(3);
	   Cell cell = row.getCell(2);
	   //String excelData = cell.getStringCellValue();
	  // double excelData = cell.getNumericCellValue();
	   DataFormatter data = new DataFormatter();
	   String excelData = data.formatCellValue(cell);
	     System.out.println(excelData);
	     
	}

}
