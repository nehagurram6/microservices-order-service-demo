package com.microservice.demo.orderservice.data.repository;

import com.microservice.demo.orderservice.service.dto.OrderStatus;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepository {

    // Mock order data
    private final Map<String, OrderStatus> orderDatabase = new HashMap<>();

    @PostConstruct
    public void init() {
        mockOrders();
    }

    private void mockOrders() {
        orderDatabase.put("ORDER001", new OrderStatus("ORDER001", "PROCESSING", LocalDateTime.now().minusHours(2)));
        orderDatabase.put("ORDER002", new OrderStatus("ORDER002", "CONFIRMED", LocalDateTime.now().minusHours(1)));
        orderDatabase.put("ORDER003", new OrderStatus("ORDER003", "SHIPPED", LocalDateTime.now().minusDays(1)));
        orderDatabase.put("ORDER004", new OrderStatus("ORDER004", "DELIVERED", LocalDateTime.now().minusDays(3)));
    }

    public OrderStatus getOrderStatus(String orderId) {
        return orderDatabase.get(orderId);
    }

    public void updateOrderStatus(OrderStatus orderStatus) {
        orderDatabase.put(orderStatus.getOrderId(), orderStatus);
    }

    public void deleteOrderStatus(String orderId) {
        orderDatabase.remove(orderId);
    }

    public Map<String, OrderStatus> getAllOrders() {
        return orderDatabase;
    }
}
