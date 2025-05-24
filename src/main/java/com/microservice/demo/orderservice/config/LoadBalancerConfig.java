package com.microservice.demo.orderservice.config;


import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@LoadBalancerClient(name = "microservices-payment-service-demo")
public class LoadBalancerConfig {
}