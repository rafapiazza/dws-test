package com.rafapiazza.isobar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.rafapiazza.isobar.repository")
@EnableRedisRepositories(basePackages = "com.rafapiazza.isobar.redis.repository")
public class IsobarApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsobarApplication.class, args);
	}

}
