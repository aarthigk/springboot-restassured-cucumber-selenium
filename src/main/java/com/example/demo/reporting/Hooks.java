package com.example.demo.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.example.demo.util.BrowserManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private final BrowserManager browserManager;

    public Hooks() {
        this.browserManager = new BrowserManager();
    }
    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extentReport;


    @Before
    public void beforeSuite() {
        // Set up resources or configurations for the entire suite
        System.out.println("Before Suite: Setting up suite-level resources");


    }


    @After
    public void afterSuite() {

        System.out.println("After Suite: Cleaning up suite-level resources");
    }


    @Before
    public void beforeScenario(Scenario scenario) {

        System.out.println("Before Scenario: Setting up scenario-level resources for " + scenario.getName());
   //     browserManager.setUpBrowser();
    }


    @After
    public void afterScenario(Scenario scenario) {

        System.out.println("After Scenario: Cleaning up scenario-level resources for " + scenario.getName());
        browserManager.quitBrowser();
    }

}
