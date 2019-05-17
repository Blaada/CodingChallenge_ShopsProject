package com.shops.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.shops.project.*" })
@EntityScan("com.shops.project.models")  
@EnableJpaRepositories(basePackages = "com.shops.project.repo")
public class ShopsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopsProjectApplication.class, args);
	}

}
