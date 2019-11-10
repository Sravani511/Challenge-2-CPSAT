package selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Challenge2_3 {
	ChromeDriver driver = new ChromeDriver();
	@Test
	public void searchAction() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "/home/sravani/Downloads/ChromeDriver76/chromedriver");
		driver.get("https://www.nseindia.com");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		//input[@id="keyword"]
		driver.findElement(By.xpath("//input[@id='keyword']")).sendKeys("Eicher Motors Limited");
		Thread.sleep(2000);
		System.out.println("---");
		driver.findElement(By.xpath("//input[@id='keyword']")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(src,new File(".//companydetailsscreenshot//"+"Eicher Motors Limited.png"));
		System.out.println("Screenshot");
		String facevalue = driver.findElement(By.xpath("//span[@id='faceValue']")).getText();
	    System.out.println(facevalue);
	    String weekhigh =driver.findElement(By.xpath("//span[@id='high52']")).getText();
	    System.out.println(weekhigh);
	    String weeklow = driver.findElement(By.xpath("//span[@id='low52']")).getText();
	    System.out.println(weeklow);
	    driver.close();
	}

}
