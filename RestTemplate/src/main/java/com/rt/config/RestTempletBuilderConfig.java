package com.rt.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplateHandler;

import java.time.Duration;

@Configuration
public class RestTempletBuilderConfig {

    @Bean("withbuilder")
    @Primary
    public RestTemplate  restTemplete (RestTemplateBuilder builder){
        RootUriTemplateHandler rootUriTemplateHandler = new RootUriTemplateHandler("https://jsonplaceholder.typicode.com");
        return builder.uriTemplateHandler(rootUriTemplateHandler).setConnectTimeout(Duration.ofMillis(2000)).build();
    }
}
