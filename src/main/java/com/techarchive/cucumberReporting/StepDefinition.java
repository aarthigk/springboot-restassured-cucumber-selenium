package com.techarchive.cucumberReporting;


import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
//import cucumber.api.java.en.Given;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import com.techarchive.pages.HomePage;
import com.techarchive.pages.RegisterPage;
import com.techarchive.utility.*;
@SuppressWarnings("deprecation")
public class StepDefinition extends ApiDefinitions {
	
	HomePage homepage;
	RegisterPage registerPage;
	
	private static final String USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
	private static final String USERNAME = "TOOLSQA-Test";
	private static final String PASSWORD = "Test@@123";
	private static final String BASE_URL = "https://bookstore.toolsqa.com";
	private static final String APP_URL = "https://bookstore.toolsqa.com";

	private static String token;
	private static Response response;
	private static String jsonString;
	private static String bookId;
	
	WebDriver driver;
	
	@Given("I want to launch google")
	public void i_want_to_launch_google() {
	    // Write code here that turns the phrase above into concrete actions
	   ChromeOptions options = new ChromeOptions();
	   options.addArguments("--disable-notifications");
	   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
	   driver = new ChromeDriver(options);
	   driver.get("https://youtube.com");
	   driver.close();
	}
	@Given("user navigates to nopcommerce site")
	public void user_navigates_to_nopcommerce_site() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		   driver = new ChromeDriver();
		   driver.get("https://demo.nopcommerce.com/");
		
	}

	@Given("user clicks register link")
	public void user_clicks_register_link() {
			homepage = new HomePage(driver);
			homepage.clickRegisterLink();
	}

	@Then("user sees register page")
	public void user_sees_register_page() {
		registerPage = new RegisterPage(driver);
		registerPage.checkHeader();
	}

	@Then("the user chooses gender")
	public void the_user_chooses_gender() {
		registerPage.chooseGender();
		
	}

	@When("user enters the following details in register page")
	public void user_enters_the_following_details_in_register_page(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		 List<Map<String, String>> data = dataTable.asMaps(String.class,String.class);
		 registerPage.firstName.sendKeys("Testerb");
		 registerPage.lastName.sendKeys("Btest");
		 registerPage.email.sendKeys("btest@test.com");
	     System.out.println(data.get(1).get(1));
	     
	}

	@When("the user chooses {string},{string},and {string} in date of birth dropdown")
	public void the_user_chooses_and_in_date_of_birth_dropdown(String string, String string2, String string3) {
	    // Write code here that turns the phrase above into concrete actions
		registerPage.setDateofBirth();
		
		
	}

	@Then("the user fills the company details,your password and confirm password")
	public void the_user_fills_the_company_details_your_password_and_confirm_password() {
	    // Write code here that turns the phrase above into concrete actions
		registerPage.company.sendKeys("MMM");
		registerPage.password.sendKeys("password");
		registerPage.confirmPassword.sendKeys("password");
	}

	@Then("the user unchecks the options chekcbox")
	public void the_user_unchecks_the_options_chekcbox() {
	    // Write code here that turns the phrase above into concrete actions
	 
	}

	@When("the user clicks the register button")
	public void the_user_clicks_the_register_button() {
	    // Write code here that turns the phrase above into concrete actions
		registerPage.regbutton.click();
	}

	@Then("the user see {string} message")
	public void the_user_see_message(String string) {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	
	@Given("I am an authorized user")
	public void i_am_an_authorized_user() {
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");
		response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
				.post("/Account/v1/GenerateToken");

		String jsonString = response.asString();
		token = JsonPath.from(jsonString).get("token");
	}




	@Given("A list of books are available")
	public void a_list_of_books_are_available() {
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		response = request.get("/BookStore/v1/Books");

		jsonString = response.asString();
		List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
		Assert.assertTrue(books.size() > 0);

		bookId = books.get(0).get("isbn");
	}
	@When("I add a book to my reading list")
	public void i_add_a_book_to_my_reading_list() {
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + token)
		.header("Content-Type", "application/json");

		response = request.body("{ \"userId\": \"" + USER_ID + "\", " +
				"\"collectionOfIsbns\": [ { \"isbn\": \"" + bookId + "\" } ]}")
				.post("/BookStore/v1/Books");
	}
	
	@Then("the book is added")
	public void the_book_is_added() {
		Assert.assertEquals(401, response.getStatusCode());
	}

///////////////////////////////////////////////////////////////////////////////////////

@Given("the user requests to {string} api on service {string}")
public void the_user_requests_to_api_on_service(String api, String application) {
	System.out.println("================================");
	System.out.println(api +""+application);
	declareApplicationAndSectionUnderTest(application, api);   
}

@And("the {string} {string} parameter is {string}")
public void the_parameter_is(String name, String placement, String value) {
	this.defineHttpParameter(name, placement, value);
}

@And("the payload is$")
public void the_payload_is(String payload) {
  
}

@When("the {string} request is sent")
public void the_request_is_sent(String string) {
    
}

@Then("the status code will be {string}")
public void the_status_code_will_be(String string) {
 
}


}
