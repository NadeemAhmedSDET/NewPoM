package com.qa.hubspotq.basepageq;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basepage {
	WebDriver driver;
	Properties prop;
	
	public WebDriver IntializeDriver(String BrowserName) {
		if (BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","F:/KT/chromedriver/chromedriver.exe" );
			 driver = new ChromeDriver();
			}
		else if (BrowserName.equals("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			}
		else {
			System.out.println("The Passed Browser is not being handled");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	return driver;
	}
	
	public Properties Initializeconfig() {
		
		 prop = new Properties();
		 
		 try {
			FileInputStream ip = new FileInputStream("F:\\JavaParctice\\AnkPOMSession\\src\\main\\java\\com\\qa\\hubspotq\\configq\\config.properties");
			prop.load(ip);
		}catch (FileNotFoundException e) {
			
			System.out.println("the config properties file is not found");
		} 
		 catch (IOException e) {
			System.out.println("File could not be loaded ");
		}
		 
	return prop;	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
