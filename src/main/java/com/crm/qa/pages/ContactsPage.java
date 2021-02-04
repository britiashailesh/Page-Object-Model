package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//div[text()='Contacts']")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//span[@class='user-display']")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//input[@class='search']")
	WebElement company;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveBtn;
	
	
	
	// Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactsLabel(){

		return contactsLabel.isDisplayed();
	}
	
	
	public void selectContactsByName(String name) {

		////a[text()='dev yadav']//parent::td//preceding-sibling::td//input[@type='checkbox']
		WebElement userCheckBox= driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//input[@type='checkbox']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", userCheckBox);

	}
	
	
	public void createNewContact(String ftName, String ltName, String comp){
		/*
		 * Select select = new Select(driver.findElement(By.name("title")));
		 * select.selectByVisibleText(title);
		 */
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
		
	}
	
	
	

}
