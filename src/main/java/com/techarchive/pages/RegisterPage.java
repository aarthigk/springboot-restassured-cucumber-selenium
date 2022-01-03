package com.techarchive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class RegisterPage extends BasePage  {
	//WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//h1")
	WebElement heading;
	
	@FindBy(xpath="//span[@class='female']")
	WebElement gender;
	
	@FindBy(xpath="//input[@name='FirstName']")
	public WebElement firstName;
	
	@FindBy(xpath="//input[@name='LastName']")
	public WebElement lastName;
	
	@FindBy(xpath="//input[@name='Email']")
	public WebElement email;
	
	@FindBy(xpath="//input[@name='Company']")
	public WebElement company;
	
	@FindBy(xpath="//input[@name='Password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@name='ConfirmPassword']")
	public WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='NewsLetter']")
	WebElement news;
	
	@FindBy(xpath="//button[@name='register-button']")
	public WebElement regbutton;
	
	@FindBy(xpath="//select[@name='DateOfBirthDay']")
	WebElement day;
	
	@FindBy(xpath="//select[@name='DateOfBirthMonth']")
	WebElement mon;
	
	@FindBy(xpath="//select[@name='DateOfBirthYear']")
	WebElement year;
	
   @SuppressWarnings("deprecation")
   public void checkHeader() {
	   heading.isDisplayed();
   heading.getText().equals("Register");
	   Assert.assertEquals(heading.getText(), "Register");
	   
	  //  JavascriptExecutor js= (JavascriptExecutor)driver;
	    //js.executeScript("document.getElementById('id').value='Selenium'");
	    
	//    js.executeScript("window.scrollBy(0,150)");
	    
//	    Actions a= new Actions(driver);
//	    WebElement ab=driver.findElement(By.id("di"));
//	    
//	    a.contextClick(ab).perform();
//	    a.doubleClick(ab).perform();
//	   
   }
   
   public void chooseGender() {
	   gender.click();
   }
   
   public void setDateofBirth() {
	   Select d= new Select(day);
	   d.selectByValue("12");
	   
	   Select e= new Select(mon);
	  // e.selectByValue("11");
	   e.selectByVisibleText("November");
	   
	   Select f= new Select(year);
	   f.selectByValue("1999");
	   
	   System.out.println("date");
   }
   
   
}
