package org.epam.tests;

import org.epam.driver.CoreDriver;
import org.epam.pages.HomePage;
import org.testng.annotations.Test;

public class BaseTest extends CoreDriver {
	
	@Test
	public void selectFromList()
	{
		try
		{
			HomePage homePage = new HomePage(driver);
			homePage.navigateToSelectablePage();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
