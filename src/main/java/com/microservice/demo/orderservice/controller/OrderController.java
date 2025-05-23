package com.microservice.demo.orderservice.controller;


import com.microservice.demo.orderservice.service.OrderService;
import com.microservice.demo.orderservice.service.dto.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("{orderId}/status")
    public OrderStatus getOrderStatus(@PathVariable String orderId) {
        return orderService.getOrderStatus(orderId);
    }
}