package com.precisely.gam.gamclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Application {
	public static void main(final String[] args) {	
		SpringApplication.run(Application.class, args);
	}
}