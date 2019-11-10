package selenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Challenge2_2 {
   List<Integer>l;
	ChromeDriver driver = new ChromeDriver();
@Test
	public void marketWatch() throws InterruptedException
	{
	l=new ArrayList<Integer>();
		System.setProperty("webdriver.chrome.driver", "/home/sravani/Downloads/ChromeDriver76/chromedriver");
		driver.get("https://www.nseindia.com");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		//class="green
        //Collections.sort(list, Collections.reverseOrder()); 
		
          l.add(Integer.parseInt(driver.findElement(By.xpath("//li[@class='green']//span")).getText()));
        l.add(Integer.parseInt(driver.findElement(By.xpath("//li[@class='red']//span")).getText()));
        l.add(Integer.parseInt(driver.findElement(By.xpath("//li[@class='greey']//span")).getText()));

        Collections.sort(l);
        System.out.println(l);
        System.out.println("Unchanged Value"+l.get(0));

		
		
	}
}
