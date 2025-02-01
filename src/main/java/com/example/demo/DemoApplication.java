package com.example.demo;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@Configuration
@PropertySource("classpath:application.properties")
public class DemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

}
