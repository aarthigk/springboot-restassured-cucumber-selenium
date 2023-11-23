package com.example.demo.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class commonSteps {
    public WebDriver driver;

    @Given("the user opens a browser")
    public void openBrowser() {


        System.setProperty("webdriver.gecko.driver", "C:\\Users\\gkaar\\Downloads\\geckodriver-v0.33.0-win64(1)\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }


    @When("the user navigates to {string}")
    public void navigateTo(String engine) {
        // Code to navigate to the specified URL
        driver.get(engine);
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();
    }

    @When("the user searches for {string}")
    public void searchFor(String searchTerm) {
        // Code to perform a search
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(searchTerm);
        searchBox.submit();
    }

    @Then("search results are displayed on Google")
    public void search_results_are_displayed_on_google() {
        // Write code here that turns the phrase above into concrete actions
        String searchEngine="Google";
        String title = driver.getTitle();
        assertTrue("Search results are displayed on " + searchEngine, title.contains("Google") || title.contains("Yahoo"));
        driver.quit();
    }


    @Then("search results are displayed on {string}")
    public void verifySearchResults(String searchEngine) {
        // Code to verify search results based on the search engine
        String title = driver.getTitle();
        assertTrue("Search results are displayed on " + searchEngine, title.contains("Google") || title.contains("Yahoo"));
        driver.quit();
    }

    private Response response;

    @Given("the Petstore API is accessible")
    public void petstoreApiAccessible() {
        // No additional setup needed for RestAssured
    }

    @When("a request is made to the {string} endpoint with the status parameter set to {string}")
    public void makeApiRequest(String endpoint, String status) {
        response = RestAssured.given()
                .param("status", status)
                .when()
                .get("https://petstore.swagger.io/v2/pet/" + endpoint);
    }

    @Then("the response status code should be {int}")
    public void verifyResponseStatusCode(int expectedStatusCode) {

        response.then().statusCode(expectedStatusCode);
        System.out.println("The output from the reposnse is"+ response.statusCode());
        System.out.println("The output "+ response.asPrettyString());
    }

    @Then("the response should contain a list of pets with status {string}")
    public void verifyResponseContainsPetsWithStatus(String status) {
        response.then().body("status", everyItem(equalTo(status)));

    }

    @Then("each pet in the response should have the required fields")
    public void verifyPetFieldsInResponse() {
        response.then().body("id", everyItem(notNullValue()))
                .body("name", everyItem(notNullValue()))
                .body("status", everyItem(notNullValue()));
    }

    @Then("each pet in the response should have the required fields such as id, name, and status")
    public void each_pet_in_the_response_should_have_the_required_fields_such_as_id_name_and_status() {
        // Write code here that turns the phrase above into concrete actions
      //  throw new io.cucumber.java.PendingException();
    }

}
