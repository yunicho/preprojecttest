package com.example.preporojecttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PreporojecttestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreporojecttestApplication.class, args);
	}

}
