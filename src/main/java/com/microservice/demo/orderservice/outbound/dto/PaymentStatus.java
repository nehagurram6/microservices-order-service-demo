package com.microservice.demo.orderservice.outbound.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentStatus {
    private String orderId;
    private String status;
    private Double amount;
    private String paymentMethod;
}