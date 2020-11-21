package com.udacity.jwdnd.c1.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

	// Create a no-dependencies bean called "message"
	// should be a string like "Hello, Spring!"
	@Bean
	public String message() {
		System.out.println("Create message bean!");
		return "Hello, Spring!";
	}

	// add a bean called "uppercaseMessage" that depends on MessageService
	// should be a string that is the uppercase version of "message"
	// take MessageService as dependency:
	@Bean
	public String uppercaseMessage(MessageService msgService) {
		System.out.println("Create uppercaseMessage bean.");
		return msgService.uppercase();
	}

	@Bean
	// add a bean called "lowercaseMessage" that depends on MessageService
	// should be a string that is the lowercase version of "message"
	public String lowercaseMessage(MessageService msgService) {
		System.out.println("Create lowercaseMessage bean.");
		return msgService.lowercase();
	}
}

//	@Primary
//	@Bean
//	public String basicMessage() {
//		System.out.println("inside basicMessage");
//		return "Hello";
//	}
//
//	@Bean
//	public String compoundMessage(String basicMessage) {
//		System.out.println("inside compoundMessage, received: " + basicMessage);
//		return basicMessage + ", Spring!";
//	}
//
//	@Bean
//	public int characterCount(String message) {
//		return message.length();
//	}
