package demo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScreenShortEx {

	
	// eng2
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");
		/*
		 * By search = By.name("search_query"); WebElement element =
		 * driver.findElement(search); element.sendKeys("selenium with java");
		 */
		driver.findElement(By.name("search_query")).sendKeys("selenium with java");
		driver.findElement(By.className("yt-icon-shape yt-spec-icon-shape")).click();
		TakesScreenshot tS =(TakesScreenshot)driver;
		File srcFile = tS.getScreenshotAs(OutputType.FILE);
		File desc = new File("./ScreenShortImgs.png");
		FileUtils.copyFile(srcFile, desc);
		driver.close();
		
	}
	

}
