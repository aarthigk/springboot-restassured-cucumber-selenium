package com.example.demo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);
    private final WebDriver driver;
    private final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10).toMillis()); // Replaces Thread.sleep()
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='FPdoLc lJ9FBc']/center/input[@class='gNO89b']")
    private WebElement googleSearch;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(id = "APjFqb")
    private WebElement textArea;

    @FindBy(id = "L2AGLb")
    private WebElement acceptCookiesButton;

    public void navigateToGoogle(String engine) {
        try {
            driver.get(engine);
            wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton)).click();
            logger.info("Navigated to {}", engine);
        } catch (Exception e) {
            logger.error("Error navigating to Google: ", e);
        }
    }

    public void performAction() {
        try {
            wait.until(ExpectedConditions.visibilityOf(textArea)).sendKeys("Hello");
            googleSearch.submit();
            logger.info("Performed search action.");
        } catch (Exception e) {
            logger.error("Error performing action: ", e);
        }
    }
}

