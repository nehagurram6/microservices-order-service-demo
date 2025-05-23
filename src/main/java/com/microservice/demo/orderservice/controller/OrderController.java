package com.microservice.demo.orderservice.controller;


import com.microservice.demo.orderservice.service.OrderService;
import com.microservice.demo.orderservice.service.dto.OrderStatus;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @GetMapping("{orderId}/status")
    public OrderStatus getOrderStatus(@PathVariable String orderId) {
        return orderService.getOrderStatus(orderId);
    }
}