package com.microservice.demo.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.microservice.demo.orderservice.outbound")
public class MicroservicesOrderServiceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicesOrderServiceDemoApplication.class, args);
    }

}
