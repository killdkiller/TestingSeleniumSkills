package org.epam.pages;

import org.epam.driver.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		 waitForElementVisible(lnkInteraction, DriverSetup.IMAXTIME);
		 bMouseOverAndClick(lnkInteraction,lnkSelectable);
		 SelectablePage objSelectablePage = new SelectablePage(driver);
		 return objSelectablePage;
	}

}
