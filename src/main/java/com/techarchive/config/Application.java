package com.techarchive.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



import com.techarchive.utility.TestExecutionContext;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = { "com.techarchive" })
public class Application {
	//private TestExecutionContext testExecutionContext;
	
	private String ecommerceurl;
	private String petstoreapiurl;
	private String googleurl;
	

	@Bean
	public TestExecutionContext testExecutionContext() {
		TestExecutionContext foo = new TestExecutionContext();
	
		System.out.println("Inside Bean Aplication");
	//	testExecutionContext = new TestExecutionContext();
		return foo;
		
	}
		
	@Bean
	Map<String, String> propositionsUrls() {
		Map<String, String> answer = new HashMap<>();
		answer.put("ecommerce", ecommerceurl);
		answer.put("google", googleurl);
		return answer;
	}
	
	@Bean
	Map<String, String> apisBaseUrl() {
		Map<String, String> answer = new HashMap<>();
		answer.put("petstore", petstoreapiurl);
		return answer;
}
}
