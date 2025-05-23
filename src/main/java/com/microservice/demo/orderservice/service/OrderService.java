package com.microservice.demo.orderservice.service;


import com.microservice.demo.orderservice.data.repository.OrderRepository;
import com.microservice.demo.orderservice.outbound.PaymentServiceClient;
import com.microservice.demo.orderservice.outbound.dto.PaymentStatus;
import com.microservice.demo.orderservice.service.dto.OrderStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class OrderService {

    private final PaymentServiceClient paymentServiceClient;
    private final OrderRepository orderRepository;

    public OrderStatus getOrderStatus(String orderId) {
        OrderStatus orderStatus = orderRepository.getOrderStatus(orderId);

        if (orderStatus == null) {
            return new OrderStatus(orderId, "NOT_FOUND", LocalDateTime.now());
        }

        // Fetch payment status from Payment Service
        try {
            PaymentStatus paymentStatus = paymentServiceClient.getPaymentStatus(orderId);
            orderStatus.setPaymentStatus(paymentStatus);
        } catch (Exception e) {
            // Handle service unavailable scenario
        }
        buildFallbackPayment(orderId, orderStatus);

        return orderStatus;
    }

    private static void buildFallbackPayment(String orderId, OrderStatus orderStatus) {
        PaymentStatus fallbackPayment = new PaymentStatus();
        fallbackPayment.setOrderId(orderId);
        fallbackPayment.setStatus("SERVICE_UNAVAILABLE");
        fallbackPayment.setAmount(0.0);
        fallbackPayment.setPaymentMethod("N/A");
        orderStatus.setPaymentStatus(fallbackPayment);
    }
}