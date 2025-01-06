package com.organization.vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrganizationInVTiger {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\eclipse-jee-2024-06-R-win32-x86_64\\eclipse\\advance_selenium\\src\\test\\resources\\Properties.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String BROWSER=pro.getProperty("browser");
		String URL=pro.getProperty("url");
		String USERNAME=pro.getProperty("username");
		String PASSWORD=pro.getProperty("password");
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.cssSelector("[name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		Random ran =  new Random();
		int ranNum = ran.nextInt(1000);
		FileInputStream fis1 = new FileInputStream("./src\\test\\resources\\add_selenium.xlsx");//C:\\eclipse-jee-2024-06-R-win32-x86_64\\eclipse\\advance_selenium\\
	    Workbook book= WorkbookFactory.create(fis1);
	  Sheet sheet = book.getSheet("Organization");
	 Row row = sheet.getRow(0);
	Cell cel = row.getCell(0);
	String orgName = cel.getStringCellValue()+ranNum;
	driver.findElement(By.name("accountname")).sendKeys(orgName);
	
	Row row1 = sheet.getRow(1);
	Cell cell1 = row.getCell(0);
	DataFormatter formatter = new DataFormatter();
	String phnNum = formatter.formatCellValue(cell1);
	driver.findElement(By.id("phoneNum")).sendKeys(phnNum);
	
	Row row2 = sheet.getRow(2);
	Cell cell2 = row.getCell(0);
	String email= formatter.formatCellValue(cell2);
	driver.findElement(By.id("email")).sendKeys(email);
	driver.findElement(By.xpath("2.16.1"))
	}
}
