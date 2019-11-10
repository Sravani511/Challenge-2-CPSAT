package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
	
	public static WebDriver driver(String h) {
		try {
		if(h.equalsIgnoreCase("chome")) {
			System.setProperty("webdriver.chrome.driver", "/home/sravani/Downloads/ChromeDriver76/chromedriver");
			WebDriver d=new ChromeDriver();
			d.manage().window().maximize();
			// chrome.findElement(By.id("advertClose")).click();
			Thread.sleep(2000);
			return d;
			
		}
		else {
			System.setProperty("webdriver.gecko.driver","home/sravani/Downloads/geckodriver");
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "src/main/resources/fireFox.txt");
           
           WebDriver d = new FirefoxDriver();
           return d;
		}
		
	}
		catch(Exception j) {
			j.printStackTrace();
			return null;
			}
		}

}
