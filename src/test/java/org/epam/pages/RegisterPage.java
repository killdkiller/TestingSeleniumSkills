package org.epam.pages;

import java.util.Set;

import org.epam.driver.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage {

	@FindBy(xpath = "//input[@value='register']//ancestor::form[@id='load_form']//a[text()='Signin']")
	private WebElement lnkSignIn;
	
	@FindBy(xpath = "//a[text()='Registration']")
	private WebElement lnkRegistration;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean lnkSignInExists()
	{
		boolean blnStatus =true;
		try{
			lnkSignIn.isEnabled();
			
		}catch(Exception e)
		{
			blnStatus = false;
		}
		return blnStatus;
	}
	
	public LoginPage clickSigIn()
	{
		waitForElementVisible(lnkSignIn, DriverSetup.IMAXTIME);
		lnkSignIn.click();
		LoginPage loginPage = new LoginPage(driver);
		return loginPage;
	}
	
	public LoginPage navigateToLogin()
	{
		LoginPage loginPage = null;
		waitForElementVisible(lnkRegistration, DriverSetup.IMAXTIME);
		String currentWindow =driver.getWindowHandle();
		lnkRegistration.click();
		Set<String> handlesList = driver.getWindowHandles();
		String otherHandle = "";
		for(String handle:handlesList )
		{
			if((handle.equalsIgnoreCase(currentWindow)))
			{
				driver.switchTo().window(handle);
				driver.close();
			}
			else
			{
				otherHandle = handle;
			}
		}
		driver.switchTo().window(otherHandle);
		
		if(this.lnkSignInExists())
		{
			loginPage = clickSigIn();
		}
		return loginPage;
	}
}
