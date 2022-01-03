package com.techarchive;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		glue = { "com.techarchive.cucumberReporting" },
        plugin = {"pretty",
                "html:target/report/cucumber.html",
                "json:target/report/cucumber.json"
        },
       // features = {"features"}
		features={"feature"}
      
     //  tags ="@tag4"\\{"com.techarchive.cucumberReporting"}
       
)

public class CukeRunner {
}