package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[@class='user-display']")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[@href='/contacts']/following-sibling::button[@class='ui mini basic icon button']")
	WebElement newContactLink;
	

	@FindBy(xpath = "//span[text()='Deals']")
	WebElement dealsLink;

	@FindBy(xpath = "//span[text()='Tasks']")
	WebElement tasksLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public String verifyCorrectUserName(){
		if(userNameLabel.isDisplayed())
		{
			return userNameLabel.getText();
		}
		else
			return "User name is not displayed after login";
	}
	
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}
	
	
	
	
	
	
	

}
