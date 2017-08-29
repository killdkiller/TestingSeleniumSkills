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
	private WebElement lstSelectable;
	
	@FindBy(xpath = "//a[text()='Display as grid']")
	private WebElement lnkDisplayGrid;
	
	@FindBy(xpath = "//a[text()='Serialize']")
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
		fnNavigateToEnabledFrame();
		driver.findElement(By.xpath(String.format(DYNLISTITEM, visibleText))).click();
		driver.switchTo().defaultContent();
	}
	
	public void selectDefaultGrid(String visibleText)
	{
		waitForElementVisible(lnkDisplayGrid, DriverSetup.IMAXTIME);
		lnkDisplayGrid.click();
		fnNavigateToEnabledFrame();
		driver.findElement(By.xpath(String.format(DYNLISTITEM, visibleText))).click();
		driver.switchTo().defaultContent();
	}
	
	public void selectSerialize(String visibleText)
	{
		waitForElementVisible(lnkSerialize, DriverSetup.IMAXTIME);
		lnkSerialize.click();
		fnNavigateToEnabledFrame();
		driver.findElement(By.xpath(String.format(DYNLISTITEM, visibleText))).click();
		driver.switchTo().defaultContent();
	}
	
	public boolean isItemSelected(String visibleText)
	{
		boolean blnResult = false;
		fnNavigateToEnabledFrame();
		if(SELECTEDCOLOR.equalsIgnoreCase(driver.findElement(By.xpath(String.format(DYNLISTITEM, visibleText))).getCssValue("background-color")))
		{
			blnResult = true;
		}
		driver.switchTo().defaultContent();
		return blnResult;
	}
	
	public void fnNavigateToEnabledFrame()
	{
		int totFrames = driver.findElements(By.tagName("iFrame")).size();
		for(int i=0;i<totFrames;i++)
		{
			driver.switchTo().frame(i);
			if(lstSelectable.isEnabled())
			{
				System.out.println("Present at Index :"+i);
				//break;
			}
			driver.switchTo().defaultContent();
		}
	}
	
	

}
