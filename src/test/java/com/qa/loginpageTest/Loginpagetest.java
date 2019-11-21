package com.qa.loginpageTest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspotq.basepageq.Basepage;
import com.qa.hubspotq.page.Loginpage;

public class Loginpagetest {
	
	Properties prop;
	WebDriver driver;
	Loginpage lp;
	
	
	
	@BeforeTest
	
	public void setup(){
		
		Basepage basepg = new Basepage();
		prop = basepg.Initializeconfig();
		String br = prop.getProperty("browser");
		driver = basepg.IntializeDriver(br);
		lp = new Loginpage(driver);
		driver.get(prop.getProperty("url"));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("Excep occur");
		}
		
	}
	
	@Test(priority = 1)
	public void tittletest() {
		Assert.assertEquals(lp.VerifyTittle(), "HubSpot Login");	
	}
	
	@Test (priority = 2)
	public void Signuplinkverification() {
		Assert.assertTrue(lp.SignUpLinkvisible());	
	}
	@Test (priority = 3)
	public void Dologincheck() {
		lp.dologincheck(prop.getProperty("usrnm"), prop.getProperty("paswd"));
	}
	
	
	@AfterTest(enabled = true)
	public void wrapup() {
		driver.close();
		driver.quit();
	}
	
	
	
	

}
