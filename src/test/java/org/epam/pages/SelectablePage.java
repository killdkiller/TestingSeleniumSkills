package org.epam.pages;

import org.epam.driver.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectablePage extends BasePage {
	
	private static final String DYNLISTITEM = "//*[text()='%s']";
	private static final String SELECTEDCOLOR = "rgba(243, 152, 20, 1)";
	
	@FindBy(xpath = "//a[text()='Default functionality']")
	private WebElement lnkDefaultFunctionality; 
	
	@FindBy(id = "selectable")
	private WebElement lstDefaultFunctionality;
	
	@FindBy(xpath = "//a[text()='//a[text()='Display as grid']']")
	private WebElement lnkDisplayGrid;
	
	@FindBy(id = "//a[text()='Serialize']")
	private WebElement lnkSerialize;
	
	public SelectablePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForPage()
	{
		waitForElementVisible(lnkDefaultFunctionality,DriverSetup.IMAXTIME);
	}
	
	public void selectDefaultFunction(String visibleText)
	{
		waitForElementVisible(lnkDefaultFunctionality, DriverSetup.IMAXTIME);
		lnkDefaultFunctionality.click();
		int totFrames = driver.findElements(By.tagName("iFrame")).size();
		for(int i=0;i<totFrames;i++)
		{
			driver.switchTo().frame(i);
			if(lstDefaultFunctionality.isEnabled())
			{
				break;
			}
		}
		driver.findElement(By.xpath(String.format(DYNLISTITEM, visibleText))).click();
		driver.switchTo().defaultContent();
	}
	
	public boolean isDefaultFunctionItemSelected(String visibleText)
	{
		boolean blnResult = false;
		waitForElementVisible(lnkDefaultFunctionality, DriverSetup.IMAXTIME);
		lnkDefaultFunctionality.click();
		int totFrames = driver.findElements(By.tagName("iFrame")).size();
		for(int i=0;i<totFrames;i++)
		{
			driver.switchTo().frame(i);
			if(lstDefaultFunctionality.isEnabled())
			{
				break;
			}
		}
		if(SELECTEDCOLOR.equalsIgnoreCase(driver.findElement(By.xpath(String.format(DYNLISTITEM, visibleText))).getCssValue("background-color")))
		{
			blnResult = true;
		}
		return blnResult;
	}

}
