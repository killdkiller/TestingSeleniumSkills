package org.epam.pages;

import org.epam.driver.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath="//a[text()='Interaction']")
	private WebElement lnkInteraction;
	
	@FindBy(xpath = "//a[text()='Selectable']")
	private WebElement lnkSelectable;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToSelectablePage()
	{
		bMouseOverAndClick(lnkInteraction,lnkSelectable);
	}
	
	public void bMouseOverAndClick(WebElement ele1,WebElement ele2)
	{
		Actions objAction = new Actions(DriverSetup.getDriver());
		Action mouseOverAndClick = objAction.moveToElement(ele1).moveToElement(ele2).click().build();
		mouseOverAndClick.perform();
	}

}
