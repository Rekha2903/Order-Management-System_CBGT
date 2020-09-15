package com.project.ordermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EnableEurekaClient
public class OrderItemMicroserviceApplication {

	public static void main(String[] args) {
		log.info("Inside OrderItemMicroserviceApplication");
		SpringApplication.run(OrderItemMicroserviceApplication.class, args);
	}

}
