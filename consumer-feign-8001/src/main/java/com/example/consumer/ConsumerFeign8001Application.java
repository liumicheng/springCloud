package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConsumerFeign8001Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeign8001Application.class, args);
    }

}
