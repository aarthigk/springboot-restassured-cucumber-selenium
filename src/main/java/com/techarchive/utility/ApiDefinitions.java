package com.techarchive.utility;

import java.util.HashMap;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import com.techarchive.config.Application;

import io.restassured.RestAssured;



@ContextConfiguration(classes = Application.class)
//@Component
public abstract class ApiDefinitions {
	
//	public String apiBaseUrl="https://petstore.swagger.io/v2";
//	public String uri="/pet";
	@Autowired(required=false)
	private TestExecutionContext testExecutionContext;


	public void declareApplicationUnderTest(String application) {
		this.testExecutionContext.setApplication(application);
	}

	public void declareApplicationAndSectionUnderTest(String application, String section) {
//		testExecutionContext = new TestExecutionContext();
//		testExecutionContext.setApplication(application);
//	//	Object lion = context.getBean("lion");
		
		System.out.println("Inside the method");
	this.testExecutionContext.setApplication(application);
	this.testExecutionContext.setSection(section);
	}
	
	public void configureHttpClient() {
		testExecutionContext.setHttpRequestSpecification(RestAssured.given().relaxedHTTPSValidation());
	}
	
	public void defineHttpParameter(String name, String placement, Object value) {
		io.restassured.specification.RequestSpecification requestSpecification = testExecutionContext
				.getHttpRequestSpecification();
		if ("path".equalsIgnoreCase(placement)) {
			requestSpecification.pathParam(name, value);
		} else if ("header".equalsIgnoreCase(placement)) {
			requestSpecification.header(name, value);
		} else if ("payload".equalsIgnoreCase(placement)) {
			testExecutionContext.addHttpRequestBodyParameter(name, value);
		} else if ("payload-json".equalsIgnoreCase(placement)) {
			testExecutionContext.addHttpRequestBody(value);
		}
	}
	
	
}
