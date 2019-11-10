package selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Challenge2_1 {
	ChromeDriver driver = new ChromeDriver();

	@Test
	public void certification() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/sravani/Downloads/ChromeDriver76/chromedriver");
		driver.get("https://agiletestingalliance.org");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Certifications')]")).click();
		//// area[@target="_self"]
		int count = driver.findElements(By.xpath("//area[@target='_self']")).size();
		System.out.println(count);
		for (int i = 0; i <= 12; i++) {
			String url = driver.findElements(By.xpath("//area[@target='_self']")).get(i).getAttribute("href");
			System.out.println(url);
			
		}
	}

	@Test

	public void screenshot() throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebElement target = driver.findElement(By.xpath("//area[@alt='CP-CCT']"));	
		action.moveToElement(target).perform();
		Thread.sleep(2000);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(src,new File(".//companydetailsscreenshot//"+"cp-cct.png"));
	
		
		

	}
}
