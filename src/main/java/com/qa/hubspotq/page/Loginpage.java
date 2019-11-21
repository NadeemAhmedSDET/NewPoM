package com.qa.hubspotq.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspotq.basepageq.Basepage;
import com.qa.hubspotq.util.Constants;
import com.qa.hubspotq.util.ElementUtil;



public class Loginpage extends Basepage {
	
	WebDriver driver;
	Homepage homepage;
	ElementUtil el;
	//1. we create a locator of the particular login page

	By email = By.id("username");
	By paswd = By.id("password");
	By signuplink = By.linkText("Sign up");
	By submit = By.id("loginBtn");
	
	
	//2. We need to create aConstructor of this particular class
	
	public Loginpage (WebDriver driver) {
		this.driver = driver;
		 el = new ElementUtil(driver);
		}
	
	//3. Create a page Action
	
	public String VerifyTittle() {
		
		return el.getTittleExplicit(Constants.Loginpage_tittle, 20);
		
		 
		}
	
	public boolean SignUpLinkvisible() {
		
	return driver.findElement(signuplink).isDisplayed();
		
}
	
	public Homepage dologincheck(String un, String pd) {
		el.explicitWait(email, 20);
		el.sendKeys(email, un);
		el.sendKeys(paswd, pd);
		el.doClick(submit);
		
		return new Homepage(driver);
		
		
		}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
