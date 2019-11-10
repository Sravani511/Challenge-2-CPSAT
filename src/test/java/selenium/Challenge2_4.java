package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class Challenge2_4 {
	ChromeDriver driver = new ChromeDriver();
	@Test
	public void retrivingCompanyNames() throws InterruptedException, FileNotFoundException, IOException
	{

		System.setProperty("webdriver.chrome.driver", "/home/sravani/Downloads/ChromeDriver76/chromedriver");
		driver.get("https://www.nseindia.com");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		File file = new File("./Challenge2_4.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"); 
		// Date d = new Date();
	     //System.out.println(d.toString());
		for(int i=0;i<=3;i++)
		{ 
			Date d = new Date();
			String  firstelement = row.getCell(i).getStringCellValue();
			System.out.println(firstelement);
			driver.findElement(By.xpath("//input[@id='keyword']")).sendKeys(firstelement);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='keyword']")).sendKeys(Keys.ENTER);
			Thread.sleep(4000);
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    Files.copy(source, new File(".//companydetailsscreenshot//"+sdf.format(d)+"companydetailspage.jpg"));
			String facevalue = driver.findElement(By.xpath("//span[@id='faceValue']")).getText();
		    System.out.println(facevalue);
		    String weekhigh =driver.findElement(By.xpath("//span[@id='high52']")).getText();
		    System.out.println(weekhigh);
		    String weeklow = driver.findElement(By.xpath("//span[@id='low52']")).getText();
		    System.out.println(weeklow);
		    driver.findElement(By.xpath("//input[@id='keyword']")).clear();
		    }
		
		driver.close();
		
		
		}
	

}
