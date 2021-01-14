package com.example.consuming;

import com.example.consuming.entity.Dog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumingApplication.class, args);
	}

	// RestTemplateBuilder is injected by Spring:
	// benefit all auto config of Spring Boot:
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	// CommandLineRunner callback method executed by Spring Boot on startup:
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			// makes call out to Dog API using Rest Template:
			Dog randomDog = restTemplate.getForObject(
					"https://dog.ceo/api/breeds/image/random", Dog.class);
			// print out dog on commandline:
			log.info(randomDog.toString());
		};
	}


}
