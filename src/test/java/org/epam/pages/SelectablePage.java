package org.epam.pages;

import org.epam.driver.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectablePage extends BasePage {
		
	@FindBy(xpath = "//a[text()='Default functionality']")
	private WebElement lnkDefaultFunctionality; 
	
	@FindBy(id = "selectable")
	private WebElement lstDefaultFunctionality;
	
	@FindBy(xpath = "//a[text()='//a[text()='Display as grid']']")
	private WebElement lnkDisplayGrid;
	
	@FindBy(id = "")
	private WebElement lstDisplayGrid;
	
	public SelectablePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForPage()
	{
		waitForElementVisible(lnkDefaultFunctionality,DriverSetup.IMAXTIME);
	}
	
	

}
