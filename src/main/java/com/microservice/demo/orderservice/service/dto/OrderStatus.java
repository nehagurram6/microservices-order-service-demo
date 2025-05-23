package com.microservice.demo.orderservice.service.dto;

import com.microservice.demo.orderservice.outbound.dto.PaymentStatus;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class OrderStatus {
    private String orderId;
    private String status; // PROCESSING, CONFIRMED, SHIPPED, DELIVERED, NOT_FOUND
    private LocalDateTime orderDate;
    private PaymentStatus paymentStatus;

    public OrderStatus(String orderId, String status, LocalDateTime orderDate) {
        this.orderId = orderId;
        this.status = status;
        this.orderDate = orderDate;
    }
}