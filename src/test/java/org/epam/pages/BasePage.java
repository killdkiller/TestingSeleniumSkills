package org.epam.pages;

import org.epam.driver.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver = null;
	
	public void waitForElementVisible(WebElement webElement,int timeout)
	{
		WebDriverWait wait = (new WebDriverWait( driver,timeout));
		wait.until(ExpectedConditions.visibilityOf(webElement));
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
