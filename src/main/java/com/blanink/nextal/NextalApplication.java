package com.blanink.nextal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NextalApplication {

	public static void main(String[] args) {
		SpringApplication.run(NextalApplication.class, args);
	}

}
