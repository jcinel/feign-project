package com.example.cats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatsApplication.class, args);
	}

}
