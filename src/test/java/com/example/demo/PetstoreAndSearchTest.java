package com.example.demo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = {"com.example.demo.steps","com.example.demo.reporting"}, // Add the package with the context configuration
        plugin = { "pretty", "html:target/cucumber-reports.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},// ,"extentreports:target/extent-report.html"},
        monochrome = true
      //  listeners = {TestReportListener.class}

)
public class PetstoreAndSearchTest {

}
