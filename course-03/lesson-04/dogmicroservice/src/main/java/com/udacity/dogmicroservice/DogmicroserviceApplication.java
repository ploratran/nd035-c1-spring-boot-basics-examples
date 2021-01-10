package com.udacity.dogmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // this is optional due to spring-cloud-starter-netflix-eureka-client dependencies
public class DogmicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogmicroserviceApplication.class, args);
	}

}
