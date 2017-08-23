package org.epam.driver;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverSetup {
	private static WebDriver driver ;
	public static final int IMINTIME = 10;
	public static final int IMAXTIME = 30;
	public static final int IMIDTIME = 20;
	
	public static void launchDriver(String browserName)
	{
		if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "src\\test\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
			driver =  new ChromeDriver();
		}
	}
	
	public static void navigateToUrl(String url)
	{
		driver.get(url);
		//driver.findElement(By.tagName("body")).sendKeys(Keys.F11);
		//driver.manage().window().fullscreen();
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static void tearUp()
	{
		if(driver !=null)
		{
			driver.close();
			driver.quit();
			driver = null;
		}
	}

}
