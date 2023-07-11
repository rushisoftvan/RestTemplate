package com.rt.controller;

import com.rt.Dto.response.ApiResponse;
import com.rt.pojo.UserPojo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class RestTempleteExampleController {

      private  final RestTemplate restTemplate;
    @GetMapping("/example1")
    public String example1(){
       String url = "https://jsonplaceholder.typicode.com/posts/1";

        ResponseEntity<String> exchange = this.restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        log.debug("statuscode :: {}",exchange.getStatusCode());
        log.debug("body : {}",exchange.getBody());
        return "ok";
    }

    /*
     * In this example we are mentioning that take response data as TaskDTO object and we are metnioning only those properties in UserPojo
     * class that we need from response.
     * Suppose response type class has 100 properties but we need only 5 so we will take only 5 properties in our created class (Ex : UserPojo)
     */

    @GetMapping("/example2")
    public ApiResponse<UserPojo> example2()
    {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        UserPojo forObject = this.restTemplate.getForObject(url, UserPojo.class);
        System.out.println(forObject.getBody());
        System.out.print(forObject.getTitle());
        System.out.println(forObject.getUserId());
        ApiResponse.ApiResponseBuilder<UserPojo> builder = ApiResponse.builder();
        return builder.data(forObject).statusCode(HttpStatus.OK.value()).build();

    }

    /*
     * If any one returning List as top node then give response type as array and after that convert that array into list as shown below
     * why we need to convert into list because if you print array then you may see there less records but when you convert into list then
     * you will see all records
     *//*
     * If any one returning List as top node then give response type as array and after that convert that array into list as shown below
     * why we need to convert into list because if you print array then you may see there less records but when you convert into list then
     * you will see all records
     */

    @GetMapping("/example3")
    public ApiResponse<List<UserPojo>> listExample3(){

        String url ="https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<UserPojo[]> responseBody = this.restTemplate.exchange(url, HttpMethod.GET, null, UserPojo[].class);
        UserPojo[] userArray = responseBody.getBody();
          List<UserPojo> users = Arrays.asList(userArray);
          log.debug("User :: {}",users);
          ApiResponse.ApiResponseBuilder<List<UserPojo>> builder  = ApiResponse.builder();
          return builder.data(users).statusCode(HttpStatus.OK.value()).build();
    }



}
