package com.tienda.online;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.tienda.online.repositories.mongo")
@SpringBootApplication
public class OnlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineApplication.class, args);
	}

}
