package org.epam.tests;


import static org.testng.Assert.assertTrue;

import org.epam.driver.CoreDriver;
import org.epam.pages.HomePage;
import org.epam.pages.LoginPage;
import org.epam.pages.RegisterPage;
import org.epam.pages.SelectablePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseTest extends CoreDriver {
	private final static String USERNAME = "sazid";
	private final static String PASSWORD = "neeascs";
	private final static String DEFAULTFUNVALUE = "Item 3";
	private final static String DISPLAYGRIDVALUE = "12";
	private final static String SERIALIZEVALUE = "Item 6";
	
	
	private HomePage homePage = null;
	private SelectablePage objSelectablePage = null;
	
	@BeforeClass
	public void Login()
	{
		RegisterPage registerPage = new RegisterPage(driver);
		LoginPage loginPage = registerPage.navigateToLogin();
		loginPage.login(USERNAME, PASSWORD);
	}
	
	@Test(priority =1)
	public void selectFromDefaultFuncList()
	{		
			homePage = new HomePage(driver);
			objSelectablePage = homePage.navigateToSelectablePage();			
			objSelectablePage.waitForPage();
			objSelectablePage.selectDefaultFunction(DEFAULTFUNVALUE);
			assertTrue(objSelectablePage.isItemSelected(DEFAULTFUNVALUE), "Item is selected from Default Function list");
		
	}
	
	@Test(priority =2)
	public void SelectFromDisplayGrid()
	{
		driver.switchTo().defaultContent();
		objSelectablePage.selectDefaultGrid(DISPLAYGRIDVALUE);
		assertTrue(objSelectablePage.isItemSelected(DISPLAYGRIDVALUE), "Item is selected from Display Grid Function list");
	}
	
	@Test(priority =3)
	public void selectFromSerializeList()
	{
		driver.switchTo().defaultContent();
		objSelectablePage.selectSerialize(SERIALIZEVALUE);
		assertTrue(objSelectablePage.isItemSelected(SERIALIZEVALUE), "Item is selected from Serializeble Function list");
	}

}
