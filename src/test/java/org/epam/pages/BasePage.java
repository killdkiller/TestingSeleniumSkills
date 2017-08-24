package org.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver = null;
	
	public void waitForElementVisible(WebElement webElement,int timeout)
	{
		WebDriverWait wait = (new WebDriverWait( driver,timeout));
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

}
