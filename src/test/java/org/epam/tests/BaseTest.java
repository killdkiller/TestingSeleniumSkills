package org.epam.tests;


import org.epam.driver.CoreDriver;
import org.epam.pages.HomePage;
import org.epam.pages.LoginPage;
import org.epam.pages.RegisterPage;
import org.epam.pages.SelectablePage;
import org.testng.annotations.Test;

public class BaseTest extends CoreDriver {
	
	@Test
	public void selectFromList()
	{
		try
		{
			RegisterPage registerPage = new RegisterPage(driver);
			LoginPage loginPage = registerPage.navigateToLogin();
			loginPage.login("sazid", "neeascs");
					
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
