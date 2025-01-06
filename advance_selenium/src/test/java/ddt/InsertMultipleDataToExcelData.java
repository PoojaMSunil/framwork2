package ddt;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertMultipleDataToExcelData {

	public static void main(String[] args) {
		FileInputStream fis = new FileInputStream("C:\\eclipse-jee-2024-06-R-win32-x86_64\\eclipse\\advance_selenium\\src\\test\\resources\\Properties.properties")

				Workbook book = WorkbookFactory.create(fis);

		Sheet sheet = book.getSheet("Sheet2");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();

		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));

		for (int i = 0; i < allLinks.size(); i++)
		{
			Row row = sheet.createRow(i);
			Cell cel = row.createCell(0);
			cel.setCellValue(allLinks.get(i).getAttribute("href"));
		}
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData2pm.xlsx");
		book.write(fos);
		book.close();
	}

}
