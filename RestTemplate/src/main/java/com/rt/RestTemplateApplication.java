package com.rt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestTemplateApplication {

	@Bean("withoutBuilder")
	public RestTemplate getRestTemplete(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateApplication.class, args);
	}

}
