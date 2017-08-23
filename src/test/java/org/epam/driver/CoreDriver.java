package org.epam.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class CoreDriver {
	protected WebDriver driver ;
	@BeforeClass
	@Parameters({"url","browserName"})
	public void initializeDriver(String url,String browserName)
	{
		try{
			DriverSetup.launchDriver(browserName);
			driver = DriverSetup.getDriver();
			driver.manage().timeouts().pageLoadTimeout(DriverSetup.IMAXTIME, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(DriverSetup.IMAXTIME, TimeUnit.SECONDS);
			DriverSetup.navigateToUrl(url);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@AfterClass
	public void closeDriver()
	{
		DriverSetup.tearUp();
	}

}
