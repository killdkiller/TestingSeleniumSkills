package org.epam.pages;

import org.epam.driver.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	
	@FindBy(xpath="//a[text()='Interaction']")
	private WebElement lnkInteraction;
	
	@FindBy(xpath = "//a[text()='Selectable']")
	private WebElement lnkSelectable;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public SelectablePage navigateToSelectablePage()
	{
		 bMouseOverAndClick(lnkInteraction,lnkSelectable);
		 SelectablePage objSelectablePage = new SelectablePage(DriverSetup.getDriver());
		 return objSelectablePage;
	}
	
	public void bMouseOverAndClick(WebElement ele1,WebElement ele2)
	{
		Actions objAction = new Actions(driver);
		 objAction.moveToElement(ele1).build().perform();
		 waitForElementVisible(ele2, DriverSetup.IMAXTIME);
		 Action mouseOverAndClick = objAction.moveToElement(ele2).click().build();
		mouseOverAndClick.perform();
	}

}
