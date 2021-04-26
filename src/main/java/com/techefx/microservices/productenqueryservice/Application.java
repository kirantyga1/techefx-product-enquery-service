package com.techefx.microservices.productenqueryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.techefx.microservices.productenqueryservice")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
