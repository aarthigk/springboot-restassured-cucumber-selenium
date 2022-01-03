package com.techarchive.utility;



import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import io.cucumber.messages.internal.com.google.gson.Gson;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

/**
 * Defining a bean with singleton scope means the container creates a single
 * instance of that bean, and all requests for that bean name will return the
 * same object. This in essence will hold the state of our test while under
 * execution
 */
@Scope(scopeName = "SCOPE_SINGLETON", proxyMode = ScopedProxyMode.DEFAULT)
//@Component
public class TestExecutionContext {
	

	String application;
	String section;
	private RequestSpecification requestSpecification;
	private ValidatableResponse setResponseSpecification;
	
	public void setSection(String section) {
		this.section = section;
	}
	
//	@Autowired
//	private Map<String, String> apisBaseUrl;
//	
//	@Autowired
//	private Map<String, String> propositionsUrls;
	
	private Map<String, Object> requestBodyPayload = new HashMap<>();
	
	public void setApplication(String application) {
		this.application = application;
		System.out.println(this.application);
	}
	
	public io.restassured.specification.RequestSpecification getHttpRequestSpecification() {
	//	Assert.assertNotNull("Request specification must be defined as a first", this.requestSpecification);
		return this.requestSpecification;
	}
	public void setHttpRequestSpecification(io.restassured.specification.RequestSpecification requestSpecification) {
		this.requestSpecification = requestSpecification;
	}
	
	public void setResponseSpecification(ValidatableResponse validatableResponse) {
		this.setResponseSpecification = validatableResponse;
	}

	public ValidatableResponse getResponseSpecification() {
		return setResponseSpecification;
	}
	
	public Map<String, Object> getHttpRequestBodyPayload() {
		return requestBodyPayload;
	}
	
	public void addHttpRequestBodyParameter(String name, Object value) {
		this.requestBodyPayload.put(name, value);
	}

	@SuppressWarnings("unchecked")
	public void addHttpRequestBody(Object value) {
		this.requestBodyPayload = new Gson().fromJson((String) value, Map.class);
	}
	
	
}
