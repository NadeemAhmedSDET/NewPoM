package com.qa.hubspotq.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspotq.basepageq.Basepage;
import com.qa.hubspotq.util.Constants;
import com.qa.hubspotq.util.ElementUtil;

public class Contactpage extends Basepage {
	WebDriver driver;
	Contactpage cp;
	ElementUtil el;
	
	
	
	By crcontactbtn = By.xpath("(//span[contains(text(),'Create contact')])[1]");
	By email = By.xpath("//input[@data-field ='email']");
	By fname = By.xpath("//input[@data-field ='firstname']");
	By lname = By.xpath("//input[@data-field ='lastname']");
	By Jtitle = By.xpath("//input[@data-field ='jobtitle']");
	By SubmitBtn = By.xpath("(//span[contains(text(),'Create contact')])[2]");
	
	
	public Contactpage(WebDriver driver) {
		this.driver = driver;
		el = new ElementUtil(driver);
		
		
		
	}
	public String verifytitle() {
		
		return el.getTittleExplicit(Constants.Contactpage_tittle, 15);
	}
	public void fillform(String emailid, String firstname, String lastname, String JobTittle) {
		el.explicitWait(crcontactbtn, 20);
		el.doClick(crcontactbtn);
		
		el.explicitWait(email, 20);
		el.sendKeys(email, emailid);
		
		el.explicitWait(fname, 20);
		el.sendKeys(fname, firstname);
		
		el.explicitWait(lname, 20);
		el.sendKeys(lname, lastname);
		
		el.explicitWait(Jtitle, 20);
		el.sendKeys(Jtitle, JobTittle);
		
		el.explicitWait(SubmitBtn, 20);
		el.doActionsClick(SubmitBtn);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
