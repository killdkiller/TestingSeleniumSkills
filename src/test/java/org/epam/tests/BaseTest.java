package org.epam.tests;


import static org.testng.Assert.assertTrue;

import org.epam.driver.CoreDriver;
import org.epam.pages.HomePage;
import org.epam.pages.LoginPage;
import org.epam.pages.RegisterPage;
import org.epam.pages.SelectablePage;
import org.testng.annotations.Test;

public class BaseTest extends CoreDriver {
	private final static String USERNAME = "sazid";
	private final static String PASSWORD = "neeascs";
	private final static String DEFAULTFUNVALUE = "Item 3";
	
	@Test
	public void selectFromList()
	{
		try
		{
			RegisterPage registerPage = new RegisterPage(driver);
			LoginPage loginPage = registerPage.navigateToLogin();
			loginPage.login(USERNAME, PASSWORD);
					
			HomePage homePage = new HomePage(driver);
			SelectablePage objSelectablePage = homePage.navigateToSelectablePage();			
			objSelectablePage.waitForPage();
			objSelectablePage.selectDefaultFunction(DEFAULTFUNVALUE);
			assertTrue(objSelectablePage.isDefaultFunctionItemSelected(DEFAULTFUNVALUE), "Item is selected from Default Function list");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
