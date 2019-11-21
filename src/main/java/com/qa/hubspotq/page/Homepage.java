package com.qa.hubspotq.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspotq.basepageq.Basepage;
import com.qa.hubspotq.util.ElementUtil;

public class Homepage extends Basepage {
	
	WebDriver driver;
	ElementUtil el;
	
	
	
	By header = By.className("private-page__title");
	By AccountMenu = By.id("account-menu");
	By AccountName = By.className("user-info-name");
	By primaryContact = By.id("nav-primary-contacts-branch");
	By SecondaryContact = By.id("nav-secondary-contacts");
	
	
	public Homepage(WebDriver driver) {
	this.driver = driver;
	el = new ElementUtil(driver);
	}

	public String verifytitle () {
		
		return driver.getTitle();
		 
	}
	public boolean verifyHeaderispresent() {
		return driver.findElement(header).isDisplayed();
	}
	public String verifyHeader() {
		return driver.findElement(header).getText();
		
	}
	public String verifyAccountName() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(AccountMenu).click();
		Thread.sleep(5000);
		return driver.findElement(AccountName).getText();
		
	}
	public void getClickContacts(){
		
		driver.findElement(primaryContact).click();
		driver.findElement(SecondaryContact).click();	
	}
	public Contactpage getcontactpage() {
		
		getClickContacts();
		return new Contactpage(driver);
	}
	
}
