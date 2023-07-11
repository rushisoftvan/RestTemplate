package com.rt.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/builder/api")
@RequiredArgsConstructor
@Slf4j
public class RestTempletBuilderExampleController {


    @Qualifier("withbuilder")
    private final RestTemplate restTemplate;

    @GetMapping("/restbuilderexample1")
    public void exampleBuilder1(){
        String url="/posts/1";
        ResponseEntity<String>  responseBody = this.restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        log.debug("body :: {}",responseBody.getBody());
        log.debug("statuscode :: {}  " ,responseBody.getStatusCode());

    }
}
