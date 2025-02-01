package com.example.demo.steps;
import com.example.demo.api.PetstoreApi;
import com.example.demo.base.TestBase;
import com.example.demo.page.HomePage;
import com.example.demo.util.BrowserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;


public class CommonSteps extends TestBase {
    private HomePage homePage;
    private final BrowserManager browserManager;
    private final PetstoreApi petstoreApi;
    private static final Logger logger = LoggerFactory.getLogger(CommonSteps.class);
    private Response response;

    public CommonSteps() {
        this.browserManager = new BrowserManager();
        this.petstoreApi = new PetstoreApi();
    }

    @Given("the user opens a browser")
    public void openBrowser() {
        browserManager.setUpBrowser();
    }

    @When("the user navigates to {string}")
    public void navigateTo(String url) {
        homePage = new HomePage(getDriver());
        homePage.navigateToGoogle(url);
    }

    @Given("the Petstore API is accessible")
    public void petstoreApiAccessible() {
        logger.info("Petstore API is accessible");
    }

    @When("a request is made to the {string} endpoint with the status parameter set to {string}")
    public void makeApiRequest(String endpoint, String status) {
        response = petstoreApi.getPetsByStatus(endpoint, status);
    }

    @Then("the response status code should be {int}")
    public void verifyResponseStatusCode(int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
        logger.info("Response: " + response.asPrettyString());
    }

    @Then("the response should contain a list of pets with status {string}")
    public void verifyResponseContainsPetsWithStatus(String status) {
        response.then().body("status", everyItem(equalTo(status)));
    }


    @Then("each pet in the response should have the required fields such as id, name, and status")
    public void verifyPetFieldsInResponse() {
        response.then().body("id", everyItem(notNullValue()))
                .body("name", everyItem(notNullValue()))
                .body("status", everyItem(notNullValue()));
    }


    @Then("user should see an {string}")
    public void user_should_see_an(String string) {

    }

}
