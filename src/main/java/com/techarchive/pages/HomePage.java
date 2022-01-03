package com.techarchive.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	//WebDriver driver;
	
	public HomePage( WebDriver driver) {
		//this.driver=driver;
		super(driver);
		//PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText="Register")
	WebElement registerLink;



	public void clickRegisterLink() {
		registerLink.click();
	}
	
	

}
