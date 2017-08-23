package org.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectablePage {
	
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
		PageFactory.initElements(driver, this);
	}

}
