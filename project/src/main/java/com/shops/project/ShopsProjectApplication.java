package com.shops.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(basePackages = { "com.shops.project.*" }) // Scanning the component of project 
@EntityScan("com.shops.project.*")  // Scanning all entities 
@EnableJpaRepositories(basePackages = "com.shops.project.repositories") // Enabling and Scanning the repositories
@SpringBootApplication // Equivalent to using @Configuration, @EnableAutoConfiguration
public class ShopsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopsProjectApplication.class, args);
	}

}
