package com.airlines;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages= {"com.airlines.config","com.airlines.controllers","com.airlines.dao","com.airlines.pojos","com.airlines.repos"})

@SpringBootApplication
public class AirlinesBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlinesBootApplication.class, args);
	}
}
