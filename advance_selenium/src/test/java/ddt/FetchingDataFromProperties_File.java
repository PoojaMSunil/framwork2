package ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FetchingDataFromProperties_File {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream("C:\\eclipse-jee-2024-06-R-win32-x86_64\\eclipse\\advance_selenium\\src\\test\\resources\\Properties.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String BROWSER = prop.getProperty("chrome");
		String URL = prop.getProperty("browser");
		String USERNAME = prop.getProperty("browser");
		String PASSWORD = prop.getProperty("browser");
		
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new ChromeDriver();
		}
		driver.get(URL);
		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(USERNAME);
		/*driver.findElement(http://By.name("user_password")).sendKeys(PASSWORD);
	//	driver.findElement*///(http://By.id("submitButton")).click();
	}

}
