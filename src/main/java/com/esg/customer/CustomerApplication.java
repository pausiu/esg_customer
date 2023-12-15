package com.esg.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
public class CustomerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CustomerApplication.class, args);
		CustomerFileReader.readFromFile();
	}
	
}
