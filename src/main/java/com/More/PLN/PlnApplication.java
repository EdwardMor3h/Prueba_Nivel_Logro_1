package com.More.PLN;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PlnApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlnApplication.class, args);
	}

}
