package org.epam.tests;

import org.epam.driver.CoreDriver;
import org.epam.pages.HomePage;
import org.epam.pages.SelectablePage;
import org.testng.annotations.Test;

public class BaseTest extends CoreDriver {
	
	@Test
	public void selectFromList()
	{
		try
		{
			HomePage homePage = new HomePage(driver);
			SelectablePage objSelectablePage = homePage.navigateToSelectablePage();
			objSelectablePage.waitForPage();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
