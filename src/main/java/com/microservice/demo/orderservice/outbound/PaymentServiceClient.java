package com.microservice.demo.orderservice.outbound;

import com.microservice.demo.orderservice.outbound.dto.PaymentStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservices-payment-service-demo")
public interface PaymentServiceClient {

    @GetMapping("/api/payment/status/{orderId}")
    PaymentStatus getPaymentStatus(@PathVariable String orderId);
}
