package org.epam.pages;

import org.epam.driver.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	@FindBy(xpath="//input[@value='login']//ancestor::form//input[@name='username']")
	private WebElement txtUserName;
	
	@FindBy(xpath = "//input[@value='login']//ancestor::form//input[@name='password']")
	private WebElement txtPassword;
	
	@FindBy(xpath ="//input[@value='login']//ancestor::form//input[@value='Submit']")
	private WebElement btnSubmit;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String strUserName,String strPassword)
	{
		waitForElementVisible(txtUserName, DriverSetup.IMAXTIME);
		txtUserName.sendKeys(strUserName);
		waitForElementVisible(txtPassword, DriverSetup.IMAXTIME);
		txtPassword.sendKeys(strPassword);
		waitForElementVisible(btnSubmit, DriverSetup.IMAXTIME);
		btnSubmit.click();
	}

}
