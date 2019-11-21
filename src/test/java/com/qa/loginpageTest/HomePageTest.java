package com.qa.loginpageTest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspotq.basepageq.Basepage;
import com.qa.hubspotq.page.Homepage;
import com.qa.hubspotq.page.Loginpage;
import com.qa.hubspotq.util.Constants;

public class HomePageTest {
	Properties prop;
	WebDriver driver;
	Loginpage lp;
	Homepage hp;
	
	@BeforeTest
	
	public void setup() throws InterruptedException{
		
		Basepage basepg = new Basepage();
		prop = basepg.Initializeconfig();
		String br = prop.getProperty("browser");
		driver = basepg.IntializeDriver(br);
		lp = new Loginpage(driver);
		driver.get(prop.getProperty("url"));
		Thread.sleep(5000);
		hp = lp.dologincheck(prop.getProperty("usrnm"), prop.getProperty("paswd"));
		Thread.sleep(10000);
	}
	
	@Test(priority = 1)
	public void verfiyassertTitle() {
		Assert.assertEquals(hp.verifytitle(), Constants.Homepage_tittle);
	}
	@Test(priority = 2)
	public void verifyassertHeader() {
		Assert.assertTrue(hp.verifyHeaderispresent());
		Assert.assertEquals(hp.verifyHeader(), Constants.Homepage_Header);
	}
	@Test(priority = 3)
	public void VerifyAccountDetails() throws InterruptedException  {
		Assert.assertEquals(hp.verifyAccountName(), prop.getProperty("acountname"));
		
	}
	@AfterTest
	public void TearDown() {
		
		driver.quit();
	}
	
	
}
