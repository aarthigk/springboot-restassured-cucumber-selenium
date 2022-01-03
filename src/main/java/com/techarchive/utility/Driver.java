package com.techarchive.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
	//WebDriver driver;
	
	public static void setDriver(WebDriver driver) {
	
	//   ChromeOptions options = new ChromeOptions();
	  // options.addArguments("--disable-notifications");
	   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
	   driver = new ChromeDriver();

	}
	
	public static void setUrl(WebDriver driver, String urls) {
		   driver.get("https://demo.nopcommerce.com/");
		}

}
