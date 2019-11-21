package com.qa.loginpageTest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspotq.basepageq.Basepage;
import com.qa.hubspotq.page.Contactpage;
import com.qa.hubspotq.page.Homepage;
import com.qa.hubspotq.page.Loginpage;
import com.qa.hubspotq.util.Constants;
import com.qa.hubspotq.util.Excelutility;

public class ContactTest {
	Properties prop;
	WebDriver driver;
	Loginpage lp;
	Homepage hp;
	Contactpage cp;
	
	
	@BeforeMethod
	
	public void setup() throws InterruptedException{
		
		Basepage basepg = new Basepage();
		prop = basepg.Initializeconfig();
		String br = prop.getProperty("browser");
		driver = basepg.IntializeDriver(br);
		lp = new Loginpage(driver);
		driver.get(prop.getProperty("url"));
		
		hp = lp.dologincheck(prop.getProperty("usrnm"), prop.getProperty("paswd"));
		Thread.sleep(10000);
		cp = hp.getcontactpage();
		Thread.sleep(10000);
		
	}
	@Test(priority =1)
	public void verifycontactpageTitle() {
		Assert.assertEquals(cp.verifytitle(), Constants.Contactpage_tittle );
	}
	@DataProvider
	public Object[][] getdatafromexcel() {
		return  Excelutility.getexceldata(Constants.Contactpage_data_Sheet);
	}
	
	
	
	
	@Test(priority =2 , dataProvider = "getdatafromexcel")
	public void Fillform(String email, String firstname, String lastname, String jobtitle)  {
		cp.fillform(email, firstname, lastname, jobtitle);
		
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
	
	
}
