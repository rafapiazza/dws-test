package com.rafapiazza.isobar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class IsobarApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsobarApplication.class, args);
	}

}
