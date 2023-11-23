package com.example.demo.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    // This method runs before the entire test suite
    @Before
    public void beforeSuite() {
        // Set up resources or configurations for the entire suite
        System.out.println("Before Suite: Setting up suite-level resources");
    }

    // This method runs after the entire test suite
    @After
    public void afterSuite() {
        // Clean up or perform final actions after the entire suite
        System.out.println("After Suite: Cleaning up suite-level resources");
    }

    // This method runs before each scenario
    @Before
    public void beforeScenario(Scenario scenario) {
        // Set up resources or configurations specific to each scenario
        System.out.println("Before Scenario: Setting up scenario-level resources for " + scenario.getName());
    }

    // This method runs after each scenario
    @After
    public void afterScenario(Scenario scenario) {
        // Clean up or perform final actions after each scenario
        System.out.println("After Scenario: Cleaning up scenario-level resources for " + scenario.getName());
    }

    // Additional methods for other hooks or custom setup/teardown actions
}
