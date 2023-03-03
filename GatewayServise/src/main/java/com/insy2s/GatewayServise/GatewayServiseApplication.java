package com.insy2s.GatewayServise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class GatewayServiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiseApplication.class, args);
	}

}
